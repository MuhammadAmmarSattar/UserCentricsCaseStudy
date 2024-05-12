package com.example.usercentrics.domain.calculation.ruleStrategy

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WhyDoYouCareRuleTest {

    @Test
    fun `test applyRule when all required dataTypes are present`() {
        // Arrange
        val rule = WhyDoYouCareRule()
        val baseCost = 100.0
        val dataTypes = listOf("Search terms", "Geographic location", "IP address")
        // Act
        val result = rule.applyRule(baseCost, dataTypes)
        // Assert
        val expectedCost = baseCost + (baseCost * 0.27)
        assertEquals(expectedCost, result, 0.01) // Use delta for double comparison
    }

    @Test
    fun `test applyRule when not all required dataTypes are present`() {
        // Arrange
        val rule = WhyDoYouCareRule()
        val baseCost = 100.0
        val dataTypes = listOf("Search terms", "IP address") // Missing "Geographic location"
        // Act
        val result = rule.applyRule(baseCost, dataTypes)
        // Assert
        assertEquals(baseCost, result, 0.01) // No change expected
    }
}
