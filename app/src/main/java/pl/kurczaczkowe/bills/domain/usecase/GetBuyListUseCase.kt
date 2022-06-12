package pl.kurczaczkowe.bills.domain.usecase

import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.domain.repository.BuyListRepository
import pl.kurczaczkowe.bills.ui.screen.base.Failure

class GetBuyListUseCase(
    private val buyListRepository: BuyListRepository
) : BaseUseCase<Either<Failure, List<Category>>, Int>() {

    override suspend fun run(params: Int): Either<Failure, List<Category>> {
        return buyListRepository.getBuyList(params)
    }
}