package com.softuvo.cloudsight.utils

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.view.WindowManager
import com.softuvo.cloudsight.R


object CallProgressWheel {

    private var progressDialog: ProgressDialog? = null

    private val isDialogShowing: Boolean
        get() {
            try {
                return progressDialog != null && progressDialog!!.isShowing
            } catch (e: Exception) {
                return false
            }

        }

    /*
      Displays custom loading dialog
     */
    fun showLoadingDialog(context: Context?) {
        try {
            if (isDialogShowing) {
                dismissLoadingDialog()
            }

            if (context is Activity) {
                if (context.isFinishing) {
                    return
                }
            }

            progressDialog = ProgressDialog(context, android.R.style.Theme_Translucent_NoTitleBar)
            progressDialog!!.show()
            val layoutParams = progressDialog!!.window!!.attributes
            layoutParams.dimAmount = 0.5f
            progressDialog!!.window!!.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            progressDialog!!.setCancelable(false)
            progressDialog!!.setContentView(R.layout.layout_progress)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun dismissLoadingDialog() {
        try {
            if (progressDialog != null) {
                progressDialog!!.dismiss()
                progressDialog = null
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
