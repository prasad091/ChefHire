package com.root.chefhire.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.root.chefhire.R
import com.root.chefhire.model.ScreenItemModel


class IntroViewPagerAdapter(
    mContext: Context,
    mListScreen: List<ScreenItemModel>
) :
    PagerAdapter() {
    var mContext: Context = mContext
    var mListScreen: List<ScreenItemModel> = mListScreen
    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val inflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen: View = inflater.inflate(R.layout.layout_screen, null)

        val title: TextView = layoutScreen.findViewById(R.id.intro_title)
        val description: TextView = layoutScreen.findViewById(R.id.intro_description)
        title.text = mListScreen[position].title
        description.text = mListScreen[position].description
        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun isViewFromObject(@NonNull view: View, @NonNull o: Any): Boolean {
        return view === o
    }

    override fun destroyItem(@NonNull container: ViewGroup, position: Int, @NonNull `object`: Any) {
        container.removeView(`object` as View)
    }

}
