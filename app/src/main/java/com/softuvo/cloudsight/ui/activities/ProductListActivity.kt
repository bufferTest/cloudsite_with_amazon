package com.softuvo.cloudsight.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import com.softuvo.cloudsight.R
import com.softuvo.cloudsight.core.BaseActivity

import com.softuvo.cloudsight.utils.SignedRequestsHelper

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.softuvo.cloudsight.xmltojson.XmlToJson
import android.content.res.AssetManager
import org.json.JSONObject
import com.google.gson.Gson
import com.google.gson.JsonObject


import com.softuvo.cloudsight.model.ResponsePojo
import org.json.JSONArray


class ProductListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        getItems()
    }

    fun getItems() {
        try {



            val params = HashMap<String, String>();
//
            params.put("Service", "AWSECommerceService");
            params.put("Operation", "ItemSearch");
//        params.put("AWSAccessKeyId", "AKIAJF52UGPDWDQBQ33Q");
            params.put("AssociateTag", "telcron04-20");
            params.put("SearchIndex", "All");
            params.put("Keywords", "iphone");
            params.put("ResponseGroup", "Images,ItemAttributes,Offers");
            val mSignedRequestsHelper = SignedRequestsHelper()
            val url = mSignedRequestsHelper.sign(params)
            Log.e("==", url)
            mCompositeDrawable.add(
                    amazonRepository.getProductResults(url)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ result ->
                                try {
                                    val xmlToJson = XmlToJson.Builder(result).build()
                                    val jsonObject = xmlToJson.toJson()
                                    val ItemSearchResponse=jsonObject?.get("ItemSearchResponse") as JSONObject
                                    val Items=ItemSearchResponse.get("Items") as JSONObject
                                    val Item=Items.get("Item") as JSONArray
                                    for (i in 0..(Item.length() - 1)) {
                                        val item = Item.getJSONObject(i)
                                        val ItemAttributes= item.get("ItemAttributes") as JSONObject
//                                        val ListPrice=ItemAttributes.get("ListPrice") as JSONObject

                                        Log.e("===",ItemAttributes.get("Title").toString())
                                    }
//                                    val topic = Gson().fromJson(Gson().toJson(jsonObject), ResponsePojo::class.java)

                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }, { error ->
                                error.printStackTrace()
                            })
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onClick(v: View) {

    }
}