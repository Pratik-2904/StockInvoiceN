package com.example.stockinvoice.screens.product_services_Screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductAndServiceScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            //todo navigate to homescreen
                            Toast.makeText(context, "HomeScreen", Toast.LENGTH_LONG).show()
                        }
                        ) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back Home screen")
                        }
                    },
                    title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Product and Services")
                        Spacer(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 10.dp)
                        )
                        IconButton(onClick = {
                            Toast.makeText(context, "Search", Toast.LENGTH_LONG).show()
                        }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                        }
                    }
                })
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(1000.dp)
                    .padding(it)
                    .background(color = Color.Transparent)
            ) {

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductAndServicePreview() {
    ProductAndServiceScreen()
}