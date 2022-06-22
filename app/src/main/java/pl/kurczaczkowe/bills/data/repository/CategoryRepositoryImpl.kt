package pl.kurczaczkowe.bills.data.repository

import kotlinx.coroutines.flow.Flow
import pl.kurczaczkowe.bills.db.dao.CategoryDao
import pl.kurczaczkowe.bills.db.entity.CategoryEntity
import pl.kurczaczkowe.bills.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
): CategoryRepository {

    override fun getCategories(): Flow<List<CategoryEntity>> {
        return categoryDao.getCategory()
    }

}