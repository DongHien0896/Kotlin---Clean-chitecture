package com.framgia.trainingclean.data.remote.api

import com.framgia.trainingclean.data.remote.response.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    fun getMoviePopular(@Query("page") pageNumber: Int): Single<MovieResponse>
}