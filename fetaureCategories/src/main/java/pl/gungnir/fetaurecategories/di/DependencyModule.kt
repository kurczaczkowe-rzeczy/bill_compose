package pl.gungnir.fetaurecategories.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.database.domain.repository.CategoryRepository
import pl.gungnir.fetaurecategories.useCase.CreateCategoryUseCase
import pl.gungnir.fetaurecategories.useCase.GetCategoryListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DependencyModule {

    @Singleton
    @Provides
    fun provideGetCategoryListUseCase(repository: CategoryRepository): GetCategoryListUseCase {
        return GetCategoryListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCreateCategoryUseCase(repository: CategoryRepository) : CreateCategoryUseCase {
        return CreateCategoryUseCase(repository)
    }

}