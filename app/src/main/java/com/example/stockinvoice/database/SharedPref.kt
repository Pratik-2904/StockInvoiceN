package com.example.stockinvoice.database

import android.annotation.SuppressLint
import android.content.Context

object SharedPref {

    @SuppressLint("SuspiciousIndentation")
    fun storeData(
        name: String?,
        mail: String,
        Phonenum: String?,
        GSTnum: String?,
        password :String="",
        uid: String?,
        context: Context
    ) {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", name)
        editor.putString("mail", mail)
        editor.putString("Phonenum", Phonenum)
        editor.putString("GSTnum", GSTnum)
        editor.putString("password", password)

        editor.apply()
    }

    fun getName(context: Context): String {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("name", "")!!
    }

    fun getUserMail(context: Context): String {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("mail", "")!!
    }

    fun getGStnum(context: Context): String {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("GSTnum", "")!!
    }

    fun getPhonenum(context: Context): String {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("Phonenum", "")!!
    }

    fun getPassword(context: Context): String {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPref.getString("password", "")!!
    }

    // Update functions
    fun updateName(context: Context, name: String) {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", name)
        editor.apply()
    }

    fun updateUserMail(context: Context, mail: String) {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("mail", mail)
        editor.apply()
    }

    fun updatePhonenum(context: Context, Phonenum: String) {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("Phonenum", Phonenum)
        editor.apply()
    }

    fun updateGSTnum(context: Context, GSTnum: String) {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("GSTnum", GSTnum)
        editor.apply()
    }


    fun updatePassword(context: Context, GSTnum: String) {
        val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("GSTnum", GSTnum)
        editor.apply()
    }

}
