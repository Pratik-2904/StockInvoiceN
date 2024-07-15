package com.example.stockinvoice.database.productandServices

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val productDao: ProductDao) : ProductsRepository {
    override fun getAllProductsAscending(): Flow<List<Product>> = productDao.getAllItemsAsc()
    override fun getAllProductsDescending(): Flow<List<Product>> = productDao.getAllItemsDesc()

    override fun getItemStream(id: Int): Flow<Product?> = productDao.getItem(id)
    override suspend fun insertProduct(product: Product) = productDao.UpsertProduct(product)
    override suspend fun updateProduct(product: Product) = productDao.UpsertProduct(product)
    override suspend fun deleteProduct(product: Product) = productDao.DeleteProduct(product)


}