package com.app.mymall.Activities.BuildYourListing

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import com.app.mymall.Activities.StoreDetailActivity.StoreDetailActivity
import com.app.mymall.Adapters.CartGridViewAdapter
import com.app.mymall.Adapters.UploadStoreImagesAdapter
import com.app.mymall.R
import java.io.IOException

class BuildYourListingActivity : AppCompatActivity(), View.OnClickListener {
    var activity: Activity? = null
    var img_selectimage: ImageView? = null
    var img_companylogo: ImageView? = null
    var SELECT_PICTURE = 200
    private var bitmap: Bitmap? = null
    private val pickImage = 100
    private var imageUri: Uri? = null
    lateinit var gridview: GridView
    lateinit var img_back: ImageView
    lateinit var btn_user: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_your_listing)
        inits()
        listeners()

        val uploadStoreImagesAdapter = UploadStoreImagesAdapter(this)

        gridview.adapter = uploadStoreImagesAdapter

    }


    private fun inits() {
        img_selectimage = findViewById(R.id.img_selectimage)
        img_companylogo = findViewById(R.id.img_companylogo)
        gridview = findViewById(R.id.gridview)
        img_back = findViewById(R.id.img_back)
        btn_user = findViewById(R.id.btn_user)

    }

    private fun listeners() {
        img_selectimage?.setOnClickListener(this)
        img_back?.setOnClickListener(this)
        btn_user?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == img_selectimage) {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        } else if (v == img_back) {
            finish()
        } else if (v == btn_user) {
            var intent = Intent(this, StoreDetailActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            img_companylogo?.setImageURI(imageUri)
        }
    }


}