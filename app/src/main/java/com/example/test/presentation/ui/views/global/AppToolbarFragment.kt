package com.example.test.presentation.ui.views.global

import android.view.Menu
import android.view.MenuInflater
import com.example.test.presentation.ui.global.toolbar.AppToolbarConfig

abstract class AppToolbarFragment : BaseFragment() {
    internal abstract val appToolbarTitleId: Int
    internal open val isAppToolbarHomeAsUpEnabled: Boolean = false

    interface OnAppToolbarConfigChangeListener {
        fun onAppToolbarTitleChange(config: AppToolbarConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        requireActivity().let {
            if (it is OnAppToolbarConfigChangeListener)
                it.onAppToolbarTitleChange(AppToolbarConfig(getString(appToolbarTitleId), isAppToolbarHomeAsUpEnabled))
        }
    }
}