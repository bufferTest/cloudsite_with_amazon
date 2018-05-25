package com.softuvo.cloudsight.ui.activities

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.view.View
import android.widget.Toast
import com.softuvo.cloudsight.R
import com.softuvo.cloudsight.core.BaseActivity
import com.softuvo.cloudsight.data.ApiService
import com.softuvo.cloudsight.model.CloudSightResponsePojo
import com.softuvo.cloudsight.utils.PermissionUtils
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.HashMap

class MainActivity : BaseActivity() {
    override fun onClick(v: View) {

    }

    private val IMAGE_RESPONSE_URL = "http://api.cloudsight.ai/image_responses/"
    val MIME_TYPE_IMAGE = "image/*"
    private val GALLERY_PERMISSIONS_REQUEST = 0
    private val GALLERY_IMAGE_REQUEST = 1
    private val CAMERA_PERMISSIONS_REQUEST = 2
    private val CAMERA_IMAGE_REQUEST = 3
    private val REQUEST_TIME_OUT = 60 * 1000
    private val FILE_NAME = "temp.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            image_details.text = ""
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this)
//            val builder = AlertDialog.Builder(this@MainActivity)
//            builder
//                    .setMessage(R.string.dialog_select_prompt)
//                    .setPositiveButton(R.string.dialog_select_gallery, { dialog, which ->
//                        startGalleryChooser()
//                    })
//                    .setNegativeButton(R.string.dialog_select_camera, { dialog, which ->
//                        startCamera() })
//            builder.create().show()
        }
    }

    fun startGalleryChooser() {
        if (PermissionUtils.requestPermission(this, GALLERY_PERMISSIONS_REQUEST, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select a photo"),
                    GALLERY_IMAGE_REQUEST)
        }
    }

    fun startCamera() {
        if (PermissionUtils.requestPermission(
                        this,
                        CAMERA_PERMISSIONS_REQUEST,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)) {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val photoUri = FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", getCameraFile())
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivityForResult(intent, CAMERA_IMAGE_REQUEST)
        }
    }

    fun getCameraFile(): File {
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File(dir, FILE_NAME)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == RESULT_OK) {
                val resultUri = result.uri
                uploadImageUri(resultUri)
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }
//        if (requestCode == GALLERY_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
//            uploadImageUri(data.data)
//        } else if (requestCode == CAMERA_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
//
//            val photoUri = FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", getCameraFile())
//            uploadImageUri(photoUri)
//        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_PERMISSIONS_REQUEST -> if (PermissionUtils.permissionGranted(requestCode, CAMERA_PERMISSIONS_REQUEST, grantResults)) {
                startCamera()
            }
            GALLERY_PERMISSIONS_REQUEST -> if (PermissionUtils.permissionGranted(requestCode, GALLERY_PERMISSIONS_REQUEST, grantResults)) {
                startGalleryChooser()
            }
        }
    }

    private fun uploadImageUri(resultUri: Uri) {
        showProgressDialog()
        main_image.setImageURI(resultUri)
        val multipart = prepareFilePart(ApiService.Factory.IMAGE, resultUri)

        val uploadmap = HashMap<String, RequestBody>()

        uploadmap[ApiService.Factory.LOCALE] = RequestBody.create(MediaType.parse("text/plain"), "en_US")


        mCompositeDrawable.add(repository.uploadImage(ApiService.Factory.AUTHORIZATIONKEY, uploadmap, multipart)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::uploadImage, this::handleError))
    }

    private fun uploadImage(CloudSightResponsePojo: CloudSightResponsePojo) {
//        if (CloudSightResponsePojo.status.equals("completed")) {
        getImageResult(CloudSightResponsePojo.token)


//        } else {
//            hideProgressDialog()
//            image_details.setText(resources.getString(R.string.err_some_unknown))
//        }

    }

//    private inner class FetchTask(internal var token: String) : AsyncTask<Void, Void, Void>() {
//
//        override fun doInBackground(vararg voids: Void): Void? {
//            getImageResponse(token)
//            return null
//        }
//
////        override fun onPostExecute(aVoid: Void) {
////            super.onPostExecute(aVoid)
////            mViewHolder.hideProgressDialog()
////        }
//    }
//
//
//    private fun getImageResponse(pToken: String) {
//        val flag = booleanArrayOf(false)
//        val syncHttpClient = SyncHttpClient()
//        syncHttpClient.setResponseTimeout(REQUEST_TIME_OUT)
//        syncHttpClient.addHeader(getString(R.string.auth_header), "CloudSight " + getString(R.string.api_key))
//        while (!flag[0]) {
//            syncHttpClient.get(IMAGE_RESPONSE_URL + pToken, object : JsonHttpResponseHandler() {
//              override  fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
//                    super.onSuccess(statusCode, headers, response)
//                    try {
//                        if (response.getString("status") != "not completed") {
//                            flag[0] = true
//                            val status = response.getString("status")
//                            if (status != "completed") {
//                                image_details.setText(resources.getString(R.string.err_some_unknown))
//                            } else {
//                                image_details.setText(response.getString("name"))
//
//                            }
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//
//                }
//
//               override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, errorResponse: JSONObject) {
//                    super.onFailure(statusCode, headers, throwable, errorResponse)
//                }
//            })
//        }
//    }

    private fun getImageResult(token: String) {
        mCompositeDrawable.add(repository.imageResult(ApiService.Factory.AUTHORIZATIONKEY, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::ImageResult, this::handleError))

    }

    private fun ImageResult(CloudSightResponsePojo: CloudSightResponsePojo) {
        hideProgressDialog()
        if (CloudSightResponsePojo.status.equals("completed")) {
            image_details.setText(CloudSightResponsePojo.getName())

        } else {
            image_details.setText(resources.getString(R.string.err_some_unknown))
        }
    }

    private fun handleError(error: Throwable) {
        hideProgressDialog()
        Toast.makeText(this, "Error " + error.localizedMessage, Toast.LENGTH_LONG).show()
    }

    fun prepareFilePart(partName: String, fileUri: Uri): MultipartBody.Part {
        val file = File(fileUri.path)
        return MultipartBody.Part.createFormData(partName, file.name, RequestBody.create(MediaType.parse(MIME_TYPE_IMAGE), file))
    }


}
