package com.example.stockinvoice.database


data class usermodel(
    val name: String = "",
    val mail: String = "",
    val Phonenum: String? = "",
    val GSTnum: String? = "",
    val password: String = "",
    val uid: String = ""   //firebase uid
)


data class billInfo(
    val uid:String?="",
    val BillingAddress:String="",
    val ShippingAddress:String=""
)