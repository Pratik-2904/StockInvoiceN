package com.example.stockinvoice.Screens.signInScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
fun SignUpPage() {

    val count = stringResource(id = R.string.signUpItemsCount).toInt()

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
            modifier = Modifier.fillMaxSize().background(Color.White),
        ) {
            items(count = count) {
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextField(labelvalue = "First Name", Icons.Filled.Person)
                MyTextField(labelvalue = "Last Name", Icons.Filled.Person)
                MyTextField(labelvalue = "Email", Icons.Filled.Email)
                PasswordTextField(labelvalue = "Password", icon = Icons.Filled.Lock)
                CheckBoxComponent(value = "Remember Me")

                Spacer(modifier = Modifier.heightIn(40.dp))

                Buttoncomposable(value = "Register")
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextField(value = "or")
                Spacer(modifier = Modifier.height(20.dp))
                GoogleSignInButton()
                Spacer(modifier = Modifier.height(40.dp))
                ClickableLogInTextComponent(onTextSelected = {/*TODO*/})

            }
        }

    }
}


@Preview
@Composable
fun SignUpPagePreview() {
    SignUpPage()
}