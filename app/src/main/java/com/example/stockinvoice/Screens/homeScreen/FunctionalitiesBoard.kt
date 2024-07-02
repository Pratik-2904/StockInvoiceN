package com.example.stockinvoice.Screens.homeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockinvoice.DataBase.dummyFunction

@Composable
fun FunctionalityBoard(isDarkTheme: Boolean,context: Context) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val themeTextColor = remember {
            mutableStateOf(if (isDarkTheme) Color.White else Color.Black)
        }
        val themeSurfaceColor = remember {
            mutableStateOf(if (isDarkTheme) Color.DarkGray else Color.White)
        }
        val themeBackGroundColor = remember {
            mutableStateOf(if (isDarkTheme) Color.Black else Color.White)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = themeBackGroundColor.value,
                onClick = {
                    Toast.makeText(context,"Functionality",Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = "Functions",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = themeTextColor.value
                    )
                )
            }

            Surface(
                color = themeBackGroundColor.value,
                onClick = {
                    Toast.makeText(context,"More Functionality",Toast.LENGTH_SHORT).show()
                }

            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "More Functionality",
                    tint = themeTextColor.value
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(120.dp),
            colors = CardDefaults.cardColors(themeSurfaceColor.value),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(30.dp)
        ) {
            LazyVerticalGrid(
                contentPadding = PaddingValues(vertical = 15.dp, horizontal = 10.dp),
                columns = GridCells.Fixed(4)
            ) {
                itemsIndexed(dummyFunction.DummyFunction) { index, item ->
                    Functionality(
                        name = item.name,
                        image = if (isDarkTheme) item.image1d else item.image2l,
                        function = item.function,
                        onclick = item.onclick
                    )
                }

            }
        }

    }
}

@Composable
fun Functionality(
    name: String,
    image: Int,
    function: String,
    onclick: () -> Unit
) {
    IconButton(onClick = onclick) {
        Column(
            modifier = Modifier
        ) {
            Icon(
                painter = painterResource(id = image), contentDescription = function
            )
            Text(text = name)
        }

    }

}

@Preview
@Composable
fun FunctionalityBoardPreview() {
    FunctionalityBoard(isDarkTheme = true, context = LocalContext.current)

}