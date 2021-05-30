package com.example.esieasport.presentation.api

import com.example.esieasport.presentation.list.Muscle

class MuscleListResponse (
    val count: Int,
    val next: String,
    val results: List<Muscle>
)
