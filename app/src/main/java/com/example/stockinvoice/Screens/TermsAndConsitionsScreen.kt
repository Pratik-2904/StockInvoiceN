package com.example.stockinvoice.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.stockinvoice.R
import com.example.stockinvoice.appCompo.NormalTextComponent

@Composable
fun TermsAndConditionsScreen(themeTextColor: Color) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        NormalTextComponent(value = stringResource(id = R.string.terms_and_conditions),themeTextColor)

    }
}