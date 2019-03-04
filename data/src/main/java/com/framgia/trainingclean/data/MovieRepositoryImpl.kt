package com.framgia.trainingclean.data

import com.framgia.trainingclean.data.model.MovieEntityMapper
import com.framgia.trainingclean.data.remote.api.MovieApi
import com.framgia.trainingclean.domain.model.Movie
import com.framgia.trainingclean.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl constructor(
    private val movieApi: MovieApi,
    private val movieEntityMapper: MovieEntityMapper
) : MovieRepository {
    override fun getMoviePopular(page: Int): Single<List<Movie>> {
        return movieApi.getMoviePopular(page)
            .map { response -> response.mListMovie?.map { movieEntityMapper.mapToDomain(it) } }
    }
}