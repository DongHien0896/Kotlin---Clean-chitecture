package com.framgia.trainingclean.domain.model

import com.framgia.trainingclean.domain.model.base.Model

data class Movie(
    val idMovie: Int? = null,
    val voteCount: Int? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val overview: String? = null,
    val releaseDate: Long? = null
) : Model()