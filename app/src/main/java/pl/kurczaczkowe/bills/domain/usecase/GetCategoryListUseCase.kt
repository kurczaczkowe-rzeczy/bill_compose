package pl.kurczaczkowe.bills.domain.usecase

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.gungnir.base.*
import pl.gungnir.database.domain.repository.CategoryRepository
import pl.kurczaczkowe.bills.data.model.Category

class GetCategoryListUseCase(
    private val repository: CategoryRepository
) : BaseUseCase<Either<Failure, Flow<List<Category>>>, None>() {

    override suspend fun run(params: None): Either<Failure, Flow<List<Category>>> {
        return repository.getCategories()
            .map {
                it.map {
                    Category(
                        id = it.idCategory ?: 0,
                        name = it.nameCategory,
                        color = Color(it.colorCategory)
                    )
                }
            }.right()
    }
}