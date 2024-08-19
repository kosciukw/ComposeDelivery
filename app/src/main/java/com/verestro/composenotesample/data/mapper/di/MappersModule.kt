package com.verestro.composenotesample.data.mapper.di

import com.verestro.composenotesample.data.mapper.CardDomainToUiModelMapper
import com.verestro.composenotesample.data.mapper.impl.CardDomainToUiModelMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MappersModule {

    @Singleton
    @Provides
    fun provideCardDomainToUiModelMapper(): CardDomainToUiModelMapper {
        return CardDomainToUiModelMapperImpl()
    }
}