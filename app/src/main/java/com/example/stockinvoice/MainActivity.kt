package com.example.stockinvoice

//import com.example.stockinvoice.Screens.PhoneAuthScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.stockinvoice.screens.product_services_Screen.ProductAndServicePreview
import com.example.stockinvoice.screens.product_services_Screen.ProductAndServiceScreen
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
//LoginDialog()
                ProductAndServiceScreen()
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
