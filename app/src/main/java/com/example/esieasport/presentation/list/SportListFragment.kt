package com.example.esieasport.presentation.list

import SportAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esieasport.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SportListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = SportAdapter(listOf())

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.sport_recyclerview)

        recyclerView.apply {
            layoutManager= this@SportListFragment.layoutManager
            adapter = this@SportListFragment.adapter
        }

        val muscleList = arrayListOf<Sport>().apply{
            add(Sport("muscle1"))
            add(Sport("muscle2"))
            add(Sport("muscle3"))
            add(Sport("muscle4"))
        }

        adapter.updateList(muscleList)
    }

}