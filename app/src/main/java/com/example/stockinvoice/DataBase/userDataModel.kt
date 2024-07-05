package com.example.stockinvoice.DataBase


data class UserModel(
    val name: String = "",
    val mail: String = "",
    val phoneNo: String = "",
    val gstNum: String = "",
    val password: String = "",
    val uid: String = ""   //firebase uid
)
