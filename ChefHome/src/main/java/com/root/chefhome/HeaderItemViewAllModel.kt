package com.root.chefhome

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.view_holder_header_viewall)
abstract class HeaderItemViewAllModel : EpoxyModelWithHolder<HeaderItemViewAllModel.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.title.text = title
        holder.viewAll.text = "View All"
    }

    class Holder : EpoxyHolder() {

        lateinit var title: AppCompatTextView
        lateinit var viewAll: AppCompatTextView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.header_title)
            viewAll = itemView.findViewById(R.id.header_viewAll)
        }
    }
}