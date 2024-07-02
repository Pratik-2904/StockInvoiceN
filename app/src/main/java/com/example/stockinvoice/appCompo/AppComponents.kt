package com.example.stockinvoice.appCompo

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockinvoice.R
import com.example.stockinvoice.ui.theme.BgColor
import com.example.stockinvoice.ui.theme.PrimaryColor
import com.example.stockinvoice.ui.theme.SecondaryColor
import com.example.stockinvoice.ui.theme.TextColor
import com.example.stockinvoice.ui.theme.componentShapes


@Composable
fun NormalTextComponent(value: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp), text = value, style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal

        ), color = colorResource(id = R.color.colorText), textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(0.dp), text = value, style = TextStyle(
            fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal

        ), color = colorResource(id = R.color.colorText), textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelvalue: String, icon: ImageVector) {
    val text = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BgColor),
        label = { Text(text = labelvalue) },
        placeholder = { Text(text = labelvalue) },
        value = text.value,
        onValueChange = { text.value = it },
        keyboardOptions = KeyboardOptions.Default,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(R.color.colorPrimary),

            ),
        shape = componentShapes.small,
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "Icon", tint = PrimaryColor)
        }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelvalue: String, icon: ImageVector) {
    val text = remember { mutableStateOf("") }
    val isPasswordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BgColor),
        label = { Text(text = labelvalue) },
        value = text.value,
        onValueChange = { text.value = it },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(R.color.colorPrimary),

            ),
        shape = componentShapes.small,
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "Icon", tint = PrimaryColor)
        },
        trailingIcon = {
            val icon2 = if (!isPasswordVisible.value) {
                R.drawable.hidden
            } else {
                R.drawable.eye
            }
            val description = if (isPasswordVisible.value) {
                "Hide Password"
            } else {
                "Show Password"
            }
            IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                Icon(
                    modifier = Modifier.aspectRatio(0.6f),
                    painter = painterResource(id = icon2),
                    contentDescription = description,
                    tint = PrimaryColor,

                    )
            }
        },
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )
}

@Composable
fun CheckBoxComponent(value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember { mutableStateOf(false) }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = it
        })

        ClickableTextComponent(value = value,
            onTextSelected = {
                //Todo On text Selected Navigate to Terms and Conditions

            })

    }

}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {

    val initialString = "By accepting you accept our "
    val terms = " Terms and Conditions"
    val andText = " and "
    val privacy = "Privacy Policy"
    val annotatedString = buildAnnotatedString {
        append(initialString)
        withStyle(style = SpanStyle(color = PrimaryColor)) {
            pushStringAnnotation(tag = privacy, annotation = privacy)
            append(privacy)
        }
        append(andText)
        withStyle(style = SpanStyle(color = PrimaryColor)) {
            pushStringAnnotation(tag = terms, annotation = terms)
            append(terms)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("Clickable Message", "{$span}")
                //Todo on click on terms and conditions
                if (span.item == terms) {
                    onTextSelected(span.item)
                }

            }
    })
}

@Composable
fun Buttoncomposable(value: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        onClick = {
            /*TODO*/
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(SecondaryColor, PrimaryColor)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                style = TextStyle(
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            )

        }
    }
}

@Composable
fun DividerTextField(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            color = Color.Gray,
            thickness = 1.dp
        )
        Text(
            text = value,
            fontSize = 18.sp,
            color = TextColor
        )
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            color = Color.Gray,
            thickness = 1.dp
        )

    }
}

@Composable
fun GoogleSignInButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { /*TODO Addition of One click Sign In Logic*/ }
        ) {
            Image(
                modifier = Modifier.aspectRatio(1f),
                painter = painterResource(id = R.drawable.icon_google),
                contentDescription = "Google Login"
            )
        }

    }
}

@Composable
fun ClickableLogInTextComponent(onTextSelected: (String) -> Unit) {

    val initialString = "Already Have An account? "
    val LogInText = "LogIn"
    val annotatededString = buildAnnotatedString {
        append(initialString)
        withStyle(style = SpanStyle(color = PrimaryColor)) {
            pushStringAnnotation(tag = LogInText, annotation = LogInText)
            append(LogInText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatededString, onClick = { offset ->
            annotatededString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("Clickable Message", "{$span}")
                    //Todo on click on terms and conditions
                    if (span.item == LogInText) {
                        onTextSelected(span.item)
                    }

                }
        })
}

