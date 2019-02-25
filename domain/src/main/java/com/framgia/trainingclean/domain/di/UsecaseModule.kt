package com.framgia.trainingclean.domain.di

import com.framgia.trainingclean.domain.usecase.movie.GetMovieUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<GetMovieUseCase>()
}