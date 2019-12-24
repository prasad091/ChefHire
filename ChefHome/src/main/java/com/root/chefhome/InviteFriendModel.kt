package com.root.chefhome

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.item_invite_friend)
abstract class InviteFriendModel : EpoxyModelWithHolder<InviteFriendModel.Holder>(){
    override fun bind(holder: Holder) {
        super.bind(holder)
    }
    class Holder : EpoxyHolder() {
        override fun bindView(itemView: View) {
        }

    }
}