package com.framgia.trainingclean.presentation.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerOnScrollListener(threshold: Int = 3) :
    RecyclerView.OnScrollListener() {

    private var mPreviousTotal: Int = 0
    private var isLoading = true
    private var mFirstVisibleItem: Int = 0
    private var mVisibleItemCount: Int = 0
    private var mTotalItemCount: Int = 0
    private var mNumberThreshold: Int = -1

    init {
        if (threshold >= 1) {
            mNumberThreshold = threshold
        } else {
            mNumberThreshold = 3
        }
    }

    override fun onScrolled(recycler: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recycler, dx, dy)
        mVisibleItemCount = recycler.childCount
        mTotalItemCount = recycler.layoutManager?.itemCount ?: 0
        if (recycler.layoutManager is LinearLayoutManager) {
            mFirstVisibleItem =
                (recycler.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        } else {
            throw RuntimeException("Error LayoutManager ")
        }

        if (isLoading) {
            stateLoading()
        }

        if (!isLoading && mTotalItemCount -
            mVisibleItemCount <= mFirstVisibleItem + mNumberThreshold
        ) {
            onLoadMore()
            isLoading = true
        }
    }

    private fun stateLoading() {
        if (mTotalItemCount > mPreviousTotal) {
            isLoading = false
            mPreviousTotal = mTotalItemCount
        }
    }

    fun resetOnLoadMore() {
        mFirstVisibleItem = 0
        mVisibleItemCount = 0
        mTotalItemCount = 0
        mPreviousTotal = 0
        isLoading = true
    }

    abstract fun onLoadMore()
}