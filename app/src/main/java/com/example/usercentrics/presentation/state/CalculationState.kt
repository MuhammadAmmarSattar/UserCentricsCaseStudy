package com.example.usercentrics.presentation.state

import androidx.compose.runtime.Stable

/**
 * Data class representing the state of a calculation process for the View.
 * @property totalCost The total cost calculated.
 * @property serviceEachCostAndName The name and cost of each service.
 * @property eachCost The cost of each service.
 */
@Stable
data class CalculationState(
     val totalCost : Double?=0.0,
     val serviceEachCostAndName : String?=null,
     val eachCost : Double?=0.0
)