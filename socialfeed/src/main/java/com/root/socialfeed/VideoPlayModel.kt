package com.root.socialfeed

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.socialfeed.data.VideoItemList
import com.root.socialfeed.data.VideoPlayList

@EpoxyModelClass(layout = R.layout.layout_video_playitem)
abstract class VideoPlayModel : EpoxyModelWithHolder<VideoPlayModel.Holder>(){
    @EpoxyAttribute
    lateinit var videoPlay: VideoPlayList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(videoPlay){
            holder.imagePoster.setImageResource(imagePoster)
            holder.itemName.text = itemName
            holder.itemSubName.text = itemSubName
        }
    }
    class Holder : EpoxyHolder() {
        lateinit var imagePoster: AppCompatImageView
        lateinit var itemName: TextView
        lateinit var itemSubName: TextView
        override fun bindView(itemView: View) {
            imagePoster = itemView.findViewById(R.id.imagePoster)
            itemName = itemView.findViewById(R.id.itemName)
            itemSubName = itemView.findViewById(R.id.itemSubName)
        }

    }
}