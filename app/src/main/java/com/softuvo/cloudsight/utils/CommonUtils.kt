package com.softuvo.cloudsight.utils;

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.net.ConnectivityManager
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import okhttp3.MediaType
import okhttp3.RequestBody
import java.net.NetworkInterface
import java.util.*

class CommonUtils {
    companion object {
        var PLACE_AUTOCOMPLETE_REQUEST_CODE = 1

        fun getImeiNumber(context: Context): String {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
        }

        fun getRequestBody(data: String): RequestBody {
            return RequestBody.create(MediaType.parse("text/plain"), data)
        }

        /**
         * Get IP address from first non-localhost interface
         * @param ipv4  true=return ipv4, false=return ipv6
         * @return  address or empty string
         */
        fun getIPAddress(useIPv4: Boolean): String {
            try {
                val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
                for (intf in interfaces) {
                    val addrs = Collections.list(intf.getInetAddresses());
                    for (addr in addrs) {
                        if (!addr.isLoopbackAddress()) {
                            val sAddr = addr.getHostAddress();
                            val isIPv4 = sAddr.indexOf(':') < 0;
                            if (useIPv4) {
                                if (isIPv4)
                                    return sAddr;
                            } else {
                                if (!isIPv4) {
                                    val delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                    return if (delim < 0) (sAddr.toUpperCase()) else (sAddr.substring(0, delim).toUpperCase())
                                }
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return "";
        }

        fun showSnackbarMessage(context: Context, message: String, color: Int) {
            val snackbar = Snackbar.make((context as Activity).findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
            snackbar.view.setBackgroundColor(ContextCompat.getColor(context, color))
            snackbar.show()
        }


        /**
         * Display Toast Message
         */
        fun showToastMessageShort(context: Context, message: String) {
            Toast.makeText(context.applicationContext, message,
                    Toast.LENGTH_SHORT).show()
        }


        /**
         * @param context
         * @return Returns true if there is network connectivity
         */
        fun isInternetConnection(context: Context): Boolean {
            val cm = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo

            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }


        fun hideKeyboard(applicationContext: Context, mView: View?) {
            if (mView != null) {
                val imm = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(mView.windowToken, 0)
            }
        }

        fun getRealPathFromURI(context: Context, contentUri: Uri?): String {
            var cursor: Cursor? = null
            try {
                val proj = arrayOf(MediaStore.Images.Media.DATA)
                cursor = context.contentResolver.query(contentUri, proj, null, null, null)
                val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                cursor.moveToFirst()
                return cursor.getString(column_index)
            } finally {
                if (cursor != null) {
                    cursor.close()
                }
            }
        }


        fun getLocale(context: Context): String {
            return context.resources.getConfiguration().locale.getCountry().toString().toLowerCase()
        }

    }
}