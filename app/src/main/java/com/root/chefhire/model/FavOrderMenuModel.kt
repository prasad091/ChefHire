package com.root.chefhire.model

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.chefhire.R
import com.root.chefhire.data.FavOrderMenuList

@EpoxyModelClass(layout = R.layout.item_menu_sub)
abstract class FavOrderMenuModel : EpoxyModelWithHolder<FavOrderMenuModel.Holder>(){
    @EpoxyAttribute
    lateinit var favOrder: FavOrderMenuList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(favOrder) {
            holder.title.text = name
            holder.image.setImageResource(image)

        }
    }
    class Holder : EpoxyHolder() {
        lateinit var title: AppCompatTextView
        lateinit var image: AppCompatImageView
        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.header_title)
            image = itemView.findViewById(R.id.image)
        }

    }
}