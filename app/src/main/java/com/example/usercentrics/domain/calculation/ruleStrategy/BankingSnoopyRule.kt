package com.example.usercentrics.domain.calculation.ruleStrategy

import com.example.usercentrics.domain.calculation.CostCalculationRule
import com.example.usercentrics.utils.AppConstant.BANK_DETAILS
import com.example.usercentrics.utils.AppConstant.CREDIT_DEBIT_CARD_NUMBER
import com.example.usercentrics.utils.AppConstant.PURCHASE_ACTIVITY

class BankingSnoopyRule : CostCalculationRule {
    override fun applyRule(baseCost: Double, dataTypes: List<String>): Double {
        var cost = baseCost
        if (dataTypes.containsAll(listOf(PURCHASE_ACTIVITY, BANK_DETAILS, CREDIT_DEBIT_CARD_NUMBER))) {
            cost += (cost * 0.10)
        }
        return cost
    }
}