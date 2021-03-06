package com.root.chefhome.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider

import com.root.chefhome.HomeViewModel
import com.root.chefhome.HomeController
import com.root.chefhome.R
import com.root.chefhome.data.Data
import com.root.chefhome.data.PopularCuisinesData
import com.root.chefhome.data.ReviewChefData
import com.root.chefhome.data.SuggestChefData
import kotlinx.android.synthetic.main.basic_version_fragment.*


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    public var activityContext: FragmentActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.basic_version_fragment, container, false)
    }

    @SuppressLint("RestrictedApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val controller = HomeController()
        messagesView.setController(controller)
        controller.recentChefs = Data.recentChefs
        controller.popularCuisines = PopularCuisinesData.popularCuisinesList
        controller.suggestChef = SuggestChefData.suggestChefList
        controller.reviewChef = ReviewChefData.reviewChefList
      /*  var actionBar: ActionBar? = (activity as AppCompatActivity).supportActionBar
        messagesView.addOnScrollListener(object : RecyclerView.OnScrollListener() {


            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    if (actionBar!!.isShowing) {
                        actionBar.hide()
                    }
                    println("Scrolled Downwards")
                } else if (dy < 0) {
                    println("Scrolled Upwards")
                    if (!actionBar!!.isShowing) {
                        actionBar.show()
                    }
                } else {
                    println("No Vertical Scrolled")
                }
            }
        })*/


    }
}
