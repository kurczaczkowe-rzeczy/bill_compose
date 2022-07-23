package pl.kurczaczkowe.bills.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.database.domain.repository.BuyListRepository
import pl.gungnir.database.domain.repository.CategoryRepository
import pl.gungnir.fetaurecategories.useCase.CreateCategoryUseCase
import pl.gungnir.featureshoppinglist.useCase.GetBuyListUseCase
import pl.gungnir.fetaurecategories.useCase.GetCategoryListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetBuyListUseCase(repository: BuyListRepository) = GetBuyListUseCase(repository)

    @Singleton
    @Provides
    fun provideGetCategoryListUseCase(repository: CategoryRepository) =
        GetCategoryListUseCase(repository)

    @Singleton
    @Provides
    fun provideCreateCategoryUseCase(repository: CategoryRepository) =
        CreateCategoryUseCase(repository)
}