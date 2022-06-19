package pl.kurczaczkowe.bills.domain.usecase

import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.data.model.CategoryProduct
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.domain.None
import pl.kurczaczkowe.bills.domain.repository.BuyListRepository
import pl.kurczaczkowe.bills.domain.repository.CategoryRepository
import pl.kurczaczkowe.bills.ui.screen.base.Failure

class GetCategoryListUseCase(
    private val repository: CategoryRepository
) : BaseUseCase<Either<Failure, List<Category>>, None>() {

    override suspend fun run(params: None): Either<Failure, List<Category>> {
        return repository.getCategories()
    }
}