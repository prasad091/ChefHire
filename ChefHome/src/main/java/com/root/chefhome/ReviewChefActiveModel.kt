package com.root.chefhome

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.chefhome.data.ChefList
import com.root.chefhome.data.ReviewChefList
import de.hdodenhof.circleimageview.CircleImageView

@EpoxyModelClass(layout = R.layout.item_chef_review)
abstract class ReviewChefActiveModel : EpoxyModelWithHolder<ReviewChefActiveModel.Holder>(){

    @EpoxyAttribute
    lateinit var review: ReviewChefList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(review){
            holder.image.setImageResource(image)
            holder.name.text = name
            holder.time.text = time
            holder.review.text = review
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var image:CircleImageView
        lateinit var name:TextView
        lateinit var time:TextView
        lateinit var review:TextView
        override fun bindView(itemView: View) {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.name)
            time = itemView.findViewById(R.id.time)
            review = itemView.findViewById(R.id.review)
        }

    }
}