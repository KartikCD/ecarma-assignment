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
import io.kartikcd.ecarmaassignment.R
import io.kartikcd.ecarmaassignment.databinding.FragmentCommunityMainBinding
import io.kartikcd.ecarmaassignment.databinding.FragmentMainFeedBinding

class CommunityMainFragment : Fragment() {

    private var _binding: FragmentCommunityMainBinding? = null
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
//        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_back_arrow)
//        drawable?.setColorFilter(ContextCompat.getColor(requireContext(), R.color.black), PorterDuff.Mode.SRC_ATOP)
//        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(drawable)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Community"
        _binding = FragmentCommunityMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_communityMainFragment_to_communityFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}