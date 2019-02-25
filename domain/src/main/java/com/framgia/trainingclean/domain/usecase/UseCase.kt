package com.framgia.trainingclean.domain.usecase

/*
* Code something for base
* */

abstract class UseCase<in Params, out T> where T : Any {

    abstract fun createObservable(param: Params? = null): T

    abstract fun onCleared()
}