package com.example.stockinvoice.Screens.signInScreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.stockinvoice.Navigation.routes
import com.example.stockinvoice.R
import com.example.stockinvoice.ViewModels.authVM
import com.example.stockinvoice.appCompo.Buttoncomposable
import com.example.stockinvoice.appCompo.ClickableLogInTextComponent
import com.example.stockinvoice.appCompo.DividerTextField
import com.example.stockinvoice.appCompo.GoogleSignInButton
import com.example.stockinvoice.appCompo.HeadingTextComponent
import com.example.stockinvoice.appCompo.MyTextField
import com.example.stockinvoice.appCompo.NormalTextComponent
import com.example.stockinvoice.appCompo.PasswordTextField
import com.example.stockinvoice.ui.theme.TextColor
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LogInScreen(navController: NavController) {


    val mail= remember { mutableStateOf("") }
    val password=remember { mutableStateOf("") }

    val vm: authVM = viewModel()
    val firebaseruser = FirebaseAuth.getInstance().currentUser

    LaunchedEffect(key1 = true) {
        if(firebaseruser!=null){
            //   navController.navigate(route = routes.home.route)    navigate to next screen
        }
    }

    val isDarkTheme = isSystemInDarkTheme()

    val context = LocalContext.current

    val themeBackGroundColor = remember {
        mutableStateOf(if (isDarkTheme) Color.DarkGray else Color.White)
    }
    val themeSurfaceColor = remember {
        mutableStateOf(if (isDarkTheme) Color.Gray else Color.White)
    }
    val themeTextColor = remember {
        mutableStateOf(if (isDarkTheme) Color.White else TextColor)
    }
    val signInComponentCount = stringResource(id = R.string.signUpItemsCount).toInt()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(themeBackGroundColor.value)
            .padding(28.dp),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(themeBackGroundColor.value),
            verticalArrangement = Arrangement.Center
        ) {
            items(signInComponentCount) {
                NormalTextComponent(
                    value = stringResource(id = R.string.hello),
                    themeTextColor = themeTextColor.value,
                )
                HeadingTextComponent(
                    value = stringResource(id = R.string.welcome),
                    themeTextColor = themeTextColor.value,
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyTextField(
                    labelValue = "Email",
                    icon = Icons.Default.Email,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )
                Spacer(modifier = Modifier.height(8.dp))
                PasswordTextField(
                    labelValue = "Password",
                    icon = Icons.Default.Lock,
                    themeTextColor = themeTextColor.value,
                    themeSurfaceColor = themeSurfaceColor.value
                )
                Spacer(modifier = Modifier.heightIn(20.dp))
                Buttoncomposable(
                    value = "LogIn",
                    themebackgroundColor = themeBackGroundColor,
                    themeTextColor = themeTextColor ,
                    themeSurfaceColor = themeSurfaceColor
                )
//add functionality to button on click
//                vm.login(mail.value,password.value,context)


                Spacer(modifier = Modifier.heightIn(40.dp))

                DividerTextField(
                    value = " or ",
                    themeTextColor = themeTextColor.value,
                )

                Spacer(modifier = Modifier.heightIn(40.dp))

                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    border = CardDefaults.outlinedCardBorder(),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center)
                ) {
                    GoogleSignInButton(
                        themebackgroundColor = themeBackGroundColor,
                        themeTextColor = themeTextColor,
                        themeSurfaceColor = themeSurfaceColor
                    )
                }

                Spacer(modifier = Modifier.height(90.dp))

                ClickableLogInTextComponent(
                    themebackgroundColor = themeBackGroundColor,
                    themeTextColor = themeTextColor,
                    themeSurfaceColor = themeSurfaceColor,
                    onTextSelected = {
                        navController.navigate(route = routes.register.route)
                    }
                )

            }

        }

    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LogInScreenPreview() {
    LogInScreen(navController = NavController(LocalContext.current))
}

//@Composable
//fun SignInCard(isDarkTheme: Boolean, context: Context) {
//    val themeBackGroundColor = remember {
//        mutableStateOf(if (isDarkTheme) Color.Black else Color.White)
//    }
//    val themeSurfaceColor = remember {
//        mutableStateOf(if (isDarkTheme) Color.DarkGray else Color.White)
//    }
//    val themeTextColor = remember {
//        mutableStateOf(if (isDarkTheme) Color.White else Color.Black)
//    }
//    Card(
//        modifier = Modifier
//            .background(color = themeSurfaceColor.value)
//            .height(100.dp)
//            .width(100.dp)
//    ) {
//
//
//    }
//
//}

