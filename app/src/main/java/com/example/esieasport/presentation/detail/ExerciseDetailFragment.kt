package com.example.esieasport.presentation.detail

import ExerciseAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esieasport.R
import com.example.esieasport.presentation.api.MuscleDetailResponse
import com.example.esieasport.presentation.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ExerciseDetailFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    //private lateinit var textViewName: TextView

    private val adapter = ExerciseAdapter(listOf(), ::onClickedMuscle)




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.exercise_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ExerciseDetailFragment.adapter
        }

        callApi()
    }

   private fun callApi() {
        Singleton.sportApi.getMuscleDetail(id).enqueue(object : Callback<MuscleDetailResponse> { //"10" la parenthèse

            override fun onFailure(call: Call<MuscleDetailResponse>, t: Throwable) {
                //TODO("Not yet implemented")

            }

            override fun onResponse(call: Call<MuscleDetailResponse>, response: Response<MuscleDetailResponse>) {
                if (response.isSuccessful && response.body() != null) {

                    val muscleDetailResponse = response.body()!!
                    adapter.updateList(muscleDetailResponse.results)

                }
            }
        })
    }

    private fun onClickedMuscle(id: Int) {
        findNavController().navigate(R.id.navigateToExerciseDetailFragment)
    }
}



