package pl.gungnir.components.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.gungnir.components.toolbar.ToolbarManager
import pl.gungnir.components.toolbar.ToolbarManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class Module {

    @Binds
    @Singleton
    abstract fun provideToolbarManager(toolbarManagerImpl: ToolbarManagerImpl): ToolbarManager
}