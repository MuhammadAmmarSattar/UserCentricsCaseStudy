package com.example.usercentrics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.usercentrics.presentation.state.CalculationState
import com.example.usercentrics.presentation.ui.UserCentricView
import com.example.usercentrics.presentation.viewModel.MainViewModel
import com.example.usercentrics.ui.theme.UserCentricsTheme
import com.usercentrics.sdk.BannerSettings
import com.usercentrics.sdk.PopupPosition
import com.usercentrics.sdk.UsercentricsBanner
import com.usercentrics.sdk.UsercentricsConsentUserResponse
import com.usercentrics.sdk.UsercentricsLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserCentricsTheme {
                val state = mainViewModel.calculationState.collectAsStateWithLifecycle().value
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    UserCentricView(state = state, btnClick = {
                        showBanner()
                    })
                }
            }
        }
    }
    private fun showBanner(
        layout: UsercentricsLayout = UsercentricsLayout.Popup(PopupPosition.BOTTOM),
        settings: BannerSettings? = null
    ) {
        UsercentricsBanner(this, settings).also {
            it.showFirstLayer(
                callback = ::callBack
            )
        }
    }
    private fun callBack(userResponse: UsercentricsConsentUserResponse?) {
        userResponse ?: return
        mainViewModel.applyConsent(userResponse.consents)

    }
}
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun UserCentricViewPreview() {
    UserCentricsTheme {
        UserCentricView(
            state = CalculationState(),
            modifier = Modifier.fillMaxSize(),
            btnClick = {})
    }
}








