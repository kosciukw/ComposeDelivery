package com.verestro.composenotesample.di

import com.verestro.composenotesample.data.repository.CategoriesRepository
import com.verestro.composenotesample.data.repository.UserRepository
import com.verestro.composenotesample.data.repository.impl.CategoryRepositoryImpl
import com.verestro.composenotesample.data.repository.impl.UserRepositoryImpl
import com.verestro.composenotesample.utils.Fixtures
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideFixtures(): Fixtures {
        return Fixtures()
    }

    @Singleton
    @Provides
    fun provideCategoriesRepository(): CategoriesRepository {
        return CategoryRepositoryImpl(provideFixtures())
    }

    @Singleton
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl(provideFixtures())
    }
}