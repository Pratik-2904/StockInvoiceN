package com.example.stockinvoice.homeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
//HomeView
fun HomeView(context: Context) {
    Spacer(modifier = Modifier.padding(top = 20.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        //function call for Topbar
        HomeTopBar(context = context)

        //Divider to Divide top bar and content
        HorizontalDivider()

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
        ) {
//            Todo Lower part than that of the top bar
        }
    }
}

// function to create topBAr
@Composable
fun HomeTopBar(context: Context) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 4.dp,
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier.wrapContentSize()
    ) {
        Row(modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {
            ClickableCurrentCompany(context = context)
            ClickableCompanyLOGO(context)

        }
    }

}


//Issue in adding Company Logo
@Composable
fun ClickableCompanyLOGO(context: Context) {
    Surface(
        color = Color.Black,
        modifier = Modifier.wrapContentSize(),
        onClick = {
            Toast.makeText(context, "Company Logo", Toast.LENGTH_SHORT).show()
        }
    ) {
        Surface(
//            modifier = Modifier.wrapContentSize(),
            color = Color.Gray,
            shadowElevation = 4.dp,
            border = BorderStroke(1.dp, Color.Gray),
        ) {
            Text(text = "Logo")


//        Image(painter = painterResource(id =R.drawable.company_logo), contentDescription = "Company_Logo")
        }
    }
}

@Composable
fun ClickableCurrentCompany(context: Context) {
    Surface(
        onClick = {
            Toast.makeText(context, "Company Name", Toast.LENGTH_SHORT).show()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentSize()
        ) {
            val offset = Offset(5.0f, 5.0f)
            Text(
                text = "Company Name",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Cyan, Color.Gray, Color.Black)
                    ),
                    shadow = Shadow(
                        color = MaterialTheme.colorScheme.primary,
                        offset = offset,
                        blurRadius = 10f
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeViewPreview() {
    ClickableCompanyLOGO(context = LocalContext.current)
}