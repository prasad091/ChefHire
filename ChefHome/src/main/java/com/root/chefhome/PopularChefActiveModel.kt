package com.root.chefhome

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.chefhome.data.PopularCuisinesList

@EpoxyModelClass(layout = R.layout.item_popular_cuisines)
abstract class PopularChefActiveModel : EpoxyModelWithHolder<PopularChefActiveModel.Holder>() {
    @EpoxyAttribute
    lateinit var cuisines: PopularCuisinesList
    override fun bind(holder: Holder) {
        super.bind(holder)
        with(cuisines){
            holder.cuisineName.text = name
            holder.cuisineImage.setImageResource(image)
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var cuisineImage: ImageView
        lateinit var cuisineName: AppCompatTextView
        override fun bindView(itemView: View) {
            cuisineImage = itemView.findViewById(R.id.cuisinesImage)
            cuisineName = itemView.findViewById(R.id.nameOfCuisines)
        }

    }
}