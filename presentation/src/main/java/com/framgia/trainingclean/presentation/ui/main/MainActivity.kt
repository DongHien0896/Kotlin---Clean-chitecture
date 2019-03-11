package com.framgia.trainingclean.presentation.ui.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import com.framgia.trainingclean.R
import com.framgia.trainingclean.presentation.ConstantPresentation
import com.framgia.trainingclean.presentation.ui.base.BaseActivity
import com.framgia.trainingclean.presentation.ui.favorite.FavoriteFragment
import com.framgia.trainingclean.presentation.ui.home.HomeFragment
import com.framgia.trainingclean.presentation.utils.checkNetworkConnection
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: ViewModel by viewModel<MainViewModel>()

    override fun getLayout(): Int = R.layout.activity_main

    private val fragmentHome =
        supportFragmentManager.findFragmentByTag(ConstantPresentation.TAG_HOME_FRAGMENT)
            ?: HomeFragment.newInstance()

    override fun initComponent(saveInstantState: Bundle?) {
        if (checkNetworkConnection(Context.CONNECTIVITY_SERVICE).not()) {
            showInformationDialog()
        }
        if (saveInstantState == null) {
            viewModel.apply {}
            addFragment(
                fragmentHome,
                R.id.frame_container,
                ConstantPresentation.TAG_HOME_FRAGMENT,
                false
            )
        }
        setEvenBottomNavigation()
    }

    private fun setEvenBottomNavigation() {
        val fragmentFavorite =
            supportFragmentManager.findFragmentByTag(ConstantPresentation.TAG_FAVORITE_FRAGMENT)
                ?: FavoriteFragment.newInstance()
        navigation_bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    navigation_bottom.menu.getItem(1).isChecked = false
                    it.isChecked = true
                    replaceFragment(
                        fragmentHome,
                        R.id.frame_container,
                        ConstantPresentation.TAG_HOME_FRAGMENT,
                        false
                    )
                }
                R.id.navigation_favorite -> {
                    navigation_bottom.menu.getItem(0).isChecked = false
                    it.isChecked = true
                    replaceFragment(
                        fragmentFavorite,
                        R.id.frame_container,
                        ConstantPresentation.TAG_FAVORITE_FRAGMENT,
                        false
                    )
                }
            }
            false
        }
    }

    private fun showInformationDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.title_oops))
            .setMessage(getString(R.string.msg_no_network))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.title_try_again)) { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

}
