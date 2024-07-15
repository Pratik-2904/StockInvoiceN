package com.example.stockinvoice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stockinvoice.R
import com.example.stockinvoice.screens.signInScreen.NormalTextComponent

@Composable
fun TermsAndConditionsScreen(navController: NavController) {
    val themeTextColor = Color.White
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        NormalTextComponent(value = stringResource(id = R.string.terms_and_conditions),themeTextColor)

    }
}