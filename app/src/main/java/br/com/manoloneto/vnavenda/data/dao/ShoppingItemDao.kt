package br.com.manoloneto.vnavenda.data.dao

import androidx.room.*
import br.com.manoloneto.vnavenda.data.entities.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingItemDao {
    @Query("SELECT * FROM shopping_items")
    fun getAllItems(): Flow<List<ShoppingItem>>

    @Query("SELECT * FROM shopping_items WHERE id = :id")
    fun getItemById(id: Int): Flow<ShoppingItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingItem)

    @Update
    suspend fun updateItem(item: ShoppingItem)

    @Delete
    suspend fun deleteItem(item: ShoppingItem)
}