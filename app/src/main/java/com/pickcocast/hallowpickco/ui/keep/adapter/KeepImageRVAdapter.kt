package com.pickcocast.hallowpickco.ui.keep.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.pickcocast.hallowpickco.R
import com.pickcocast.hallowpickco.ui.keep.data.KeepImageData

class KeepImageRVAdapter(private val ctx: Context, var dataList: List<KeepImageData>) :
    RecyclerView.Adapter<KeepImageRVAdapter.KeepImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeepImageViewHolder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_keep, parent, false)

        return KeepImageViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: KeepImageViewHolder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].keep_img)
            .transforms(CenterCrop(), RoundedCorners(38))
            .into(holder.imgKeepImage)
    }

    inner class KeepImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgKeepImage: ImageView = itemView.findViewById(R.id.iv_rv_item_keep_image)
    }
}