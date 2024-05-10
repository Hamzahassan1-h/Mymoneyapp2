package com.example.mymoneyapp.ui.People

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymoneyapp.R
import com.example.mymoneyapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root : View = binding.root

      binding.apply {
          homeViewModel.roomList.observe(viewLifecycleOwner){
              mvPerson.apply {
                  layoutManager = LinearLayoutManager(context)
                  adapter = HomeAdapter(it) {RoomItemModel ->
                      findNavController().navigate(
                          R.id.navigation_home
                      )
                  }
              }
          }
      }

//    val textView: TextView = binding.textHome
//    homeViewModel.text.observe(viewLifecycleOwner) {
//      textView.text = it
//    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}