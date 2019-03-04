package com.framgia.trainingclean.data.remote.response

import com.framgia.trainingclean.data.model.MovieEntity
import com.google.gson.annotations.SerializedName

open class MovieResponse(
    @SerializedName("total_pages")
    var mTotalPages: Int? = null,

    @SerializedName("results")
    var mListMovie: ArrayList<MovieEntity>? = null
)