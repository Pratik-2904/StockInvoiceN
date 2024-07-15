//package com.example.stockinvoice.Screens
//
//import android.Manifest
//import android.annotation.SuppressLint
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.icu.text.ListFormatter.Width
//import android.net.Uri
//import android.os.Build
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material.icons.filled.Share
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.ModalBottomSheet
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.rememberModalBottomSheetState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.core.content.ContextCompat
//import coil.compose.rememberAsyncImagePainter
//import com.example.stockinvoice.DataBase.SharedPref
//import com.example.stockinvoice.R
//
////import com.example.stockinvoice.bottomSheet
//
//
////Store image uri is remaining
////and otp issue
//
////line no. 168 to 172 shared pref issue
////main profile screen is not updating after cahnges are saved in sharedpref
//
//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun ProfileScaffold() {
//
//    val context = LocalContext.current
//    val shouldShowBottomSheet = remember { mutableStateOf(false) }
//    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
//
//    //decalring variables for cndition(if user want to edit profile)
//    val CompanyName = remember { mutableStateOf("") }
//    val Phonenum = remember { mutableStateOf("") }
//    val GSTnum = remember { mutableStateOf("") }
//    val CompanyAddress = remember { mutableStateOf("") }
//
//
//
//    Scaffold(
//        topBar = {
//
//            TopAppBar(title = { Text(text = "profileScreen") },
//                navigationIcon = {
//                    IconButton(onClick = {   // Add functionalty
//
//                    }) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "BACK"
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = {
//                        shouldShowBottomSheet.value = true
//                    }) {
//                        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
//                    }
//                }
//
//            )
//        }
//    ) {
//        Column {
//            ProfileScreen()
//        }
//        if (shouldShowBottomSheet.value) {
//
//            ModalBottomSheet(
//                onDismissRequest = { shouldShowBottomSheet.value = false },
//                sheetState = sheetState,
//                content = {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(10.dp),
////               verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(text = "Edit Profile", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//
//
//                        Image(painter = painterResource(id = R.drawable.user), contentDescription = null,
//                            modifier = Modifier.size(50.dp))
//
//                        //function for editing image  but before that implemnt functioanlity fr saving image in Shared pref and DB
////                        Box(modifier = Modifier.padding(10.dp))
//                        OutlinedTextField(value = CompanyName.value,
//                            onValueChange = { CompanyName.value = it },
//                            label = { Text(text = "Company Name") },
//                            shape = RoundedCornerShape(11.dp)
//                        )
//                        Box(modifier = Modifier.padding(10.dp))
//                        OutlinedTextField(value = Phonenum.value,
//                            onValueChange = { Phonenum.value = it },
//                            label = { Text(text = "Bussiness Phone No.") },
//                            shape = RoundedCornerShape(11.dp)
//                        )
//                        Box(modifier = Modifier.padding(10.dp))
//                        OutlinedTextField(value = GSTnum.value,
//                            onValueChange = { GSTnum.value = it },
//                            label = { Text(text = "GST No.") },
//                            shape = RoundedCornerShape(12.dp)
//                        )
////                        Box(modifier = Modifier.padding(10.dp))
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.Center
//                        ) {
//                            Button(
//                                onClick = {
//                                 if(CompanyName.value==""|| Phonenum.value=="" || GSTnum.value=="") {
//                                     Toast.makeText(context,"Please Fill all details",Toast.LENGTH_SHORT).show()
//                                 }else{
//       //************main profile screen in not updating after below changes
//                                    SharedPref.updateName(context,CompanyName.value)
//                                        SharedPref.updateGSTnum(context,GSTnum.value)
//                                    SharedPref.updatePhonenum(context,Phonenum.value)
//                                    shouldShowBottomSheet.value=false
//                                    Toast.makeText(context,"Changes Saved",Toast.LENGTH_SHORT).show()
//                                } },
//                                modifier = Modifier.fillMaxWidth(0.5f)
//                            ) {
//                                Text(text = "SAVE & UPDATE")
//                            }
//                        }
//
//
//                    }
//                }
//            )
//        }
//
//    }
//
//}
//
//
//@Composable
//fun ProfileScreen() {
//    val context = LocalContext.current
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
////                .fillMaxHeight(0.62f)
//            .height(510.dp)
//            .padding(15.dp),
//        colors = CardDefaults.cardColors(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp
//        ),
//        shape = RoundedCornerShape(10.dp)
//    ) {
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(15.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            userInfo(context)
//        }
//    }
//
//
//    Text(
//        text = "Billing Address", modifier = Modifier.padding(0.dp),
//        fontWeight = FontWeight.Bold, fontSize = 18.sp
//    )
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
////                .fillMaxHeight(0.62f)
////            .height(510.dp)
//            .padding(15.dp),
//        colors = CardDefaults.cardColors(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp
//        ),
//        shape = RoundedCornerShape(10.dp)
//    ) {
//
//        Column(
//            modifier = Modifier
////                .fillMaxSize()
//                .padding(15.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            BillingAddress(context)
//        }
//
//
//    }
//
//
//    Text(
//        text = "Shipping Address", modifier = Modifier.padding(0.dp),
//        fontWeight = FontWeight.Bold, fontSize = 18.sp
//    )
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
////                .fillMaxHeight(0.62f)
////            .height(510.dp)
//            .padding(15.dp),
//        colors = CardDefaults.cardColors(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp
//        ),
//        shape = RoundedCornerShape(10.dp)
//    ) {
//
//        Column(
//            modifier = Modifier
////                .fillMaxSize()
//                .padding(15.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            ShippingAddress(context = context)
//            //            BillingAddress(context)
//        }
//
//
//    }
//
//
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BillingAddress(context: Context) {
//
//
//    val isEditDialog = remember { mutableStateOf(false) }  // for alert dialog after ondelete click
//    val isDeleteDialog = remember { mutableStateOf(false) }
//    Text(
//        text = SharedPref.getBillingAddress(context)
//    )
//
//
//
//    Row(modifier = Modifier.fillMaxWidth(0.5f), Arrangement.SpaceAround) {
//        TextButton(onClick = {
//
//            isEditDialog.value = true
//        }) {
//            Text(text = "Edit")
//        }
//        TextButton(onClick = {
//            isDeleteDialog.value = true
////            SharedPref.updateBillingAddress(context, "")   //delete address
//        }) {
//            Text(text = "Delete")
//        }
//
//        IconButton(onClick = {
//            if (SharedPref.getBillingAddress(context) == "") {
//                Toast.makeText(context, "Please add address frist", Toast.LENGTH_SHORT).show()
//            } else {
//                //functionality for sharing
//                shareText(context, SharedPref.getBillingAddress(context))
//            }
//        }) {
//            Icon(imageVector = Icons.Default.Share, contentDescription = null)
//        }
//
//    }
//
//
//    if (isDeleteDialog.value == true) {   //for onclick delete
//        AlertDialog(onDismissRequest = { isDeleteDialog.value = false }, confirmButton = {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Text(text = "Sure want to delete ?")
//                Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
//                    Button(onClick = {
//                        SharedPref.updateBillingAddress(context, "")
//                        isDeleteDialog.value = false
//                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
//                    }) {
//                        Text(text = "Delete")
//                    }
//
//                    Button(onClick = {
//                        isDeleteDialog.value = false
//                    }) {
//                        Text(text = "cancel")
//                    }
//                }
//            }
//
//        })
//    }
//
//
//    if (isEditDialog.value) {   //for editing billingn address
//        val newBillingAddress = remember { mutableStateOf("") }
//        AlertDialog(onDismissRequest = { isEditDialog.value = false }, confirmButton = {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Text(text = "Add New Billing Address", fontWeight = FontWeight.Bold)
//                OutlinedTextField(
//                    value = newBillingAddress.value,
//                    onValueChange = { newBillingAddress.value = it })
//                Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
//                    Button(onClick = {
//                        if (newBillingAddress.value.isNotBlank()) {
//                            SharedPref.updateBillingAddress(context, newBillingAddress.value)
//                            isEditDialog.value = false
//                            Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(context, "Please enter new Adrress", Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                    }) {
//                        Text(text = "Save")
//                    }
//                    Button(onClick = { isEditDialog.value = false }) {
//                        Text(text = "cancel")
//                    }
//                }
//            }
//        })
//    }
//
//}
//
//
////functionalty for sharing
//fun shareText(context: Context, text: String) {
//    val shareIntent = Intent().apply {
//        action = Intent.ACTION_SEND
//        putExtra(Intent.EXTRA_TEXT, text)
//        type = "text/plain"
//    }
//    context.startActivity(Intent.createChooser(shareIntent, null))
//}
//
//
//@Composable
//fun ShippingAddress(context: Context) {
//    val isEditDialog = remember { mutableStateOf(false) }  // for alert dialog after onEdit click
//    val isDeleteDialog = remember { mutableStateOf(false) }// for alert dialog after onDelete click
//
//    Text(
//        text = SharedPref.getShipping(context)
//    )
//
//    Row(modifier = Modifier.fillMaxWidth(0.5f), Arrangement.SpaceAround) {
//        TextButton(onClick = { isEditDialog.value = true }) {
//            Text(text = "Edit")
//        }
//        TextButton(onClick = {
//            isDeleteDialog.value = true
////            SharedPref.updateShippingAddress(context, "")   //delete address
//        }) {
//            Text(text = "Delete")
//        }
//
//        IconButton(onClick = {
//            if (SharedPref.getShipping(context) == "") {
//                Toast.makeText(context, "Please add address first", Toast.LENGTH_SHORT).show()
//            } else {
//                //functionality for sharing
//                shareText(context, SharedPref.getShipping(context))
//            }
//        }) {
//            Icon(imageVector = Icons.Default.Share, contentDescription = null)
//        }
//
//    }
//
//    if (isDeleteDialog.value == true) {   //for onclick delete
//        AlertDialog(onDismissRequest = { isDeleteDialog.value = false }, confirmButton = {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Text(text = "Sure want to delete ?")
//                Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
//                    Button(onClick = {
//                        SharedPref.updateShippingAddress(context, "")
//                        isDeleteDialog.value = false
//                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
//                    }) {
//                        Text(text = "Delete")
//                    }
//
//                    Button(onClick = {
//                        isDeleteDialog.value = false
//                    }) {
//                        Text(text = "cancel")
//                    }
//                }
//            }
//
//        })
//    }
//
//
//    if (isEditDialog.value) {   //for editing billingn address
//        val newShippingAddress = remember { mutableStateOf("") }
//        AlertDialog(onDismissRequest = { isEditDialog.value = false }, confirmButton = {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Text(text = "Add New Shipping Address", fontWeight = FontWeight.Bold)
//                OutlinedTextField(
//                    value = newShippingAddress.value,
//                    onValueChange = { newShippingAddress.value = it })
//                Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
//                    Button(onClick = {
//                        if (newShippingAddress.value.isNotBlank()) {
//                            SharedPref.updateShippingAddress(context, newShippingAddress.value)
//                            isEditDialog.value = false
//                            Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(context, "Please enter new Adrress", Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                    }) {
//                        Text(text = "Save")
//                    }
//                    Button(onClick = { isEditDialog.value = false }) {
//                        Text(text = "cancel")
//                    }
//                }
//            }
//        })
//    }
//
//}
//
//
//@Composable
//fun userInfo(context: Context) {
//    var imageuri by remember { mutableStateOf<Uri?>(null) }
//    val launcher =
//        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//            if (uri != null) {
//                imageuri = uri
//            } else {
//                Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//    val permissionToRequest = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        Manifest.permission.READ_MEDIA_IMAGES
//    } else {
//        Manifest.permission.READ_EXTERNAL_STORAGE
//    }
//
//    val permissionLauncher =
//        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
//            if (isGranted) {
//                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
//                launcher.launch("image/*")
//            } else {
//                Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//
//    Image(
//        painter = if (imageuri == null) {
//            painterResource(id = R.drawable.user)
//        } else {
//            rememberAsyncImagePainter(model = imageuri)
//        },
//        contentDescription = null,
//        modifier = Modifier
//            .size(95.dp)
//            .clip(CircleShape)
//            .clickable {
//                val isGranted = ContextCompat.checkSelfPermission(
//                    context,
//                    permissionToRequest
//                ) == PackageManager.PERMISSION_GRANTED
//
//                if (isGranted) {
//                    launcher.launch("image/*")
//                } else {
//                    permissionLauncher.launch(permissionToRequest)
//                }
//            },
//        contentScale = ContentScale.Crop
//    )
//    Box(modifier = Modifier.padding(10.dp))
//
//    Text(text = "Company Name : ", fontWeight = FontWeight.Thin, fontSize = 15.sp)
//                Text(text = SharedPref.getName(context), fontWeight = FontWeight.Light)
////    Text(text = "company /name ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//
//    divider()
//
//    Text(text = "GST No.  : ", fontWeight = FontWeight.Thin, fontSize = 15.sp)
////                Text(text = SharedPref.getGStnum(context), fontWeight = FontWeight.Light)
//    Text(text = "120151565156 ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//    divider()
//    Text(text = "Phone No. : ", fontWeight = FontWeight.Thin, fontSize = 15.sp)
////               Text(text = SharedPref.getPhonenum(context), fontWeight = FontWeight.Light)
//    Text(text = "+9194826598", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//    divider()
//    Text(text = "Company Address  : ", fontWeight = FontWeight.Thin, fontSize = 15.sp)
////                Text(text = SharedPref.getAddress(context), fontWeight = FontWeight.Light)
//    Text(text = "Pune!!!!", fontWeight = FontWeight.Bold, fontSize = 18.sp)
////Box(modifier = Modifier.padding(10.dp))
//
//}
//
//@Composable
//fun divider() {
//    HorizontalDivider(
//        modifier = Modifier.padding(vertical = 8.dp),
//        thickness = 0.2.dp,
//        color = Color.LightGray
//    )
//
//}
//
//
//
