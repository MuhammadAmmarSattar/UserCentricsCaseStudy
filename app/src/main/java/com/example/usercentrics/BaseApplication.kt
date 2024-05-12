package com.example.usercentrics

import android.app.Application
import com.example.usercentrics.utils.AppConstant.SETTING_ID
import com.usercentrics.sdk.Usercentrics
import com.usercentrics.sdk.UsercentricsOptions
import com.usercentrics.sdk.models.common.UsercentricsLoggerLevel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val options = UsercentricsOptions(
            settingsId = SETTING_ID,
            loggerLevel = UsercentricsLoggerLevel.DEBUG,
        )
        Usercentrics.initialize(this, options)
    }
}
