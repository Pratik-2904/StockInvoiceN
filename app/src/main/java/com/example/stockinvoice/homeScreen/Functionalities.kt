package com.example.stockinvoice.homeScreen

import androidx.annotation.DrawableRes
import com.example.stockinvoice.R

data class Functionalities(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int,
    val funcction: String,
    val onclick: () -> Unit
)

object dummyFunction {
    val DummyFunction = listOf(
        Functionalities(1, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),
        Functionalities(2, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),
        Functionalities(3, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),
        Functionalities(4, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),
        Functionalities(5, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),
        Functionalities(6, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),
        Functionalities(7, "Title 1", R.drawable.company_logo, "Function1", onclick = {}),

        )

}