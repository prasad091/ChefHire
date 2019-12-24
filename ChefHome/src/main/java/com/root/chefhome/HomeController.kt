package com.root.chefhome

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.root.chefhome.data.ChefList
import com.root.chefhome.data.PopularCuisinesList
import com.root.chefhome.data.ReviewChefList
import com.root.chefhome.data.SuggestChefList

class HomeController : AsyncEpoxyController() {

    var recentChefs: List<ChefList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var popularCuisines: List<PopularCuisinesList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var suggestChef: List<SuggestChefList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var reviewChef: List<ReviewChefList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    override fun buildModels() {
        headerItem {
            id("recently_active")
            title("Top Chefs")
        }
        val models = recentChefs.map {
            RecentChefActiveModel_()
                .id(it.id)
                .chef(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }
        headerItem {
            id("popular_active")
            title("Popular Cuisines")
        }
        val modelsTwo = popularCuisines.map {
            PopularChefActiveModel_()
                .id(it.id)
                .cuisines(it)
        }
        carousel {
            id("popular")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelsTwo)
        }
        headerItem {
            id("suggest_active")
            title("Suggestion for you now")
        }
        val modelsThree = suggestChef.map {
            SuggestChefActiveModel_()
                .id(it.id)
                .suggest(it)
        }
        carousel {
            id("suggest")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(modelsThree)
        }
        headerItemViewAll {
            id("review_active")
            title("Rating & Reviews")
        }

        reviewChef.forEach {
            reviewChefActive{
                id(it.id)
                review(it)
            }

        }
        inviteFriend{
            id("invite_active")
        }
        headerItem {
            id("special_active")
            title("Today's Special")
        }
    }

}