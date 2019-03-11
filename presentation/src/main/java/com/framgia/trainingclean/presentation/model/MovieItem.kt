package com.framgia.trainingclean.presentation.model

import android.content.res.Resources
import com.framgia.trainingclean.R
import com.framgia.trainingclean.data.utils.toTimeLong
import com.framgia.trainingclean.data.utils.toTimeString
import com.framgia.trainingclean.domain.model.Movie
import com.framgia.trainingclean.presentation.model.base.ItemMapper
import com.framgia.trainingclean.presentation.model.base.ModelItem

data class MovieItem(
    val idMovie: Int,
    val name: String? = null,
    val voteCount: Int? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null
) : ModelItem()


class MovieItemMapper(
    private val resource: Resources
) : ItemMapper<Movie, MovieItem> {
    override fun mapToPresentation(model: Movie) = MovieItem(
        idMovie = model.idMovie,
        name = model.name,
        voteCount = model.voteCount,
        title = model.title,
        posterPath = model.posterPath,
        backdropPath = model.backdropPath,
        overview = model.overview,
        releaseDate = model.releaseDate?.toTimeString(resource.getString(R.string.format_yyyy_MM_dd))
    )

    override fun mapToDomain(modelItem: MovieItem) = Movie(
        idMovie = modelItem.idMovie,
        name = modelItem.name,
        voteCount = modelItem.voteCount,
        title = modelItem.title,
        posterPath = modelItem.posterPath,
        backdropPath = modelItem.backdropPath,
        overview = modelItem.overview,
        releaseDate = modelItem.releaseDate?.toTimeLong(resource.getString(R.string.format_yyyy_MM_dd))
    )
}