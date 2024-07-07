package com.example.stockinvoice.Screens.homeScreen


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockinvoice.R

// function to create topBAr
@Composable
fun HomeTopbar(context: Context, isDarkTheme: Boolean) {
    Card(
        colors = CardDefaults.cardColors(
            if (isDarkTheme) Color.DarkGray else Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            ClickableCurrentCompany(context = context, isDarkTheme)
            ClickableCompanyLOGO(context, isDarkTheme)

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeTopBarPreview() {
    HomeTopbar(context = LocalContext.current, isDarkTheme = isSystemInDarkTheme())
}

@Composable
fun ClickableCompanyLOGO(context: Context, isDarkTheme: Boolean) {
    Surface(
        modifier = Modifier
            .height(50.dp)
            .padding(10.dp),
        color = if (isDarkTheme) Color.DarkGray else Color.White,
        onClick = {
            Toast.makeText(context, "Company Logo", Toast.LENGTH_SHORT).show()
        }
    ) {
        Image(
            painter = painterResource(id = if (isDarkTheme) R.drawable.logo_dark_theme else R.drawable.logo_light_theme),
            contentDescription = "Company_Logo",
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun ClickableCurrentCompany(context: Context, isDarkTheme: Boolean) {

    val company by remember {
        mutableStateOf("Company Name")
    }

    var theme = if (isDarkTheme) listOf(Color.White, Color.Gray)  else listOf(Color.Gray, Color.Black)



    Surface(
        color = if (isDarkTheme) Color.DarkGray else Color.White,
        onClick = {
            Toast.makeText(context, company, Toast.LENGTH_SHORT).show()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentSize().padding(start = 3.dp)
        ) {
            val offset = Offset(5.0f, 5.0f)
            Text(text = company,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = offset,
                        blurRadius = 3f
                )
                )
            )

            Image(
                modifier = Modifier.padding(start = 10.dp),
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "Select Company"
            )
        }
    }

}
