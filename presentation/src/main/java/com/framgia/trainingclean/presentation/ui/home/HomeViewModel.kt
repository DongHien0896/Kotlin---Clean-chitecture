package com.framgia.trainingclean.presentation.ui.home

import android.arch.lifecycle.MutableLiveData
import com.framgia.trainingclean.domain.usecase.movie.GetMovieUseCase
import com.framgia.trainingclean.presentation.model.MovieItem
import com.framgia.trainingclean.presentation.model.MovieItemMapper
import com.framgia.trainingclean.presentation.rx.SchedulerProvider
import com.framgia.trainingclean.presentation.ui.base.BaseViewModel

class HomeViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val movieItemMapper: MovieItemMapper
) : BaseViewModel() {

    val movie = MutableLiveData<MovieItem>()

    fun start() {

    }
}