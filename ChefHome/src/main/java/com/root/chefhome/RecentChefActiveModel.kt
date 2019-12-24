package com.root.chefhome

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.chefhome.data.ChefList


@EpoxyModelClass(layout = R.layout.item_recent_chef)
abstract class RecentChefActiveModel : EpoxyModelWithHolder<RecentChefActiveModel.Holder>() {

    @EpoxyAttribute
    lateinit var chef: ChefList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(chef) {
            holder.profileName.text = name
            holder.lastSeen.text = amount
            holder.profileImage.setImageResource(image)
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var profileName: AppCompatTextView
        lateinit var lastSeen: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.recently_added_profile_image)
            profileName = itemView.findViewById(R.id.recently_added_profile_name)
            lastSeen = itemView.findViewById(R.id.recently_added_last_seen)
        }
    }
}