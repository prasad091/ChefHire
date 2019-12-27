package com.root.socialfeed

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.socialfeed.data.VideoItemList

@EpoxyModelClass(layout = R.layout.layout_video_item)
abstract class VideoItemModel : EpoxyModelWithHolder<VideoItemModel.Holder>(){
    @EpoxyAttribute
    lateinit var videoItem: VideoItemList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(videoItem){
            holder.imagePoster.setImageResource(image)
        }
    }
    class Holder : EpoxyHolder() {
        lateinit var imagePoster: AppCompatImageView
        override fun bindView(itemView: View) {
            imagePoster = itemView.findViewById(R.id.imagePoster)
        }

    }
}