package com.anoirdev.test.presentation.base

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.anoirdev.test.presentation.event.view.CustomSnackBar

abstract class BaseActivity : AppCompatActivity() {

    private var customSnackBar: CustomSnackBar? = null
    private var baseViewModel: BaseViewModel? = null

    protected fun registerBaseObservers(viewModel: ViewModel) {
        if (viewModel is BaseViewModel) {
            registerSnackBar(viewModel)
            registerReceiver(viewModel)
        }
    }

    private fun registerSnackBar(viewModel: BaseViewModel) {
        viewModel.snackBarMessage.observe(this) { showSnackBar(it) }
    }

    private fun registerReceiver(viewModel: BaseViewModel) {
        baseViewModel = viewModel
    }

    private fun showSnackBar(message: String) {
        if (!isFinishing) {
            val root = window.decorView.findViewById<ViewGroup>(android.R.id.content)
            customSnackBar = CustomSnackBar.make(root, CustomSnackBar.DURATION).apply {
                setText(message)
                show()
            }
        }
    }

    fun hideSnackBar() {
        if (!isFinishing) {
            customSnackBar?.dismiss()
            customSnackBar = null
        }
    }

}