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
import io.kartikcd.ecarmaassignment.adapter.CommunityListAdapter
import io.kartikcd.ecarmaassignment.databinding.FragmentCommunityBinding
import io.kartikcd.ecarmaassignment.databinding.FragmentCommunityMainBinding
import io.kartikcd.ecarmaassignment.models.Community

class CommunityFragment : Fragment() {

    private var _binding: FragmentCommunityBinding? = null
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
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Community"
        _binding = FragmentCommunityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val communities = listOf(
            Community("Brigade Sympony", true),
            Community("Community 2", false),
            Community("Community 3", false),
            Community("Community 4", false),
            Community("Community 5", false)
        )

        val communityListAdapter = CommunityListAdapter()

        binding.recyclerviewCommunity.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = communityListAdapter
        }

        communityListAdapter.submitList(communities)

        communityListAdapter.setOnCommunityClickListener {
            findNavController().navigate(R.id.action_communityFragment_to_communityDetailsFragment)
        }

        binding.buttonAddCommunity.setOnClickListener {
            findNavController().navigate(R.id.action_communityFragment_to_addCommunityFragment)
        }
    }

}