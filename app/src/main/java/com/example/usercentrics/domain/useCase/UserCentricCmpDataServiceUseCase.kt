package com.example.usercentrics.domain.useCase

import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.v2.settings.data.UsercentricsService

/**
 * Implementation of CmpDataService for fetching CMP data related to user-centric services.
 */
class UserCentricCmpDataServiceUseCase : CmpDataService {
    /**
     * Fetches CMP data related to user-centric services.
     * @return List of user centrics Service representing the CMP data.
     */
    override fun getCmpData(): List<UsercentricsService> {
        return Usercentrics.instance.getCMPData().services
    }
}

/**
 * Interface for defining CMP data service.
 */
interface CmpDataService {
    /**
     * Fetches CMP data.
     * @return List of UsercentricsService representing the CMP data.
     */
    fun getCmpData(): List<UsercentricsService>
}