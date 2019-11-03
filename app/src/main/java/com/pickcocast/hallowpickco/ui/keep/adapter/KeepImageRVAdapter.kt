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
import com.pickcocast.hallowpickco.model.GetKeepImageData



class KeepImageRVAdapter(private val ctx: Context, var dataList: List<String>) :
    RecyclerView.Adapter<KeepImageRVAdapter.KeepImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeepImageViewHolder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_keep, parent, false)

        return KeepImageViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: KeepImageViewHolder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position])
            .transforms(CenterCrop(), RoundedCorners(dp2px(ctx, 38)))
            .into(holder.imgKeepImage)
    }

    inner class KeepImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgKeepImage: ImageView = itemView.findViewById(R.id.iv_rv_item_keep_image)
    }

    fun dp2px(context: Context, dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}