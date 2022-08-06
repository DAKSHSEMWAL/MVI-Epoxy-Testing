package com.zopsmart.mobile.mvitesting

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(80))
        Glide
            .with(view)
            .load(R.mipmap.profile)
            .fitCenter()
            .apply(requestOptions)
            .dontAnimate().into(view)
    } else {
        Log.e("No Image Found", "Oh, Something went wrong!")
    }
}
