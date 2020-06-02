package com.root.chefhire.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.root.chefhire.R
import com.root.chefhire.data.FavOrderMenuData
import com.root.chefhire.data.MenuData


class HomeActivity : AppCompatActivity() {
    lateinit var toolbar:Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        val navView: BottomNavigationView = this.findViewById(R.id.nav_view)
        drawerLayout =  findViewById(R.id.drawer_layout)
        navigationView =  findViewById(R.id.navigationView)
        var menuRecyclerView:EpoxyRecyclerView = navigationView.findViewById(R.id.menuRecyclerView)
        val controller = MenuController()
        menuRecyclerView.setController(controller)
        controller.menus = MenuData.menuItemAll
        controller.favOrders = FavOrderMenuData.favOrderMenu
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_chefcollection, R.id.navigation_premium,R.id.navigation_social,R.id.navigation_event
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    fun dataLoad(view:View){

    }
}
