package com.example.mymoneyapp.ui.Room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymoneyapp.R
import com.example.mymoneyapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

private var _binding: FragmentDashboardBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

      binding.apply{
          dashboardViewModel.personList.observe(viewLifecycleOwner) {
              rvPerson.apply {
                  layoutManager = LinearLayoutManager(context)
                  adapter = DashboardAdapter(it) { PersonModelItemModel ->
                      findNavController().navigate(
                          R.id.navigation_dashboard
                      )
                  }
              }
          }
      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}