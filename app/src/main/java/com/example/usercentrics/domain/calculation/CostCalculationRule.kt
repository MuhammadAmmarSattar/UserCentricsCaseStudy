package com.example.usercentrics.domain.calculation

interface CostCalculationRule {
    fun applyRule(baseCost: Double, dataTypes: List<String>): Double
}