package com.framgia.trainingclean.data.remote.mock

import com.framgia.trainingclean.data.remote.api.MovieApi
import com.framgia.trainingclean.data.remote.response.MovieResponse
import io.reactivex.Single

class MockMovieApi : MovieApi {

    override fun getMoviePopular(pageNumber: Int): Single<MovieResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}