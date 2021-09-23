package io.kartikcd.ecarmaassignment.ui.mainfeed.community.association

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
import io.kartikcd.ecarmaassignment.adapter.AssociationListAdapter
import io.kartikcd.ecarmaassignment.databinding.FragmentAssociationDetailBinding
import io.kartikcd.ecarmaassignment.databinding.FragmentCommunityDetailsBinding
import io.kartikcd.ecarmaassignment.models.Association

class AssociationDetailFragment : Fragment() {

    private var _binding: FragmentAssociationDetailBinding? = null
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
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Association Details"
        _binding = FragmentAssociationDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val associations = listOf(
            Association("President", "Rahul Raj", "Flat 314", "9987746997", "xyz@gmail.com"),
            Association("Vice President", "Ankit Gupta", "Flat 318", "8116162777", "xyz@gmail.com")
        )

        val associationAdapter = AssociationListAdapter()

        binding.recyclerviewAssociations.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = associationAdapter
        }

        associationAdapter.submitList(associations)

        binding.buttonAddAssociation.setOnClickListener {
            findNavController().navigate(R.id.action_associationDetailFragment_to_addAssociationDetailFragment)
        }
    }

}