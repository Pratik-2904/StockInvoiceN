package com.example.stockinvoice.screens.signInScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.stockinvoice.Navigation.routes
import com.example.stockinvoice.R
import com.example.stockinvoice.ViewModels.authVM
import com.example.stockinvoice.ui.theme.TextColor
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignUpPage(navController: NavController) {
val vm: authVM = viewModel()
 val firebaseruser =FirebaseAuth.getInstance().currentUser

 LaunchedEffect(key1 = true) {
     if(firebaseruser!=null){
      //   navController.navigate(route = routes.home.route)    navigate to next screen
     }
 }

    val name= remember { mutableStateOf("") }
    val password=remember { mutableStateOf("") }
    val mail= remember { mutableStateOf("aditya226vedpathak@gmail.com") }   //for trial purpose
    val GSTnum= remember { mutableStateOf("") }
    val phonenum= remember { mutableStateOf("") }
    val context= LocalContext.current


    val count = stringResource(id = R.string.signUpItemsCount).toInt()

    val isDarkTheme = isSystemInDarkTheme()
    val themeBackGroundColor = remember {
        mutableStateOf(if (isDarkTheme) Color.Black else Color.LightGray)
    }
    val themeSurfaceColor = remember {
        mutableStateOf(if (isDarkTheme) Color.DarkGray else Color.White)
    }
    val themeTextColor = remember {
        mutableStateOf(if (isDarkTheme) Color.White else TextColor)
    }


     Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Top
//        ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            items(count = count) {
                NormalTextComponent(
                    value = stringResource(id = R.string.hello),
                    themeTextColor.value
                )
                HeadingTextComponent(
                    value = stringResource(id = R.string.create_account),
                    themeTextColor.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(
                    labelValue = "First Name",
                    Icons.Filled.Person,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )
                MyTextField(
                    labelValue = "Last Name",
                    Icons.Filled.Person,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )

                MyTextField(
                    labelValue = "Email",
                    Icons.Filled.Email,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )
                MyTextField(
                    labelValue = "GST No.(Optional)",
                    Icons.Filled.Person,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )
                PasswordTextField(
                    labelValue = "Password",
                    icon = Icons.Filled.Lock,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )
                CheckBoxComponent(
                    value = "Remember Me",
                    themeBackGroundColor,
                    themeTextColor,
                    themeSurfaceColor,
                    onTextSelected = {
                        navController.navigate(route = routes.terms.route)
                    }
                )

                Spacer(modifier = Modifier.heightIn(40.dp))

                Buttoncomposable(
                    value = "Register",
                    themeBackGroundColor,
                    themeTextColor,
                    themeSurfaceColor
                )
                //passs below function to above button on olick
//                vm.signup(name.value,mail.value,phonenum.value,GSTnum.value,password.value,context )

                Spacer(modifier = Modifier.height(20.dp))
                DividerTextField(
                    value = "or",
                    themeTextColor.value,
                )
                Spacer(modifier = Modifier.height(20.dp))

                GoogleSignInButton(themeBackGroundColor, themeTextColor, themeSurfaceColor)
                Spacer(modifier = Modifier.height(40.dp))
                ClickableLogInTextComponent(
                    onTextSelected = {
                        navController.navigate(route = routes.login.route)
                    },
                    themebackgroundColor = themeBackGroundColor,
                    themeTextColor = themeTextColor, themeSurfaceColor = themeSurfaceColor
                )

            }
        }

    }
}
//
//
//@Preview
//@Composable
//fun SignUpPagePreview() {
//    SignUpPage(navController = rememberNavController())
//}