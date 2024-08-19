package com.verestro.composenotesample.commons.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.verestro.composenotesample.ui.theme.ColorTransparent
import com.verestro.composenotesample.ui.theme.ColorButtonSecondaryText

@Composable
fun ButtonSecondary(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorTransparent,
            contentColor = ColorButtonSecondaryText
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}
