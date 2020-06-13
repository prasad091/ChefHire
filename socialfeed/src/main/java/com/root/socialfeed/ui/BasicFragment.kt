package com.root.socialfeed.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.root.socialfeed.BasicViewModel
import com.root.socialfeed.R
import com.root.socialfeed.SocialController
import com.root.socialfeed.data.HeaderBannerData
import com.root.socialfeed.data.VideoGroupData
import com.root.socialfeed.data.VideoItemData
import com.root.socialfeed.data.VideoPlayData
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
        viewModel = ViewModelProvider(this).get(BasicViewModel::class.java)
        val controller = SocialController()
        messagesView.setController(controller)
        controller.headerBanner = HeaderBannerData.headerBanner
        controller.videoItem = VideoItemData.videoItem
        controller.videoPlay = VideoPlayData.videoPlayList
        controller.videoGroup = VideoGroupData.videoGroup



    }

}
