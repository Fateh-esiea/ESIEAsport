package com.example.esieasport.presentation.list

import ExerciseAdapter
import SportAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esieasport.R
import com.example.esieasport.presentation.api.MuscleListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = SportAdapter(listOf(), ::onClickedMuscle)


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
            layoutManager = LinearLayoutManager(context)
            adapter = this@SportListFragment.adapter


        }

        Singleton.sportApi.getMuscleList().enqueue(object : Callback<MuscleListResponse> {


            override fun onFailure(call: Call<MuscleListResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<MuscleListResponse>, response: Response<MuscleListResponse>) {
                if (response.isSuccessful && response.body() != null) {

                    val muscleListResponse = response.body()!!
                    adapter.updateList(muscleListResponse.results)
                }

            }

        })


        // val muscleList = arrayListOf<Muscle>().apply {
    }

        private fun onClickedMuscle(sport: Sport) {
            findNavController().navigate(R.id.navigateToExerciseDetailFragment)
        }
    }

