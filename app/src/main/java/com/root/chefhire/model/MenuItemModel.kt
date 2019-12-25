package com.root.chefhire.model

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.root.chefhire.R
import com.root.chefhire.data.MenuList

@EpoxyModelClass(layout = R.layout.item_menu_chef)
abstract class MenuItemModel : EpoxyModelWithHolder<MenuItemModel.Holder>(){
    @EpoxyAttribute
    lateinit var menu: MenuList

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(menu) {
        holder.title.text = name
    }
    }
    class Holder : EpoxyHolder() {
        lateinit var title: AppCompatTextView
        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.header_title)
        }

    }
}