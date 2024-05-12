package com.example.usercentrics.domain.model

import androidx.compose.runtime.Stable

@Stable
data class ConsentModel (
    val totalCostEachService : Double,
    val eachServiceNameCost : Map<String, Int>,
    val rulesCost : Double
)