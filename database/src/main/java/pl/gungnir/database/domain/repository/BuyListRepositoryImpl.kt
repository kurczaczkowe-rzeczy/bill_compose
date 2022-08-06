package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.base.right
import pl.gungnir.database.dao.CategoryDao
import pl.gungnir.database.entity.CategoryEntity
import javax.inject.Inject

class BuyListRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
): BuyListRepository {

    override fun getBuyList(id: Int): Either<Nothing, Flow<List<CategoryEntity>>> {
        return categoryDao.getCategory().right()
    }
}