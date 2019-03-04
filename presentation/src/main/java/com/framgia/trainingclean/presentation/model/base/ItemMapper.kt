package com.framgia.trainingclean.presentation.model.base

import com.framgia.trainingclean.domain.model.base.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): MI

    fun mapToDomain(modelItem: MI): M
}