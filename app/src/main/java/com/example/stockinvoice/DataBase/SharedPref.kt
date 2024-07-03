package com.example.stockinvoice.DataBase


import android.annotation.SuppressLint
import android.content.Context
object SharedPref{


    @SuppressLint("SuspiciousIndentation")
    fun storeData(name:String?,
                  mail:String?,
                  Phonenum:String?,
                  GSTnum:String?,
                  uid:String?,
                  context: Context
    ){

        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor =sharedPref.edit()
        editor.putString("name",name)
        editor.putString("mail",mail)
        editor.putString("Phonenum",Phonenum)
        editor.putString("GSTnum",GSTnum)
        editor.apply()
    }

    fun getUserName(context: Context):String{
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("name","")!!
    }

    fun getUserMail(context: Context):String{
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("mail","")!!
    }

    fun getUserBio(context: Context):String{
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("GSTnum","")!!
    }

    fun getName(context: Context):String{
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("Phonenum","")!!
    }



}