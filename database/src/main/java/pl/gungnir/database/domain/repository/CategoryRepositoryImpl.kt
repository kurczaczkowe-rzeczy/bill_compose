package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.base.right
import pl.gungnir.database.dao.CategoryDao
import pl.gungnir.database.entity.CategoryEntity
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
): CategoryRepository {

    override fun getCategories(): Flow<List<CategoryEntity>> {
        return categoryDao.getCategory()
    }

    override suspend fun createCategory(category: CategoryEntity): Either<Failure, Unit> {
        return categoryDao.insert(category).right()
    }

}