package com.example.usercentrics.domain.calculation.ruleStrategy

import android.util.Log
import com.example.usercentrics.domain.calculation.CostCalculationRule

/**
 * Implementation of CostCalculationRule for applying a good citizen rule.
 * Decreases the cost by 10% if the number of data types is less than or equal to 4.
 */
class GoodCitizenRule : CostCalculationRule {
    override fun applyRule(baseCost: Double, dataTypes: List<String>): Double {
        var cost = baseCost
        if (dataTypes.size <= 4) {
            cost -= (cost * 0.10)
        }
        return cost
    }
}