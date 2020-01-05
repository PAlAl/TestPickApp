package com.example.test.presentation.ui.views.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test.presentation.ui.global.dialogs.ProgressDialog
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment() {
    abstract val layoutRes: Int

    private val PROGRESS_TAG: String = "block_progress"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutRes, container, false)

    open fun onBackPressed() {}

    protected fun showProgressDialog(progress: Boolean) {
        if (!isAdded) return

        val fragment = childFragmentManager.findFragmentByTag(PROGRESS_TAG)
        if (fragment != null && !progress) {
            (fragment as ProgressDialog).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && progress) {
            ProgressDialog()
                    .show(childFragmentManager, PROGRESS_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }
}