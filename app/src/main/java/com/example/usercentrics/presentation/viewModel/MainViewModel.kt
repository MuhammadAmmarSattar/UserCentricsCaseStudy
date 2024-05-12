package com.example.usercentrics.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.usercentrics.domain.useCase.CalculateCostUseCase
import com.example.usercentrics.domain.useCase.CmpDataService
import com.example.usercentrics.domain.model.ConsentModel
import com.example.usercentrics.presentation.state.CalculationState
import com.usercentrics.sdk.UsercentricsServiceConsent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val calculateCostUseCase: CalculateCostUseCase,
                                        private val cmpDataService: CmpDataService
) : ViewModel() {

    private var _calculationState = MutableStateFlow(CalculationState())
    val calculationState = _calculationState.asStateFlow()


    fun applyConsent(consents: List<UsercentricsServiceConsent>){
        var totalCost = 0.0
        consents.forEach { consent ->
            if (consent.status) {
                val service = cmpDataService.getCmpData().find { it.templateId == consent.templateId }
                service?.let {
                    val consentModel = calculateCostUseCase.execute(it.dataCollectedList)
                    printFilteredServiceCosts(consentModel)
                    totalCost += consentModel.rulesCost ?:0.0

                }
            }
        }
        _calculationState.value = CalculationState(totalCost = totalCost)
    }

    private fun printFilteredServiceCosts(consentModel: ConsentModel) {
        println("Filtered Service Costs:")
        consentModel.eachServiceNameCost.forEach { (service, cost) ->
            println("$service = $cost")
        }
        println("Each Service Total cost = ${consentModel.totalCostEachService}")
        println("Rule Cost = ${consentModel.rulesCost}")
    }
}


