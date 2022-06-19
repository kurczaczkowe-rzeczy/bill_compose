package pl.kurczaczkowe.bills.domain.repository

import pl.kurczaczkowe.bills.data.model.CategoryProduct
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.ui.screen.base.Failure

interface BuyListRepository {

    fun getBuyList(id: Int): Either<Failure, List<CategoryProduct>>
}