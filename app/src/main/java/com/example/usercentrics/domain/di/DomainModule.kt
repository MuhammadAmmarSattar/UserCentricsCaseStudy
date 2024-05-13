package com.example.usercentrics.domain.di

import com.example.usercentrics.domain.calculation.ruleStrategy.BankingSnoopyRule
import com.example.usercentrics.domain.calculation.ruleStrategy.GoodCitizenRule
import com.example.usercentrics.domain.calculation.ruleStrategy.WhyDoYouCareRule
import com.example.usercentrics.domain.useCase.CalculateCostUseCase
import com.example.usercentrics.domain.useCase.CmpDataService
import com.example.usercentrics.domain.useCase.UserCentricCmpDataServiceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module for providing domain-related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    /**
     * Provides the CalculateCostUseCase dependency.
     * @return Instance of CalculateCostUseCase.
     */
    @Provides
    fun provideCalculateCostUseCase(): CalculateCostUseCase {
        val rules = listOf(
            BankingSnoopyRule(),
            WhyDoYouCareRule(),
            GoodCitizenRule()
        )
        return CalculateCostUseCase(rules)
    }

    /**
     * Provides the CmpDataService dependency.
     * @return Instance of CmpDataService.
     */
    @Provides
    fun provideCmpDataService(): CmpDataService =
        UserCentricCmpDataServiceUseCase()

}