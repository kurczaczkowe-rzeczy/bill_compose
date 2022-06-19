package pl.kurczaczkowe.bills.data.repository

import androidx.compose.ui.graphics.Color
import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.domain.repository.CategoryRepository
import pl.kurczaczkowe.bills.domain.right
import pl.kurczaczkowe.bills.ui.screen.base.Failure

class CategoryRepositoryImpl: CategoryRepository {

    override fun getCategories(): Either<Failure, List<Category>> {
        return categories.right()
    }

    private val categories = listOf(
        Category(id = 0, name = "Category 1", color = Color.Red),
        Category(id = 1, name = "Category 2", color = Color.Green),
        Category(id = 2, name = "Category 3", color = Color.Blue),
    )

}