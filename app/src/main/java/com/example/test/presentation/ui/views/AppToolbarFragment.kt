package com.example.test.presentation.ui.views

import android.view.Menu
import android.view.MenuInflater

abstract class AppToolbarFragment : BaseFragment() {
    internal abstract val appToolbarTitleId: Int

    interface OnAppToolbarTitleChangeListener {
        fun onAppToolbarTitleChange(title: String)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        requireActivity().let {
            if (it is OnAppToolbarTitleChangeListener)
                it.onAppToolbarTitleChange(getString(appToolbarTitleId))
        }
    }
}