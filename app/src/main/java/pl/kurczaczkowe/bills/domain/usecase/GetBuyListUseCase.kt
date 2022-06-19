package pl.kurczaczkowe.bills.domain.usecase

import pl.kurczaczkowe.bills.data.model.CategoryProduct
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.domain.repository.BuyListRepository
import pl.kurczaczkowe.bills.ui.screen.base.Failure

class GetBuyListUseCase(
    private val buyListRepository: BuyListRepository
) : BaseUseCase<Either<Failure, List<CategoryProduct>>, Int>() {

    override suspend fun run(params: Int): Either<Failure, List<CategoryProduct>> {
        return buyListRepository.getBuyList(params)
    }
}