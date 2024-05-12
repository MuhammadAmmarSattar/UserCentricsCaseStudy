package com.example.usercentrics.domain.calculation.ruleStrategy

import android.util.Log
import com.example.usercentrics.domain.calculation.CostCalculationRule

class GoodCitizenRule : CostCalculationRule {
    override fun applyRule(baseCost: Double, dataTypes: List<String>): Double {
        var cost = baseCost
        if (dataTypes.size <= 4) {
            cost -= (cost * 0.10)
        }
        return cost
    }
}