package com.example.stockinvoice.database.productandServices

import android.content.Context

interface AppContainer {
    val productsRepository: ProductsRepository
}


class AppDataContainer(
    private val context: Context
) : AppContainer {
    override val productsRepository: ProductsRepository by lazy {
        OfflineItemsRepository(ProductsDatabase.getDatabase(context).productDao())
    }
}