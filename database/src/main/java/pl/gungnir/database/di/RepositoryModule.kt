package pl.gungnir.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.database.dao.CategoryDao
import pl.gungnir.database.domain.repository.BuyListRepository
import pl.gungnir.database.domain.repository.BuyListRepositoryImpl
import pl.gungnir.database.domain.repository.CategoryRepository
import pl.gungnir.database.domain.repository.CategoryRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBuyListRepository(
        categoryDao: CategoryDao
    ): BuyListRepository = BuyListRepositoryImpl(categoryDao)

    @Singleton
    @Provides
    fun provideCategoryRepository(
        categoryDao: CategoryDao
    ): CategoryRepository = CategoryRepositoryImpl(categoryDao)
}