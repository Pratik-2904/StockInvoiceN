package com.example.stockinvoice.database.productandServices

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Product::class, Service::class],
    version = 1,
    exportSchema = true
)
abstract class ProductsDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun serviceDao(): ServiceDao

    companion object {
        @Volatile
        private var Instance: ProductsDatabase? = null
        fun getDatabase(context: Context): ProductsDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ProductsDatabase::class.java, "product_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}