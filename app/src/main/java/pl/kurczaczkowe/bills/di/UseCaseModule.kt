package pl.kurczaczkowe.bills.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kurczaczkowe.bills.domain.repository.BuyListRepository
import pl.kurczaczkowe.bills.domain.repository.CategoryRepository
import pl.kurczaczkowe.bills.domain.usecase.CreateCategoryUseCase
import pl.kurczaczkowe.bills.domain.usecase.GetBuyListUseCase
import pl.kurczaczkowe.bills.domain.usecase.GetCategoryListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetBuyListUseCase(repository: BuyListRepository) = GetBuyListUseCase(repository)

    @Singleton
    @Provides
    fun provideGetCategoryListUseCase(repository: CategoryRepository) = GetCategoryListUseCase(repository)

    @Singleton
    @Provides
    fun provideCreateCategoryUseCase(repository: CategoryRepository) = CreateCategoryUseCase(repository)
}