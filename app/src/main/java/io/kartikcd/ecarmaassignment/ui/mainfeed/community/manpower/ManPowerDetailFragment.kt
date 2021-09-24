package io.kartikcd.ecarmaassignment.ui.mainfeed.community.manpower

import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import io.kartikcd.ecarmaassignment.R
import io.kartikcd.ecarmaassignment.adapter.ManpowerListAdapter
import io.kartikcd.ecarmaassignment.databinding.FragmentAddCommunityBinding
import io.kartikcd.ecarmaassignment.databinding.FragmentManPowerDetailBinding

class ManPowerDetailFragment : Fragment() {

    private var _binding: FragmentManPowerDetailBinding? = null
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
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Basic Community Details"
        _binding = FragmentManPowerDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val manpowers = listOf("Housekeeping", "Security", "Electrician", "Plumber", "Gardener")

        val manpowerAdapter = ManpowerListAdapter()

        binding.recyclerviewManpower.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = manpowerAdapter
        }

        binding.tabLayout.getTabAt(0)?.icon = requireActivity().getDrawable(R.drawable.ic_community)
        binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_profile_ic)
        binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_assets)
        binding.tabLayout.getTabAt(3)?.setIcon(R.drawable.ic_amenities)

        manpowerAdapter.submitList(manpowers)
    }
}