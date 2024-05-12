package com.example.usercentrics.presentation.state

import androidx.compose.runtime.Stable

@Stable
data class CalculationState(
     val totalCost : Double?=0.0,
     val serviceEachCostAndName : String?=null,
     val eachCost : Double?=0.0
)