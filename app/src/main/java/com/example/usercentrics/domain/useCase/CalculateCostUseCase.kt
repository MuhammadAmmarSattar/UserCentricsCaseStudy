package com.example.usercentrics.domain.useCase

import com.example.usercentrics.domain.calculation.CostCalculationRule
import com.example.usercentrics.domain.model.ConsentModel
import com.example.usercentrics.domain.model.DataType
import com.example.usercentrics.utils.AppConstant.dataTypeCosts
import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.v2.settings.data.UsercentricsService

class CalculateCostUseCase(private val rules: List<CostCalculationRule>) {
    fun execute(dataTypes: List<String>): ConsentModel{
        // Initialize the base cost to zero
        var cost = 0.0
        var totalEachServiceCost = 0.0
        // Filter service costs based on data types
        val serviceCosts = filterServiceCosts(dataTypes)
//        printFilteredServiceCosts(serviceCosts)
        // Calculate the base cost
        cost = calculateBaseCost(dataTypes)
        totalEachServiceCost = calculateBaseCost(dataTypes)
//        println("Each Service Total cost = $cost")
        // Apply rules using the strategy pattern
        rules.forEach { rule ->
            cost = rule.applyRule(cost, dataTypes)
        }
        cost = cost.coerceAtLeast(0.0)
        // Ensure non-negative cost
        return ConsentModel(totalCostEachService = totalEachServiceCost, eachServiceNameCost = serviceCosts,
            rulesCost = cost)
    }
    private fun filterServiceCosts(dataTypes: List<String>): Map<String, Int> {
        val serviceCosts = mutableMapOf<String, Int>()
        dataTypeCosts.forEach { (dataType, cost) ->
            if (dataTypes.contains(dataType)) {
                serviceCosts[dataType] = cost
            }
        }
        return serviceCosts
    }


}
fun calculateBaseCost(dataTypes: List<String>): Double {
    var baseCost = 0.0
    dataTypes.forEach { dataType ->
        baseCost += when (dataType) {
            DataType.CONFIGURATION_OF_APP_SETTINGS -> 1
            DataType.IP_ADDRESS -> 2
            DataType.USER_BEHAVIOUR ->2
            DataType.USER_AGENT -> 3
            DataType.APP_CRASHES -> -2 // Negative cost
            DataType.BROWSER_INFORMATION -> 3
            DataType.CREDIT_AND_DEBIT_CARD_NUMBER -> 4
            DataType.FIRST_NAME -> 6
            DataType.GEOGRAPHIC_LOCATION -> 7
            DataType.DATE_TIME_OF_VISIT -> 1
            DataType.ADVERTISING_IDENTIFIER -> 2
            DataType.BANK_DETAILS -> 5
            DataType.PURCHASE_ACTIVITY -> 6
            DataType.INTERNET_SERVICE_PROVIDER -> 4
            DataType.JAVASCRIPT_SUPPORT -> -1 // Negative cost
            else -> 0
        }
    }
    return baseCost
}


