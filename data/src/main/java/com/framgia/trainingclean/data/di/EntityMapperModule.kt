package com.framgia.trainingclean.data.di

import com.framgia.trainingclean.data.model.MovieEntityMapper
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val entityMapperModule: Module = module {
    single<MovieEntityMapper>()
}