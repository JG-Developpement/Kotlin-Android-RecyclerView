package com.jgdeveloppement.jg_road.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jgdeveloppement.jg_road.databinding.FragmentDeliveryListBinding
import com.jgdeveloppement.jg_road.models.Delivery

class DeliveryListFragment : Fragment() {

    private var _binding: FragmentDeliveryListBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding = FragmentDeliveryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        val deliveryList = listOf(
            Delivery(1, "Julien Gorin", "51 rue soldat Ferrari", "Hyeres", "83400", "standard"),
            Delivery(2, "Richard Gorin", "26 impasse les figuiéres", "la Farléde", "83210", "standard"),
            Delivery(3, "Cedric Gorin", "51 rue Ambroisse Thomas", "Hyeres", "83400", "express"),
            Delivery(4, "Brigitte Gorin", "51 rue du Paradis", "Toulon", "83000", "saver")
        )

        Log.i("DEBUGGG", deliveryList[1].toString())

        binding.deliveryRecyclerView.adapter = DeliveryAdapter(context as MainActivity, deliveryList)
    }

}