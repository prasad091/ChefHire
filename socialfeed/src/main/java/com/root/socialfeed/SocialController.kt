package com.root.socialfeed

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.root.socialfeed.data.HeaderBannerList
import com.root.socialfeed.data.VideoGroupList
import com.root.socialfeed.data.VideoItemList
import com.root.socialfeed.data.VideoPlayList

class SocialController : AsyncEpoxyController() {
    var headerBanner: List<HeaderBannerList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var videoItem: List<VideoItemList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var videoPlay: List<VideoPlayList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var videoGroup: List<VideoGroupList> = emptyList()
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
            id("header")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }

        header{
            id("recently_active")
            title("RECENTLY ADDED")
        }
        val modelTwo = videoItem.map {
            VideoItemModel_()
                .id(it.id)
                .videoItem(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelTwo)
        }

        header{
            id("spicy_active")
            title("SPICY INDIAN")
        }
        val modelThree = videoItem.map {
            VideoItemModel_()
                .id(it.id)
                .videoItem(it)
        }
        carousel {
            id("spicy")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelThree)
        }
        header{
            id("most_active")
            title("MOST POPULAR")
        }
        val modelFour = videoPlay.map {
            VideoPlayModel_()
                .id(it.id)
                .videoPlay(it)
        }
        carousel {
            id("mostPopular")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelFour)
        }
        header{
            id("japan_active")
            title("AWESOME JAPANESE CUISINES")
        }
        val modelFive = videoPlay.map {
            VideoPlayModel_()
                .id(it.id)
                .videoPlay(it)
        }
        carousel {
            id("japanPopular")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelFive)
        }
        header{
            id("video_collection")
            title("CHEF COLLECTION")
        }
        val modelSix = videoGroup.map {
            VideoGroupModel_()
                .id(it.id)
                .videoGroup(it)
        }
        carousel {
            id("videoCollection")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelSix)
        }

        header{
            id("dubai_active")
            title("AWESOME ARAB CUISINES")
        }
        val modelSeven = videoPlay.map {
            VideoPlayModel_()
                .id(it.id)
                .videoPlay(it)
        }
        carousel {
            id("arabPopular")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelSeven)
        }
        header{
            id("italy_active")
            title("AWESOME ITALY CUISINES")
        }
        val modelEight = videoPlay.map {
            VideoPlayModel_()
                .id(it.id)
                .videoPlay(it)
        }
        carousel {
            id("italyPopular")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelEight)
        }
    }

}