package com.root.socialfeed

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.root.socialfeed.data.HeaderBannerList


@EpoxyModelClass(layout = R.layout.layout_header_banner)
abstract class HeaderBannerItemModel : EpoxyModelWithHolder<HeaderBannerItemModel.Holder>(){

    @EpoxyAttribute
    lateinit var headerBanner: HeaderBannerList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(headerBanner){
            holder.imagePoster.setImageResource(headerImage)
            holder.cuisinesName.text = cuisineName
            holder.watches.text = "$numberOfWatch Watches"
        }
    }
    class Holder : EpoxyHolder() {
        lateinit var imagePoster: AppCompatImageView
        lateinit var cuisinesName: TextView
        lateinit var watches: TextView
        lateinit var playButton: FloatingActionButton
        override fun bindView(itemView: View) {
            imagePoster = itemView.findViewById(R.id.imagePoster)
            cuisinesName = itemView.findViewById(R.id.cuisinesName)
            watches = itemView.findViewById(R.id.watches)
            playButton = itemView.findViewById(R.id.playButton)

        }

    }
}