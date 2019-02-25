package com.framgia.trainingclean.domain.usecase.movie

import com.framgia.trainingclean.domain.ConstantDomain
import com.framgia.trainingclean.domain.model.Movie
import com.framgia.trainingclean.domain.repository.MovieRepository
import com.framgia.trainingclean.domain.usecase.UseCase
import io.reactivex.Single

open class GetMovieUseCase constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieUseCase.Params?, Single<Movie>>() {

    override fun createObservable(param: Params?): Single<Movie> {
        param?.apply {
            movieRepository.getMoviePopular(param.page)
        }
        return Single.error { Throwable(ConstantDomain.PARAM_ERROR) }
    }

    override fun onCleared() {
    }


    data class Params(val page: Int)
}