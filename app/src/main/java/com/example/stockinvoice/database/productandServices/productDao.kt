package com.example.stockinvoice.database.productandServices

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Upsert
    suspend fun UpsertProduct(product: Product)

    @Delete
    suspend fun DeleteProduct(product: Product)

    @Query("SELECT * from products WHERE id = :id")
    fun getItem(id: Int): Flow<Product>

    @Query("SELECT * from products ORDER BY name ASC")
    fun getAllItemsAsc(): Flow<List<Product>>

    @Query("SELECT * from products ORDER BY name DESC")
    fun getAllItemsDesc(): Flow<List<Product>>
}

@Dao
interface ServiceDao {
    @Upsert
    suspend fun UpsertService(service: Service)

    @Delete
    suspend fun DeleteService(service: Service)

    @Query("SELECT * from services WHERE id = :id")
    fun getItem(id: Int): Flow<Service>

    @Query("SELECT * from services ORDER BY name ASC")
    fun getAllItemsAsc(): Flow<List<Service>>

    @Query("SELECT * from services ORDER BY name DESC")
    fun getAllItemsDesc(): Flow<List<Service>>
}