package com.example.usercentrics.domain.model

import androidx.compose.runtime.Stable


/**
 * data class representing the consent model.
 * @property totalCostEachService The total cost for each service.
 * @property serviceCostMap Map containing the cost for each service.
 * @property rulesCost The total cost based on rules applied.
 */
@Stable
data class ConsentModel (
    val totalCostEachService : Double,
    val eachServiceNameAndCost : Map<String, Int>,
    val rulesCost : Double
)