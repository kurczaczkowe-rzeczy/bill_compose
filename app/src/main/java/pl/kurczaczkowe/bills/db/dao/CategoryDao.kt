package pl.kurczaczkowe.bills.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import pl.kurczaczkowe.bills.db.entity.CategoryEntity

@Dao
interface CategoryDao : BaseDao<CategoryEntity> {

    @Transaction
    @Query("SELECT * FROM category")
    fun getCategory(): Flow<List<CategoryEntity>>

}