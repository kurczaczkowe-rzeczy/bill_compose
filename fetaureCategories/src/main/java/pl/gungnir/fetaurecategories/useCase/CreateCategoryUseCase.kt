package pl.gungnir.fetaurecategories.useCase

import pl.gungnir.base.BaseUseCase
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.database.domain.repository.CategoryRepository
import pl.gungnir.fetaurecategories.data.Category
import pl.gungnir.fetaurecategories.util.toCategoryEntity

class CreateCategoryUseCase(
    private val repository: CategoryRepository
) : BaseUseCase<Either<Failure, Unit>, Category>() {

    override suspend fun run(params: Category): Either<Failure, Unit> {
        return repository.createCategory(params.toCategoryEntity())
    }
}