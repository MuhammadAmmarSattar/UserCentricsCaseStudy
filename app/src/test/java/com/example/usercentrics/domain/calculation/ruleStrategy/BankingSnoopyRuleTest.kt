package com.example.usercentrics.domain.calculation.ruleStrategy

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BankingSnoopyRuleTest {

    @Test
    fun `test applyRule when dataTypes contain all required data types`() {

        // arranging
        val rule = BankingSnoopyRule()
        val baseCost = 100.0
        val dataTypes = listOf("Purchase activity", "Bank details", "Credit and debit card number")
        // act
        val result = rule.applyRule(baseCost, dataTypes)
        // assertion
        val expectedCost = baseCost + (baseCost * 0.10)
        assertEquals(expectedCost, result, 0.01) // Use delta for double comparison
    }

    @Test
    fun `test applyRule when dataTypes do not contain all required data types`() {
        // arranging
        val rule = BankingSnoopyRule()
        val baseCost = 100.0
        val dataTypes = listOf("Purchase activity", "Bank details") // Missing "Credit and debit card number"
        // act
        val result = rule.applyRule(baseCost, dataTypes)
        // assertion
        assertEquals(baseCost, result, 0.01) // No change expected
    }
}