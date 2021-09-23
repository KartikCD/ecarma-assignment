package io.kartikcd.ecarmaassignment.ui.mainfeed.community

import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.kartikcd.ecarmaassignment.R
import io.kartikcd.ecarmaassignment.adapter.AssetListAdapter
import io.kartikcd.ecarmaassignment.adapter.CommunityListAdapter
import io.kartikcd.ecarmaassignment.databinding.FragmentAddCommunityBinding
import io.kartikcd.ecarmaassignment.databinding.FragmentCommunityDetailsBinding
import io.kartikcd.ecarmaassignment.models.Community

class CommunityDetailsFragment : Fragment() {

    private var _binding: FragmentCommunityDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.colorPrimaryDark)
        }
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_back_arrow)
        drawable?.setColorFilter(ContextCompat.getColor(requireContext(), R.color.black), PorterDuff.Mode.SRC_ATOP)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(drawable)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Community Details"
        _binding = FragmentCommunityDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val assets = listOf(
            "Association",
            "Block details",
            "Manpower",
            "Assets",
            "Amenities",
            "AMC",
            "Documents"
        )

        val communityListAdapter = AssetListAdapter()

        binding.recyclerviewAssets.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = communityListAdapter
        }

        communityListAdapter.submitList(assets)

        communityListAdapter.setOnAssetClickListener {
            println("Debug $it")
            if (it == "Association") {
                findNavController().navigate(R.id.action_communityDetailsFragment_to_associationDetailFragment)
            } else if (it == "Block details") {
                findNavController().navigate(R.id.action_communityDetailsFragment_to_addBlockFragment)
            }
        }
    }

}