package pl.kurczaczkowe.bills.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kurczaczkowe.bills.data.repository.BuyListRepositoryImpl
import pl.kurczaczkowe.bills.domain.repository.BuyListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBuyListRepository(): BuyListRepository = BuyListRepositoryImpl()
}