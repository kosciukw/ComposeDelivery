package com.verestro.composenotesample.commons.ui.components.spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import com.verestro.composenotesample.commons.ui.dimens.BodyL
import com.verestro.composenotesample.commons.ui.dimens.BodyM
import com.verestro.composenotesample.commons.ui.dimens.BodyS
import com.verestro.composenotesample.commons.ui.dimens.BodyXL
import com.verestro.composenotesample.commons.ui.dimens.BodyXS
import com.verestro.composenotesample.commons.ui.dimens.BodyXXL
import com.verestro.composenotesample.commons.ui.dimens.BodyXXXL

@Composable
fun SpacerXS() {
    Spacer(modifier = Modifier.size(size = BodyXS))
}

@Composable
fun SpacerS() {
    Spacer(modifier = Modifier.size(size = BodyS))
}

@Composable
fun SpacerM() {
    Spacer(modifier = Modifier.size(size = BodyM))
}

@Composable
fun SpacerL() {
    Spacer(modifier = Modifier.size(size = BodyL))
}

@Composable
fun SpacerXL() {
    Spacer(modifier = Modifier.size(size = BodyXL))
}

@Composable
fun SpacerXXL() {
    Spacer(modifier = Modifier.size(size = BodyXXL))
}

@Composable
fun SpacerXXXL() {
    Spacer(modifier = Modifier.size(size = BodyXXXL))
}
