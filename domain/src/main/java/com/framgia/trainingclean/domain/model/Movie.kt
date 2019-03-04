package com.framgia.trainingclean.domain.model

import com.framgia.trainingclean.domain.model.base.Model

data class Movie(
    val idMovie: Int,
    val name: String? = null,
    val voteCount: Int? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val overview: String? = null,
    val releaseDate: Long? = null
) : Model()