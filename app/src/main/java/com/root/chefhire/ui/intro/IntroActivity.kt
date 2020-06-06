package com.root.chefhire.ui.intro


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
import com.root.chefhire.R
import com.root.chefhire.adapter.IntroViewPagerAdapter
import com.root.chefhire.model.ScreenItemModel
import com.root.chefhire.ui.login.LoginActivity



class IntroActivity : AppCompatActivity() {
    private var screenPager: ViewPager? = null
    private var introViewPagerAdapter: IntroViewPagerAdapter? = null
    private var tabIndicator: TabLayout? = null
    private var btnNext: Button? = null
    private var position = 0
    private var btnGetStarted: Button? = null
    private var btnAnim: Animation? = null
    private var tvSkip: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // make the activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // when this activity is about to be launch we need to check if its openened before or not
        if (restorePrefData()) {
            val mainActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
        setContentView(R.layout.activity_intro)

        btnNext = findViewById(R.id.btn_next)
        btnGetStarted = findViewById(R.id.btn_get_started)
        tabIndicator = findViewById(R.id.tab_indicator)
        btnAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.button_animation)
        tvSkip = findViewById(R.id.tv_skip)
        // fill list screen
        val mList: MutableList<ScreenItemModel> = ArrayList()
        mList.add(
            ScreenItemModel(
                getString(R.string.hire_chef),
                getString(R.string.sampleText)
            )
        )
        mList.add(
            ScreenItemModel(
                getString(R.string.cooking),
                getString(R.string.sampleText)
            )
        )
        mList.add(
            ScreenItemModel(
                getString(R.string.payment),
                getString(R.string.sampleText)
            )
        )
        // setup viewpager
        screenPager = findViewById(R.id.screen_viewpager)
        introViewPagerAdapter = IntroViewPagerAdapter(this, mList)
        screenPager!!.adapter = introViewPagerAdapter

        // setup tablayout with viewpager
        tabIndicator!!.setupWithViewPager(screenPager)
        // next button click Listner
        btnNext!!.setOnClickListener {
            position = screenPager!!.currentItem
            if (position < mList.size) {
                position++
                screenPager!!.currentItem = position
            }
            if (position == mList.size - 1) { // when we rech to the last screen
                loaddLastScreen()
            }
        }

        // tablayout add change listener
        tabIndicator!!.addOnTabSelectedListener(object : BaseOnTabSelectedListener<TabLayout.Tab?> {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == mList.size - 1) {
                    loaddLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        // Get Started button click listener
        btnGetStarted!!.setOnClickListener{
            val mainActivity =
                Intent(applicationContext, LoginActivity::class.java)
            startActivity(mainActivity)
            // also we need to save a boolean value to storage so next time when the user run the app
// we could know that he is already checked the intro screen activity
// i'm going to use shared preferences to that process
            savePrefsData()
            finish()
        }
        // skip button click listener
        tvSkip!!.setOnClickListener{
            screenPager!!.currentItem = mList.size
        }
    }

    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences(
            getString(R.string.pref),
            Context.MODE_PRIVATE
        )
        return pref.getBoolean(getString(R.string.isOpened), false)
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences(
            getString(R.string.pref),
            Context.MODE_PRIVATE
        )
        val editor = pref.edit()
        editor.putBoolean(getString(R.string.isOpened), true)
        editor.apply()
    }

    // show the GETSTARTED Button and hide the indicator and the next button
    private fun loaddLastScreen() {
        btnNext!!.visibility = View.INVISIBLE
        btnGetStarted!!.visibility = View.VISIBLE
        tvSkip!!.visibility = View.INVISIBLE
        tabIndicator!!.visibility = View.INVISIBLE
        btnGetStarted!!.animation = btnAnim
    }
}
