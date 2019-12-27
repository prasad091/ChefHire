package com.root.socialfeed

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.socialfeed.data.VideoGroupList
import com.root.socialfeed.data.VideoItemList

@EpoxyModelClass(layout = R.layout.item_video_group)
abstract class VideoGroupModel : EpoxyModelWithHolder<VideoGroupModel.Holder>(){
    @EpoxyAttribute
    lateinit var videoGroup: VideoGroupList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(videoGroup){
            holder.imagePoster.setImageResource(imagePoster)
            holder.itemName.text = itemName
            holder.videoCount.text = videoCount
        }
    }
    class Holder : EpoxyHolder(){
        lateinit var imagePoster: AppCompatImageView
        lateinit var videoCount: TextView
        lateinit var itemName: TextView
        override fun bindView(itemView: View) {
            imagePoster = itemView.findViewById(R.id.imagePoster)
            videoCount = itemView.findViewById(R.id.videoCount)
            itemName = itemView.findViewById(R.id.itemName)
        }

    }
}