package com.framgia.trainingclean.presentation.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.framgia.trainingclean.presentation.utils.EndlessRecyclerOnScrollListener

abstract class BaseLoadMoreRefreshViewModel<Item> : BaseViewModel() {
    val isRefreshing = MutableLiveData<Boolean>().apply { value = false }
    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        if (isLoading.value == true || isRefreshing.value == true) return@OnRefreshListener
        isRefreshing.value = true
        refreshData()
    }

    val isLoadMore = MutableLiveData<Boolean>().apply { value = false }
    var currentPage = MutableLiveData<Int>().apply { value = 0 }
    var isLastPage = MutableLiveData<Boolean>().apply { value = false }

    val onScrollListener = object : EndlessRecyclerOnScrollListener(getLoadMoreThreshold()) {
        override fun onLoadMore() {
            if (isLoading.value == true
                || isRefreshing.value == true
                || isLoadMore.value == true
                || isLastPage.value == true
            ) return
            isLoadMore.value = true
            loadMore()
        }
    }
    val listItems = MutableLiveData<ArrayList<Item>>()

    abstract fun loadData(page: Int)

    private fun isFirst() = currentPage.value == 0
            && (listItems.value == null || listItems.value?.size == 0)

    fun firstLoad() {
        if (isFirst()) {
            if (isLoading.value == false)
                isLoading.value = true
            loadData(1)
        }
    }

    fun refreshData() {
        loadData(1)
    }

    fun loadMore() {
        loadData(currentPage.value?.plus(1) ?: 1)
        println(currentPage)
    }

    open fun getLoadMoreThreshold() = 3

    open fun getNumberItemPerPage() = 20

    private fun resetLoadMore() {
        onScrollListener.resetOnLoadMore()
        isLastPage.value = false
    }

    open fun onLoadSuccess(page: Int, items: List<Item>?) {
        currentPage.value = page
        if (currentPage.value == 1) listItems.value?.clear()
        if (isRefreshing.value == true) resetLoadMore()

        val newList = listItems.value ?: ArrayList()
        newList.addAll(items ?: listOf())
        listItems.value = newList

        isLastPage.value = items?.size ?: 0 < getNumberItemPerPage()
        isLoading.value = false
        isRefreshing.value = false
        isLoadMore.value = false
    }

    override fun onLoadFail(throwable: Throwable) {
        super.onLoadFail(throwable)
        isRefreshing.value = false
        isLoadMore.value = false
    }
}