package com.root.socialfeed.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.root.socialfeed.BasicViewModel
import com.root.socialfeed.R
import com.root.socialfeed.SocialController
import com.root.socialfeed.data.HeaderBannerData
import kotlinx.android.synthetic.main.basic_fragment.*


class BasicFragment : Fragment() {

    companion object {
        fun newInstance() = BasicFragment()
    }

    private lateinit var viewModel: BasicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.basic_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BasicViewModel::class.java)
        val controller = SocialController()
        messagesView.setController(controller)
        controller.headerBanner = HeaderBannerData.headerBanner

    }

}