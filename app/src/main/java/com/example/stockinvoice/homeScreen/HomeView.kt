package com.example.stockinvoice.homeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockinvoice.R


@Composable
//HomeView
fun HomeView(context: Context) {
    Spacer(modifier = Modifier.padding(top = 20.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        //function call for Topbar
        HomeTopBar(context = context)

        //Divider to Divide top bar and content
        HorizontalDivider(thickness = 5.dp, color = Color.Gray)

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {


//            Todo Lower part than that of the top bar
                DisplayBoard()
                Spacer(modifier = Modifier.padding(20.dp))
                FunctionalityBoard()
            }
        }
    }
}

@Composable
fun FunctionalityBoard() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Functionality",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Image(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "More Functionality"
            )
        }
        Card(
            modifier = Modifier
                .padding(top = 10.dp)
                .height(150.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(30.dp)
        ) {
            LazyVerticalGrid(
                contentPadding = PaddingValues(vertical = 10.dp),
                columns = GridCells.Fixed(4)
            ) {
                itemsIndexed(dummyFunction.DummyFunction) { index, item ->
                    functionality(
                        name = item.name,
                        image = item.image,
                        function = item.funcction,
                        onclick = item.onclick
                    )
                }

            }
        }

    }
}

@Composable
fun functionality(
    name: String,
    image: Int,
    function: String,
    onclick: () -> Unit
) {
    IconButton(onClick = onclick) {
        Column {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = "$name  $function",
                contentScale = ContentScale.Crop
            )
            Text(text = name)
        }
    }

}


@Composable
fun DisplayBoard() {

    //Variable to store the selected Sales
    val sales by remember {
        mutableIntStateOf(0)
    }

    val Purchase by remember {
        mutableIntStateOf(0)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        text = "This Year",
                        fontSize = 20.sp
                    )
                    Image(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Time lapse"
                    )
                }
                Text(
                    text = "View Bills",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.purple_500),
                        fontWeight = FontWeight.Bold

                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                //left Column
                Column(
                    modifier = Modifier.padding(start = 10.dp, end = 100.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Sales",
                        fontSize = 20.sp
                    )
                    Row(
                        modifier = Modifier.padding(2.dp)
                    ) {
                        //Todo add rupee sign
                        Text(
                            text = "$sales",
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                }
                //Vertical Divider
                VerticalDivider(thickness = 2.dp, color = Color.Gray)

                //Right Column
                Column(
                    modifier = Modifier.padding(start = 30.dp, end = 40.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Purchases",
                        fontSize = 20.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        //Todo add rupee sign
                        Text(
                            text = "$Purchase",
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        )
                    }
                }
            }
        }

        Column {

        }
    }

}


// function to create topBAr
@Composable
fun HomeTopBar(context: Context) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(2.dp)
    ) {
        Row(
            modifier = Modifier
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
        modifier = Modifier
            .height(50.dp)
            .padding(10.dp),
        color = MaterialTheme.colorScheme.background,
        onClick = {
            Toast.makeText(context, "Company Logo", Toast.LENGTH_SHORT).show()
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Gray,
            shadowElevation = 4.dp,
            border = BorderStroke(1.dp, Color.Gray),
        ) {


            Image(
                painter = painterResource(id = R.drawable.company_logo),
                contentDescription = "Company_Logo",
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
fun ClickableCurrentCompany(context: Context) {
    var Company by remember {
        mutableStateOf("Company Name")
    }


    Surface(
        onClick = {
            Toast.makeText(context, Company, Toast.LENGTH_SHORT).show()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentSize()
        ) {
            val offset = Offset(5.0f, 5.0f)
            Text(
                text = Company,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
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
//    HomeTopBar(context = LocalContext.current)
    HomeView(context = LocalContext.current)
}