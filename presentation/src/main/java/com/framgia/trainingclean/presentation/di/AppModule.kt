package com.framgia.trainingclean.presentation.di

import com.framgia.trainingclean.data.di.entityMapperModule
import com.framgia.trainingclean.data.di.networkModule
import com.framgia.trainingclean.data.di.repositoryModule
import com.framgia.trainingclean.presentation.rx.AppSchedulerProvider
import com.framgia.trainingclean.presentation.rx.SchedulerProvider
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val appModule: Module = module {
    single<SchedulerProvider> { AppSchedulerProvider() }
}


val modules: List<Module> = listOf(
    entityMapperModule,
    networkModule,
    repositoryModule,
    appModule
)