package pl.gungnir.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import pl.gungnir.database.entity.CategoryEntity

@Dao
interface CategoryDao : BaseDao<CategoryEntity> {

    @Transaction
    @Query("SELECT * FROM category")
    fun getCategory(): Flow<List<CategoryEntity>>

}