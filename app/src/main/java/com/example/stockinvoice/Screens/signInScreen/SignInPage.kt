package com.example.stockinvoice.Screens.signInScreen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SignInPage(isDarkTheme : Boolean,context: Context){

    val themeBackGroundColor = remember {
        mutableStateOf(if (isDarkTheme) Color.Black else Color.LightGray)
    }
    val themeSurfaceColor = remember {
        mutableStateOf(if (isDarkTheme) Color.DarkGray else Color.White)
    }
    val themeTextColor = remember {
        mutableStateOf(if (isDarkTheme) Color.White else Color.Black)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .blur(100.dp),
        color = themeBackGroundColor.value,

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(color = themeBackGroundColor.value),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInCard(isDarkTheme,context)
        }

    }

}

@Composable
fun SignInCard(isDarkTheme: Boolean, context: Context) {
    val themeBackGroundColor = remember {
        mutableStateOf(if (isDarkTheme) Color.Black else Color.White)
    }
    val themeSurfaceColor = remember {
        mutableStateOf(if (isDarkTheme) Color.DarkGray else Color.White)
    }
    val themeTextColor = remember {
        mutableStateOf(if (isDarkTheme) Color.White else Color.Black)
    }
    Card(
        modifier = Modifier
            .background(color = themeSurfaceColor.value)
            .height(100.dp)
            .width(100.dp)
    ) {

        
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPagePreview(){
    SignInPage(isDarkTheme = isSystemInDarkTheme(), LocalContext.current)
}
