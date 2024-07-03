package com.example.stockinvoice.Screens

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

@Composable
fun LoginDialog() {
    val dialogState = remember { mutableStateOf(true) }
    if (dialogState.value) {
        Dialog(
            onDismissRequest = { dialogState.value = false },
            content = { CompleteDialogContent(dialogState) },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        )
    }
}

val auth = FirebaseAuth.getInstance()
var storedVerificationId: String = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompleteDialogContent(dialogState: MutableState<Boolean>) {
    val context = LocalContext.current
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var otp by remember { mutableStateOf(TextFieldValue("")) }
    var isOtpVisible by remember { mutableStateOf(false) }
    var verificationInProgress by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    Card(
            modifier = Modifier
                .height(350.dp) // Increased height for error message
                .fillMaxWidth(1f)
                .wrapContentHeight(),
    shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(1f)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Login with phone number",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            TextField(
                value = phoneNumber,
                onValueChange = { if (it.text.length <= 10) phoneNumber = it },
                label = { Text("Enter phone number") },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 4.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            if (isOtpVisible) {
                TextField(
                    value = otp,
                    onValueChange = { otp = it },
                    label = { Text("Enter OTP") },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 4.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            if (!isOtpVisible) {
                Button(
                    onClick = {
                        errorMessage = "" // Clear previous error messages
                        verificationInProgress = true
                        onLoginClicked(context, phoneNumber.text) {
                            isOtpVisible = true
                            verificationInProgress = false
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 8.dp),
                    enabled = !verificationInProgress // Disable while verification is in progress
                ) {
                    if (verificationInProgress) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = Color.White
                        )
                    } else {
                        Text(text = "Send OTP", color = Color.White)
                    }
                }
            }

            if (isOtpVisible) {
                Button(
                    onClick = {
                        errorMessage = ""
                        verifyPhoneNumberWithCode(context, storedVerificationId, otp.text) { success ->
                            if (success) {
                                dialogState.value = false // Close dialog on success
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 8.dp)
                ) {
                    Text(text = "Verify", color = Color.White)
                }
            }
        }
    }
}

private fun verifyPhoneNumberWithCode(
    context: Context,
    verificationId: String,
    code: String,
    onVerificationComplete: (Boolean) -> Unit
) {
    val credential = PhoneAuthProvider.getCredential(verificationId, code)
    signInWithPhoneAuthCredential(context, credential, onVerificationComplete)
}

fun onLoginClicked(context: Context, phoneNumber: String, onCodeSent: () -> Unit) {
    auth.setLanguageCode("en")
    val callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            Toast.makeText(context, "Verification completed", Toast.LENGTH_SHORT).show()
            signInWithPhoneAuthCredential(context, credential) { success ->
                onCodeSent() // Trigger OTP visibility even if auto-verified
            }
        }

        override fun onVerificationFailed(e: FirebaseException) {
            val message = when (e) {
                is FirebaseAuthInvalidCredentialsException -> "Invalid phone number"
                is FirebaseTooManyRequestsException -> "Quota exceeded. Try again later."
                else -> "Verification failed: ${e.message}"
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            // Handle the failure appropriately (e.g., show error message)
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            Toast.makeText(context, "Code sent to $phoneNumber", Toast.LENGTH_SHORT).show()
            storedVerificationId = verificationId
            onCodeSent()
        }
    }

    val activity = context as? Activity
    val options = activity?.let {
        PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+91$phoneNumber")
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(it)
            .setCallbacks(callback)
            .build()
    }

    if (options != null) {
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}

private fun signInWithPhoneAuthCredential(
    context: Context,
    credential: PhoneAuthCredential,
    onVerificationComplete: (Boolean) -> Unit
) {
    auth.signInWithCredential(credential)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = task.result?.user
                Toast.makeText(context, "Sign in successful", Toast.LENGTH_SHORT).show()
                onVerificationComplete(true)
            } else {
                val message = when (task.exception) {
                    is FirebaseAuthInvalidCredentialsException -> "Invalid OTP"
                    else -> "Sign in failed: ${task.exception?.message}"
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                onVerificationComplete(false)
            }
        }
}