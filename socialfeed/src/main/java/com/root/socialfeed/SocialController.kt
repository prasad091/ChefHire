package com.root.socialfeed

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.root.socialfeed.data.HeaderBannerList

class SocialController : AsyncEpoxyController() {
    var headerBanner: List<HeaderBannerList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        val models = headerBanner.map {
            HeaderBannerItemModel_()
                .id(it.id)
                .headerBanner(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }
    }

}