package com.example.usercentrics.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.usercentrics.presentation.composeComponent.CustomButton
import com.example.usercentrics.presentation.composeComponent.CustomText
import com.example.usercentrics.presentation.state.CalculationState
import com.example.usercentrics.ui.theme.UserCentricsTheme
import com.example.usercentrics.utils.extension.bounceClick

@Composable
fun UserCentricView(
    state: CalculationState,
    modifier: Modifier = Modifier, btnClick: () -> Unit
) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (consentButton, totalScore, totalScoreTitle) = createRefs()

        CustomText(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(totalScore) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)

                },
            text = state.totalCost.toString() ?: "0",
            fontSize = 95.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )
        CustomText(
            modifier = Modifier
                .constrainAs(totalScoreTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(totalScore.bottom)

                },
            text = "Consent Score",
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )
        CustomButton(
            modifier = Modifier.bounceClick()
                .constrainAs(consentButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            onClick = { btnClick() },
            buttonText = "Show Consent Banner"
        )
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