package com.example.stockinvoice.Screens.homeScreen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeView(
    context: Context, isDarkTheme: Boolean
) {
    Spacer(modifier = Modifier.padding(top = 20.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(if (isDarkTheme) Color.Black else Color.White)
    ) {
        //function call for Topbar
        HomeTopbar(context = context, isDarkTheme)

        LazyColumn {
            items(1) {

                DisplayBoard(isDarkTheme,context = context)

                Spacer(modifier = Modifier.padding(20.dp))

                FunctionalityBoard(isDarkTheme,context)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeViewPreview() {
//    HomeTopBar(context = LocalContext.current)
    HomeView(context = LocalContext.current, isDarkTheme = isSystemInDarkTheme())
}