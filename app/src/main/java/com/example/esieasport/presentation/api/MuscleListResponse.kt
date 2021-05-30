package com.example.esieasport.presentation.api

import com.example.esieasport.presentation.list.Sport

class MuscleListResponse (
    val count: Int,
    val next: String,
    val results: List<Sport>
)
