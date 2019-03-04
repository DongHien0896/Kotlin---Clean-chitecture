package com.framgia.trainingclean.data.model.base

import com.framgia.trainingclean.domain.model.base.Model


interface EntityMapper<M : Model, ME : ModelEntity> {

    fun mapToDomain(modelEntity: ME): M

    fun mapToEntity(model: M): ME
}