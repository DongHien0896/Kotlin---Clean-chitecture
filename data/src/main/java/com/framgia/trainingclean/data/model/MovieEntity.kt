package com.framgia.trainingclean.data.model

import android.arch.persistence.room.Entity
import com.framgia.trainingclean.data.ConstantData
import com.framgia.trainingclean.data.model.base.EntityMapper
import com.framgia.trainingclean.data.model.base.ModelEntity
import com.framgia.trainingclean.data.utils.toTimeLong
import com.framgia.trainingclean.data.utils.toTimeString
import com.framgia.trainingclean.domain.model.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie", primaryKeys = ["id"])
data class MovieEntity(
    @SerializedName("id") val idMovie: Int,
    @SerializedName("name") val name: String? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("original_title") val title: String? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    var favorited: Boolean? = false
) : ModelEntity()

class MovieEntityMapper : EntityMapper<Movie, MovieEntity> {

    override fun mapToDomain(entity: MovieEntity) = Movie(
        idMovie = entity.idMovie,
        name = entity.name,
        voteCount = entity.voteCount,
        title = entity.title,
        posterPath = entity.posterPath,
        backdropPath = entity.backdropPath,
        overview = entity.overview,
        releaseDate = entity.releaseDate?.toTimeLong(ConstantData.FORMAT_YYYY_MM_DD)
    )

    override fun mapToEntity(model: Movie) = MovieEntity(
        idMovie = model.idMovie,
        name = model.name,
        voteCount = model.voteCount,
        title = model.title,
        posterPath = model.posterPath,
        backdropPath = model.backdropPath,
        overview = model.overview,
        releaseDate = model.releaseDate?.toTimeString(ConstantData.FORMAT_YYYY_MM_DD)
    )
}
