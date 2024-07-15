package com.example.stockinvoice.database

import androidx.annotation.DrawableRes
import com.example.stockinvoice.R

data class Functionalities(
    val id: Int,
    val name: String,
    @DrawableRes val image1d: Int,
    @DrawableRes val image2l: Int,
    val function: String,
    val onclick: () -> Unit
)

object dummyFunction {
    val DummyFunction = listOf(
        Functionalities(1, "Title 1", R.drawable.logo_dark_theme,R.drawable.logo_light_theme, "Function1", onclick = {}),
        Functionalities(2, "Title 1", R.drawable.logo_dark_theme,R.drawable.logo_light_theme, "Function1", onclick = {}),
        Functionalities(3, "Title 1", R.drawable.logo_dark_theme,R.drawable.logo_light_theme, "Function1", onclick = {}),
        Functionalities(4, "Title 1", R.drawable.logo_dark_theme,R.drawable.logo_light_theme, "Function1", onclick = {}),
        Functionalities(5, "Title 1", R.drawable.logo_dark_theme,R.drawable.logo_light_theme, "Function1", onclick = {}),
        Functionalities(6, "Title 1", R.drawable.logo_dark_theme,R.drawable.logo_light_theme, "Function1", onclick = {}),
        )

}