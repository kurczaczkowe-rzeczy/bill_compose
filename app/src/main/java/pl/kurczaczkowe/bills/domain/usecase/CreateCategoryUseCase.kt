package pl.kurczaczkowe.bills.domain.usecase

import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.db.entity.CategoryEntity
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.domain.repository.CategoryRepository
import pl.kurczaczkowe.bills.ui.screen.base.Failure
import pl.kurczaczkowe.bills.util.toCategoryEntity

class CreateCategoryUseCase(
    private val repository: CategoryRepository
) : BaseUseCase<Either<Failure, Unit>, Category>() {

    override suspend fun run(params: Category): Either<Failure, Unit> {
        return repository.createCategory(params.toCategoryEntity())
    }
}