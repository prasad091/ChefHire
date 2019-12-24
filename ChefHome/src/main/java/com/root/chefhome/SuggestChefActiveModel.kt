package com.root.chefhome

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.chefhome.data.SuggestChefList
import de.hdodenhof.circleimageview.CircleImageView


@EpoxyModelClass(layout = R.layout.item_suggest_chef)
abstract class SuggestChefActiveModel : EpoxyModelWithHolder<SuggestChefActiveModel.Holder>(){
    @EpoxyAttribute
    lateinit var suggest: SuggestChefList

    @SuppressLint("SetTextI18n")
    override fun bind(holder: Holder) {
        super.bind(holder)
        with(suggest){
            holder.cuisinesImage.setImageResource(imageCuisine)
            holder.chefImage.setImageResource(imageChef)
            holder.cuisineName.text = nameCuisine
            holder.chefName.text = nameChef
            holder.recommend.text = "$recommend recommended"

        }
    }

    class Holder : EpoxyHolder() {
        lateinit var cuisinesImage:AppCompatImageView
        lateinit var chefImage: CircleImageView
        lateinit var cuisineName:TextView
        lateinit var chefName:TextView
        lateinit var recommend:TextView
        override fun bindView(itemView: View) {
            cuisinesImage = itemView.findViewById(R.id.cuisinesImage)
            chefImage = itemView.findViewById(R.id.chefImage)
            cuisineName = itemView.findViewById(R.id.cuisineName)
            chefName = itemView.findViewById(R.id.chefName)
            recommend = itemView.findViewById(R.id.recommend)
        }

    }
}