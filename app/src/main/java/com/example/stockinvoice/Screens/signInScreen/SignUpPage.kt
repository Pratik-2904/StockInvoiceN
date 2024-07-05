package com.example.stockinvoice.Screens.signInScreen

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.stockinvoice.Navigation.routes
import com.example.stockinvoice.R
import com.example.stockinvoice.appCompo.Buttoncomposable
import com.example.stockinvoice.appCompo.CheckBoxComponent
import com.example.stockinvoice.appCompo.ClickableLogInTextComponent
import com.example.stockinvoice.appCompo.DividerTextField
import com.example.stockinvoice.appCompo.GoogleSignInButton
import com.example.stockinvoice.appCompo.HeadingTextComponent
import com.example.stockinvoice.appCompo.MyTextField
import com.example.stockinvoice.appCompo.NormalTextComponent
import com.example.stockinvoice.appCompo.PasswordTextField
import com.example.stockinvoice.ui.theme.TextColor

@Composable
fun SignUpPage(navController: NavController) {

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
                    themeSurfaceColor
                )

                Spacer(modifier = Modifier.heightIn(40.dp))

                Buttoncomposable(
                    value = "Register",
                    themeBackGroundColor,
                    themeTextColor,
                    themeSurfaceColor
                )
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


@Preview
@Composable
fun SignUpPagePreview() {
    SignUpPage(navController = rememberNavController())
}