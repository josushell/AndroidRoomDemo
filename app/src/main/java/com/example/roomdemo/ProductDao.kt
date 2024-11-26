package com.example.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product: Product)

    @Query("SELECT * FROM products WHERE productname = :name")
    fun findProduct(name: String): List<Product>

    @Query("DELETE FROM products WHERE productname = :name")
    fun deleteProduct(name: String): Boolean

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>
}