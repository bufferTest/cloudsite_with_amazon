package com.softuvo.cloudsight.core

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.pm.PackageManager
import android.content.pm.PackageInfo
import android.util.Base64
import android.util.Log
import android.view.View
import com.softuvo.cloudsight.data.ApiService
import com.softuvo.cloudsight.utils.CallProgressWheel
import com.softuvo.cloudsight.utils.CommonUtils
import io.reactivex.disposables.CompositeDisposable
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/*
 * Created by Softuvo-Network on 12/26/2017.
 */

abstract class BaseActivity : AppCompatActivity() {
    lateinit var context: Context
    val mCompositeDrawable: CompositeDisposable = CompositeDisposable()
    val repository = ApiService.Factory.createCloudSight()
    val amazonRepository = ApiService.Factory.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
//        getFbKeyHash()
    }

    abstract fun onClick(v: View);

    fun isNetworkConnected(): Boolean {
        return CommonUtils.isInternetConnection(context)
    }

    fun showProgressDialog() {
        CallProgressWheel.showLoadingDialog(context)
    }

    fun hideProgressDialog() {
        CallProgressWheel.dismissLoadingDialog()
    }

    override fun onDestroy() {
        hideProgressDialog()
        mCompositeDrawable.clear()
        super.onDestroy()
    }

    fun getFbKeyHash() {
        val info: PackageInfo
        try {
            info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val something = String(Base64.encode(md.digest(), 0))
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something)
            }
        } catch (e1: PackageManager.NameNotFoundException) {
            Log.e("name not found", e1.toString())
        } catch (e: NoSuchAlgorithmException) {
            Log.e("no such an algorithm", e.toString())
        } catch (e: Exception) {
            Log.e("exception", e.toString())
        }

    }

}