package com.example.usercentrics.domain.useCase

import com.example.usercentrics.domain.calculation.CostCalculationRule
import com.example.usercentrics.domain.model.ConsentModel
import com.example.usercentrics.domain.model.DataType
import com.example.usercentrics.utils.AppConstant.dataTypeCosts
import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.v2.settings.data.UsercentricsService

/**
 * Use case for calculating consent cost based on provided data types and rules.
 * @property rules List of cost calculation rules to apply.
 */
class CalculateCostUseCase(private val rules: List<CostCalculationRule>) {
    /**
     * Executes the calculation of consent cost.
     * @param dataTypes List of data types for which consent is being calculated.
     * @return ConsentModel representing the calculated consent cost.
     */
    fun execute(dataTypes: List<String>): ConsentModel {
        // initialize the base cost to zero
        var cost = 0.0
        var totalEachServiceCost = 0.0
        // filter service costs based on data types
        val serviceCosts = filterServiceCosts(dataTypes)
        // ccalculate the base cost
        cost = calculateBaseCost(dataTypes)
        totalEachServiceCost = calculateBaseCost(dataTypes)
        // applying rules using the strategy pattern....
        rules.forEach { rule ->
            cost = rule.applyRule(cost, dataTypes)
        }
        // not-negative cost
        cost = cost.coerceAtLeast(0.0)
        return ConsentModel(
            totalCostEachService = totalEachServiceCost,
            eachServiceNameAndCost = serviceCosts,
            rulesCost = cost
        )
    }

    /**
     * Filters service costs based on provided data types.
     * @param dataTypes List of data types for which service costs are filtered.
     * @return Map containing filtered service names and their respective costs.
     */
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
/**
 * Calculates the base cost based on provided data types.
 * @param dataTypes List of data types for which base cost is calculated.
 * @return The calculated base cost.
 */
fun calculateBaseCost(dataTypes: List<String>): Double {
    var baseCost = 0.0
    dataTypes.forEach { dataType ->
        baseCost += when (dataType) {
            DataType.CONFIGURATION_OF_APP_SETTINGS -> 1
            DataType.IP_ADDRESS -> 2
            DataType.USER_BEHAVIOUR -> 2
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


