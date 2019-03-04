package com.framgia.trainingclean.data.di

import com.framgia.trainingclean.data.MovieRepositoryImpl
import com.framgia.trainingclean.domain.repository.MovieRepository
import com.google.gson.Gson
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val repositoryModule: Module = module {
    single { Gson() }
    single<MovieRepository> { create<MovieRepositoryImpl>() }
}