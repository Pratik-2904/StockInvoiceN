package com.example.stockinvoice.database.productandServices

import kotlinx.coroutines.flow.Flow


interface ProductsRepository {


    //      Retrieve all the items from the the given data source.
    fun getAllProductsAscending() : Flow<List<Product>>
   fun getAllProductsDescending() : Flow<List<Product>>


//    Retrieve an item from the given data source that matches with the [id].

    fun getItemStream(id: Int): Flow<Product?>


//     Insert item in the data source

    suspend fun insertProduct(product: Product)

//      Delete item from the data source

    suspend fun deleteProduct(product: Product)


//      Update item in the data source

    suspend fun updateProduct(product: Product)
}