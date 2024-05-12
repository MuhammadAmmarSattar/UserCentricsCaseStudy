package com.example.usercentrics.domain.useCase

import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.v2.settings.data.UsercentricsService

class UserCentricCmpDataServiceUseCase : CmpDataService {
    override fun getCmpData(): List<UsercentricsService> {
        return Usercentrics.instance.getCMPData().services
    }
}


interface CmpDataService {
    fun getCmpData(): List<UsercentricsService>
}