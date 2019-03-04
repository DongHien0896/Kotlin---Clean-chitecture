package com.framgia.trainingclean.presentation.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {

    abstract val viewModel: ViewModel

    abstract val layoutRes: Int

    private lateinit var viewBinding: ViewBinding

    abstract fun initComponent(viewBinding: ViewBinding)

    internal fun replaceFragment(
        fragment: Fragment,
        container: Int,
        TAG: String?,
        addToBackStack: Boolean
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(container, fragment)
            if (addToBackStack) {
                addToBackStack(TAG)
            }
            setTransition(FragmentTransaction.TRANSIT_NONE)
            commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
//            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner

            root.isClickable = true
            executePendingBindings()
        }
        lifecycle.addObserver(viewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initComponent(viewBinding)
    }

    open fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    open fun onBackPress() {}
}