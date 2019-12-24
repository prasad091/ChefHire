package com.root.chefhome.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.root.chefhome.BasicVersionViewModel
import com.root.chefhome.HomeController
import com.root.chefhome.R
import com.root.chefhome.data.Data
import com.root.chefhome.data.PopularCuisinesData
import com.root.chefhome.data.ReviewChefData
import com.root.chefhome.data.SuggestChefData
import kotlinx.android.synthetic.main.basic_version_fragment.*


class BasicVersionFragment : Fragment() {

    companion object {
        fun newInstance() = BasicVersionFragment()
    }

    private lateinit var viewModel: BasicVersionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.basic_version_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BasicVersionViewModel::class.java)
        val controller = HomeController()
        messagesView.setController(controller)
        controller.recentChefs = Data.recentChefs
        controller.popularCuisines = PopularCuisinesData.popularCuisinesList
        controller.suggestChef = SuggestChefData.suggestChefList
        controller.reviewChef = ReviewChefData.reviewChefList

    }

}
