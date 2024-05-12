package com.example.usercentrics.presentation.viewModel

import com.example.usercentrics.domain.useCase.CalculateCostUseCase
import com.example.usercentrics.domain.useCase.CmpDataService
import com.example.usercentrics.domain.model.ConsentModel
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.v2.settings.data.UsercentricsService
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    lateinit var calculateCostUseCase: CalculateCostUseCase

    @Mock
    lateinit var cmpDataService: CmpDataService

    // The class under test
    lateinit var mainViewModel: MainViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mainViewModel = MainViewModel(calculateCostUseCase, cmpDataService)

    }

    @Test
    fun testApplyConsent() {
        // Mock data
        val consents = listOf(
            UsercentricsServiceConsent(
                "templateId1",
                true,
                emptyList(),
                null,
                "",
                "",
                false
            ),
            UsercentricsServiceConsent(
                "templateId2",
                true,
                emptyList(),
                null,
                "",
                "",
                false
            ),
        )
        val cmpData = listOf(
            UsercentricsService("templateId1", dataCollectedList =  listOf("IP address", "First name")),
            UsercentricsService("templateId2",dataCollectedList = listOf("IP address", "First name"))
        )
        // Stubbing behavior of cmpDataService
        `when`(cmpDataService.getCmpData()).thenReturn(cmpData)

        // Mock behavior of calculateCostUseCase
        val consentModel1 = ConsentModel(8.0, mapOf("IP address" to 2), 7.2)
        val consentModel2 = ConsentModel(8.0, mapOf("First name" to 6), 7.2)
        `when`(calculateCostUseCase.execute(listOf("IP address", "First name"))).thenReturn(consentModel1)
        `when`(calculateCostUseCase.execute(listOf("IP address", "First name"))).thenReturn(consentModel2)

        mainViewModel.applyConsent(consents)
        assertEquals(14.4, mainViewModel.calculationState.value.totalCost)
    }
}
