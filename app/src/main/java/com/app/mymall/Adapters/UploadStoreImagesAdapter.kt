package com.app.mymall.Adapters

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.CartModelClasses

class UploadStoreImagesAdapter(private val activity: Activity):BaseAdapter() {

    var PICK_IMAGE_MULTIPLE = 1
    lateinit var imagePath: String
    var imagesPathList: MutableList<String> = arrayListOf()

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(activity, R.layout.uploadimageslist, null)
        var img_selectimage : ImageView = view.findViewById(R.id.img_selectimage)
        var img_companylogo : ImageView = view.findViewById(R.id.img_companylogo)
        img_selectimage.setOnClickListener {
            if (Build.VERSION.SDK_INT < 19) {
                var intent = Intent()
                intent.type = "image/*"
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                intent.action = Intent.ACTION_GET_CONTENT
                activity.startActivityForResult(
                    Intent.createChooser(intent, "Select Picture")
                    , PICK_IMAGE_MULTIPLE
                )
            } else {
                var intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "image/*"
                activity.startActivityForResult(intent, PICK_IMAGE_MULTIPLE);
            }

        }
        return view
    }

}