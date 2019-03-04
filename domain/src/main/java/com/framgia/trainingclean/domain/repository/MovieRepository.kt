package com.framgia.trainingclean.domain.repository

import com.framgia.trainingclean.domain.model.Movie
import com.framgia.trainingclean.domain.repository.base.Repository
import io.reactivex.Single

interface MovieRepository : Repository {
    fun getMoviePopular(page: Int): Single<List<Movie>>
}