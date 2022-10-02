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
import pl.gungnir.database.firebase.FirebaseManager
import pl.gungnir.database.firebase.FirebaseManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideFirebaseManager(): FirebaseManager {
        return FirebaseManagerImpl()
    }

    @Singleton
    @Provides
    fun provideBuyListRepository(
        firebaseManager: FirebaseManager
    ): BuyListRepository = BuyListRepositoryImpl(firebaseManager)

    @Singleton
    @Provides
    fun provideCategoryRepository(
        categoryDao: CategoryDao
    ): CategoryRepository = CategoryRepositoryImpl(categoryDao)
}