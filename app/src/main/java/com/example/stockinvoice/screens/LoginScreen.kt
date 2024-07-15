package com.example.stockinvoice.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.stockinvoice.ViewModels.authVM


@Composable
fun LoginScreen(navController: NavHostController) {
    val vm : authVM = viewModel()
    val firebaseUser by vm.firebaseUser.observeAsState(null)
    val context= LocalContext.current

    LaunchedEffect(firebaseUser) {
        if(firebaseUser!=null){
            navController.navigate("bottomNav"){
                navController.currentBackStackEntry?.destination?.route
                launchSingleTop=true
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var mail = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }

        Text(
            text = "Login", style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
        )

        OutlinedTextField(
            value = mail.value,
            onValueChange = { mail.value = it },
            label = { Text("Enter your Mail") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ), singleLine = true
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Enter Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ), singleLine = true
        )

        ElevatedButton(onClick = {
                               vm.login(mail.value,password.value,context)
        }, modifier = Modifier.padding(10.dp)) {

            Text(
                text = "Login",
                style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
            )
        }

        ElevatedButton(onClick = {
            navController.navigate("register"){
             navController.currentBackStackEntry?.destination?.route
                launchSingleTop=true
            }
        }) {
            Text( text = "New user? Register", style =
            TextStyle(fontWeight = FontWeight.Thin, fontSize = 15.sp)
            )
        }

//        ElevatedButton(onClick = { }) {
//            Text(text = "Forget Password", style =
//            TextStyle(fontWeight = FontWeight.Thin, fontSize = 15.sp)
//            )
//        }

    }
}
