package pl.kurczaczkowe.bills.domain.usecase

import pl.gungnir.base.BaseUseCase
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.database.domain.repository.CategoryRepository
import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.util.toCategoryEntity

class CreateCategoryUseCase(
    private val repository: CategoryRepository
) : BaseUseCase<Either<Failure, Unit>, Category>() {

    override suspend fun run(params: Category): Either<Failure, Unit> {
        return repository.createCategory(params.toCategoryEntity())
    }
}