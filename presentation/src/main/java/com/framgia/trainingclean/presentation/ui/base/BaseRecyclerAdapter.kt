package com.framgia.trainingclean.presentation.ui.base

import android.databinding.ViewDataBinding
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<T>(callBack: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<ViewDataBinding>>(
        AsyncDifferConfig.Builder<T>(callBack)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int? = 0): ViewDataBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewDataBinding> {
        return BaseViewHolder(createBinding(parent = parent, viewType = viewType))
    }

    protected abstract fun bind(binding: ViewDataBinding, item: T)

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    override fun submitList(list: MutableList<T>?) {
        val newList = ArrayList<T>()
        if (list != null) {
            newList.addAll(list)
        }
        super.submitList(newList)
    }
}