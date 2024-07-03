package com.example.stockinvoice

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.stockinvoice.Navigation.Navgraph
import com.example.stockinvoice.Screens.LoginDialog
//import com.example.stockinvoice.Screens.PhoneAuthScreen
import com.example.stockinvoice.Screens.SplashScreen
import com.example.stockinvoice.homeScreen.HomeView
import com.example.stockinvoice.ui.theme.StockInvoiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//
//        enableEdgeToEdge()
        setContent {
            val isDarkTheme = isSystemInDarkTheme()
            StockInvoiceTheme {
//                val context = LocalContext.current
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HomeView(context,isDarkTheme)
//                }
//                val navcontroller= rememberNavController()
//                Navgraph(navcontroller)
//SplashScreen()
LoginDialog()
            }
        }
    }
}

//
//@Composable
//fun PhoneAuthScreen() {
//    val phonenum= remember { mutableStateOf("") }
//    val otp= remember { mutableStateOf("") }
////    val phonenum= remember { mutableStateOf("") }
//    Column(modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//        Text(text = "Verify your Phone No.")
//        OutlinedTextField(value = phonenum.value, onValueChange = {phonenum.value=it},
//            label = { Text(text = "Phone Number")},
//            placeholder = { Text(text = "+91")})
//        Box(modifier = Modifier.padding(5.dp))
//
//        val text= remember {
//            mutableStateOf("")
//        }
//        ElevatedButton(onClick = { text.value="Verify"
//
//            //function for otp
//
//        }) {
//            Text(text = "Send OTP")
//        }
//
//
//    }
//
//}
