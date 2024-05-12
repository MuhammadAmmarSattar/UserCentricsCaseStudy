package com.example.usercentrics.presentation.composeComponent

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.Blue,
    contentColor: Color = Color.White,
    borderColor: Color = Color.Transparent,
    shadowColor : Color = Color.Transparent,
    cornerRadius: Dp = 11.dp,
    elevation: Dp = 11.dp
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 36.dp, start = 50.dp, end = 50.dp)
            .border(2.5.dp, color = borderColor, shape = RoundedCornerShape(cornerRadius))
            .shadow(
                shape = RoundedCornerShape(cornerRadius),
                elevation = elevation,
                spotColor = shadowColor
            ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(vertical = 12.dp), // Padding
        shape = RoundedCornerShape(cornerRadius)
    ) {
        CustomText(
            text = buttonText,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = contentColor
        )
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(
        onClick = { /* Handle button click */ },
        buttonText = "Show Consent Banner"
    )
}