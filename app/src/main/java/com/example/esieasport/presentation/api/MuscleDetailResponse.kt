package com.example.esieasport.presentation.api

import com.example.esieasport.presentation.list.Exercise

class MuscleDetailResponse (

        val count: Int,
        val next: String,
        val results: List<Exercise>
)
