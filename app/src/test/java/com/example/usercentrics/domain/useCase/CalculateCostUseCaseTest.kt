package com.example.usercentrics.domain.useCase

import com.example.usercentrics.domain.calculation.ruleStrategy.BankingSnoopyRule
import com.example.usercentrics.domain.calculation.ruleStrategy.GoodCitizenRule
import com.example.usercentrics.domain.calculation.ruleStrategy.WhyDoYouCareRule
import com.example.usercentrics.domain.model.DataType
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

import org.mockito.Mockito.*

@RunWith(MockitoJUnitRunner::class)
class CalculateCostUseCaseTest {

    @Test
    fun `execute should calculate total and individual costs correctly`(){
        //arranging
        val dataTypes = listOf(
            "Purchase activity", "Bank details", "Configuration of app settings",
            "First name"
        )

        val rule1 = mock(BankingSnoopyRule::class.java)
        val rule2 = mock(WhyDoYouCareRule::class.java)
        val rule3 = mock(GoodCitizenRule::class.java)


        val rules = listOf(rule1, rule2, rule3)

        val calculateCostUseCase = CalculateCostUseCase(rules)

        val result = calculateCostUseCase.execute(dataTypes)

        //act
        val expectedTotalCost = 18.0
        val expectedEachServiceCost = mapOf(
            "Purchase activity" to 6,
            "Bank details" to 5,
            "Configuration of app settings" to 1,
            "First name" to 6
        )
        // assertion
        assertEquals(expectedTotalCost, result.totalCostEachService, 0.01)
        assertEquals(expectedEachServiceCost, result.eachServiceNameCost)
    }

    @Test
    fun `calculateBaseCost should return correct base cost`() {
        // arrange
        val dataTypes = listOf(
            DataType.CONFIGURATION_OF_APP_SETTINGS,
            DataType.IP_ADDRESS,
            DataType.USER_BEHAVIOUR,
            DataType.USER_AGENT,
            DataType.APP_CRASHES,
            DataType.BROWSER_INFORMATION,
            DataType.CREDIT_AND_DEBIT_CARD_NUMBER,
            DataType.FIRST_NAME,
            DataType.GEOGRAPHIC_LOCATION,
            DataType.DATE_TIME_OF_VISIT,
            DataType.ADVERTISING_IDENTIFIER,
            DataType.BANK_DETAILS,
            DataType.PURCHASE_ACTIVITY,
            DataType.INTERNET_SERVICE_PROVIDER,
            DataType.JAVASCRIPT_SUPPORT
        )

        // act
        val expectedBaseCost = 1.0 + 2.0 + 2.0 + 3.0 - 2.0 + 3.0 + 4.0 + 6.0 + 7.0 + 1.0 + 2.0 + 5.0 + 6.0 + 4.0 - 1.0
        val calculatedBaseCost = calculateBaseCost(dataTypes)

        // assertion
        assertEquals(expectedBaseCost, calculatedBaseCost, 0.01)
    }

}