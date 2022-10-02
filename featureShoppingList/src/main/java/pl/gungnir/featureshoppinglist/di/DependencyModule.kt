package pl.gungnir.featureshoppinglist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.database.domain.repository.BuyListRepository
import pl.gungnir.featureshoppinglist.useCase.GetBuyListUseCase
import pl.gungnir.featureshoppinglist.useCase.GetBuyListsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DependencyModule {

    @Singleton
    @Provides
    fun provideGetBuyListUseCase(repository: BuyListRepository): GetBuyListUseCase {
        return GetBuyListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetBuyListsUseCase(repository: BuyListRepository): GetBuyListsUseCase {
        return GetBuyListsUseCase(repository)
    }

}