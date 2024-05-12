package com.example.usercentrics.domain.calculation.ruleStrategy

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GoodCitizenRuleTest {

    @Test
    fun `test applyRule when dataTypes size is less than or equal to 4`() {
        // arranging
        val rule = GoodCitizenRule()
        val baseCost = 100.0
        val dataTypes = listOf("Type1", "Type2", "Type3", "Type4") // Total 4 types
        // act
        val result = rule.applyRule(baseCost, dataTypes)
        // assertion
        val expectedCost = baseCost - (baseCost * 0.10)
        assertEquals(expectedCost, result, 0.01) // Use delta for double comparison
    }

    @Test
    fun `test applyRule when dataTypes size is greater than 4`() {
        // arranging
        val rule = GoodCitizenRule()
        val baseCost = 100.0
        val dataTypes = listOf("Type1", "Type2", "Type3", "Type4", "Type5") // Total 5 types
        // act
        val result = rule.applyRule(baseCost, dataTypes)
        // assertion
        assertEquals(baseCost, result, 0.01) // No change expected
    }
}
