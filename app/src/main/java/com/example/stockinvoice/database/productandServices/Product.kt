package com.example.stockinvoice.database.productandServices

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val sellPrice: Double,
    val purchasePrice: Double = 0.0,
    val tax: Double = 0.0,
    val hsn: String? = "",
    val unit: String = "Pieces",
    val stock: Int = 0,
    val image: String? = null
)

@Entity(tableName = "Services")
data class Service(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val sellPrice: Double,
    val purchasePrice: Double = 0.0,
    val tax: Double = 0.0,
    val sac: String? = "",
    val unit: String = " ",
    val stock: Int = 0,
    val image: String? = null
)