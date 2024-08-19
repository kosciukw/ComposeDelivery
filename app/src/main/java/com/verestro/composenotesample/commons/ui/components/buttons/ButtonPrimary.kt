package com.verestro.composenotesample.commons.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.verestro.composenotesample.commons.ui.dimens.BodyXXS
import com.verestro.composenotesample.ui.theme.ColorButtonPrimaryBackground
import com.verestro.composenotesample.ui.theme.ColorButtonPrimaryText


@Composable
fun ButtonPrimary(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorButtonPrimaryBackground,
            contentColor = ColorButtonPrimaryText
        ),
        shape = RoundedCornerShape(size = BodyXXS),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}