package com.example.usercentrics.domain.calculation

import com.example.usercentrics.domain.calculation.ruleStrategy.BankingSnoopyRule
import com.example.usercentrics.domain.calculation.ruleStrategy.GoodCitizenRule
import com.example.usercentrics.domain.calculation.ruleStrategy.WhyDoYouCareRule
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CostCalculationRuleTest {

    @Mock
    private lateinit var bankingDataTypes: List<String>

    @Mock
    private lateinit var whyDoYouCareDataTypes: List<String>

    @Mock
    private lateinit var goodCitizenDataTypes: List<String>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testBankingSnoopyRule() {
        val rule = BankingSnoopyRule()
        `when`(bankingDataTypes.containsAll(listOf("Purchase activity", "Bank details", "Credit and debit card number"))).thenReturn(true)
        val result = rule.applyRule(100.0, bankingDataTypes)
        assertEquals(110.0, result, 0.01)
    }

    @Test
    fun testWhyDoYouCareRule() {
        val rule = WhyDoYouCareRule()
        `when`(whyDoYouCareDataTypes.containsAll(listOf("Search terms", "Geographic location", "IP address"))).thenReturn(true)
        val result = rule.applyRule(100.0, whyDoYouCareDataTypes)
        assertEquals(127.0, result, 0.01)
    }

    @Test
    fun testGoodCitizenRule() {
        val rule = GoodCitizenRule()
        `when`(goodCitizenDataTypes.size).thenReturn(4)
        val result = rule.applyRule(100.0, goodCitizenDataTypes)
        assertEquals(90.0, result, 0.01)
    }
}