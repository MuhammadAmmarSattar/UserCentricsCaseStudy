package com.example.usercentrics.domain.calculation.ruleStrategy

import android.util.Log
import com.example.usercentrics.domain.calculation.CostCalculationRule
import com.example.usercentrics.utils.AppConstant.GEOGRAPHIC_LOCATION
import com.example.usercentrics.utils.AppConstant.IP_ADDRESS
import com.example.usercentrics.utils.AppConstant.SEARCH_TERMS

class WhyDoYouCareRule : CostCalculationRule {
    override fun applyRule(baseCost: Double, dataTypes: List<String>): Double {
        var cost = baseCost
        if (dataTypes.containsAll(listOf(SEARCH_TERMS, GEOGRAPHIC_LOCATION, IP_ADDRESS))) {
            cost += (cost * 0.27)
        }
        return cost
    }
}