package com.example.stockinvoice.Screens.homeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockinvoice.R

@Composable
fun DisplayBoard(isDarkTheme: Boolean, context: Context) {

    //Variable to store the selected Sales
    val sales by remember {
        mutableFloatStateOf(0.000f)
    }

    val purchase by remember {
        mutableFloatStateOf(0.000f)
    }

    val timeUnit by remember {
        mutableStateOf("Year")
    }

    Spacer(modifier = Modifier.padding(15.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        colors = CardDefaults.cardColors(if (isDarkTheme) Color.DarkGray else Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //whole row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //row for clickable items
                Surface(
                    color = if (isDarkTheme) Color.DarkGray else Color.White,
                    onClick = {
                        Toast.makeText(
                            context,
                            "Clicked for change in category",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "This $timeUnit",
                            fontSize = 20.sp,
                            color = if (isDarkTheme) Color.White else Color.Black
                        )

                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "Select Time Unit",
                            tint = if (isDarkTheme) Color.White else Color.Black
                        )

                    }
                }
                //view Bills
                Surface(
                    color = if (isDarkTheme) Color.DarkGray else Color.White,
                    onClick = {
                        Toast.makeText(context,"Clicked for View Bills",Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(
                        text = "View Bills",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = colorResource(id = if (isDarkTheme) R.color.purple_200 else R.color.purple_700),
                            fontWeight = FontWeight.Bold

                        )
                    )
                }
            }
            //2nd Row in Main
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //InnerColumn
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Row for Sales and Purchase
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(0.5f)
                        ) {
                            Text(
                                text = "Sales",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    color = if (isDarkTheme) Color.White else Color.Black
                                )
                            )
                        }

                        VerticalDivider(
                            modifier = Modifier.height(18.dp),
                            thickness = 2.dp,
                            color = if (isDarkTheme) Color.Gray else Color.Black
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Purchase",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    color = if (isDarkTheme) Color.White else Color.Black
                                )
                            )
                        }
                    }

                    //Row for Sales and Purchase amount
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(0.5f)
                        ) {
                            Text(
                                text = sales.toString(),
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    color = if (isDarkTheme) Color.White else Color.Black
                                )
                            )
                        }

                        VerticalDivider(
                            modifier = Modifier.height(35.dp),
                            thickness = 2.dp,
                            color = if (isDarkTheme) Color.Gray else Color.Black
                        )


                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(start = 10.dp)

                        ) {
                            Text(
                                text = purchase.toString(),
                                style = TextStyle(
                                    fontSize = 30.sp,
                                    color = if (isDarkTheme) Color.White else Color.Black
                                )
                            )
                        }

                    }
                }

            }
        }
    }

}

@Preview
@Composable
fun DisplayBoardPreview() {
    DisplayBoard(isDarkTheme = true, LocalContext.current)

}