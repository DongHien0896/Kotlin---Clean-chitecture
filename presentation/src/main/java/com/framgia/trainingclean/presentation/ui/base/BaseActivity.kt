package com.framgia.trainingclean.presentation.ui.base

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity<viewModel : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: ViewModel

    abstract fun initComponent(saveInstantState: Bundle?)

    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initComponent(savedInstanceState)
    }

    fun addFragment(fragment: Fragment, container: Int, TAG: String, addToBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            add(container, fragment)
            if (addToBackStack) {
                addToBackStack(TAG)
            }
            setTransition(FragmentTransaction.TRANSIT_NONE)
            commit()
        }
    }

    fun replaceFragment(fragment: Fragment, container: Int, TAG: String?, addToBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(container, fragment)
            if (addToBackStack) {
                addToBackStack(TAG)
            }
            setTransition(FragmentTransaction.TRANSIT_NONE)
            commit()
        }
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}