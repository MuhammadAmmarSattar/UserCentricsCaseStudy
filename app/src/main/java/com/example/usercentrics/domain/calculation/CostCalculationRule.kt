package com.example.usercentrics.domain.calculation

/**
 * interface for defining cost calculation rules.
 * implementations of this interface should apply a specific rule
 * to calculate the cost based on the provided base cost and data types.
 */
interface CostCalculationRule {
    /**
     * applies the cost calculation rule.
     *
     * @param baseCost The base cost to which the rule is applied.
     * @param dataTypes The list of data types used to calculate the cost.
     * @return The calculated cost after applying the rule.
     */
    fun applyRule(baseCost: Double, dataTypes: List<String>): Double
}