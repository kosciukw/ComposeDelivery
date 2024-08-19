package com.verestro.composenotesample.commons.ui.components.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.verestro.composenotesample.R
import com.verestro.composenotesample.commons.ui.components.spacers.SpacerM
import com.verestro.composenotesample.commons.ui.text.styles.TextSearchBarFocused
import com.verestro.composenotesample.commons.ui.text.styles.TextSearchBarUnfocused
import com.verestro.composenotesample.ui.theme.ColorTransparent
import com.verestro.composenotesample.ui.theme.ColorWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    iconId: Int?,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val isFocused = remember {
        mutableStateOf(false)
    }

    TextField(
        modifier = modifier
            .background(color = ColorWhite)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        value = text,
        onValueChange = {
            onTextChange(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = ColorTransparent,
            focusedIndicatorColor = ColorTransparent,
            unfocusedIndicatorColor = ColorTransparent
        ),
        maxLines = maxLine,
        label = {
            Row {
                if (!isFocused.value) {
                    iconId?.let {
                        Image(
                            painter = painterResource(id = it),
                            contentDescription = stringResource(id = R.string.menu_screen_search),
                            contentScale = ContentScale.Fit
                        )
                    }
                    SpacerM()
                    Text(
                        text = label,
                        style = TextSearchBarUnfocused
                    )

                } else
                    Text(
                        text = label,
                        style = TextSearchBarFocused
                    )
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        )
    )
}