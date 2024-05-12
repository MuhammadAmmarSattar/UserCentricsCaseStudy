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

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideCalculateCostUseCase(): CalculateCostUseCase {
        val rules = listOf(
            BankingSnoopyRule(),
            WhyDoYouCareRule(),
            GoodCitizenRule()
        )
        return CalculateCostUseCase(rules)
    }

    @Provides
    fun provideCmpDataService(): CmpDataService =
        UserCentricCmpDataServiceUseCase()

}