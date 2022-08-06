package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.database.entity.CategoryEntity

interface CategoryRepository {

    fun getCategories(): Flow<List<CategoryEntity>>

    suspend fun createCategory(category: CategoryEntity): Either<Failure, Unit>
}