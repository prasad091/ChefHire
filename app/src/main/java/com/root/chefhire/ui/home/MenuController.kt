package com.root.chefhire.ui.home

import com.airbnb.epoxy.AsyncEpoxyController
import com.root.chefhire.data.FavOrderMenuList
import com.root.chefhire.data.MenuList
import com.root.chefhire.model.favOrderMenu
import com.root.chefhire.model.headerItem
import com.root.chefhire.model.menuItem

class MenuController : AsyncEpoxyController() {
    var menus: List<MenuList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var favOrders: List<FavOrderMenuList> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    override fun buildModels() {
        menus.forEach {
            menuItem {
                id(it.id)
                menu(it)
            }

        }
        headerItem {
            id("popular_active")
            title("Chef")
        }
        favOrders.forEach {
            if(it.id <= 4) {
                favOrderMenu {
                    id(it.id)
                    favOrder(it)
                }
            }
        }
        headerItem {
            id("about_active")
            title("About")
        }
        favOrders.forEach {
            if(it.id > 4) {
                favOrderMenu {
                    id(it.id)
                    favOrder(it)
                }
            }
        }
        headerItem {
            id("logout_active")
            title("Logout")
        }
        headerItem {
            id("setting_active")
            title("Settings")
        }
    }

}