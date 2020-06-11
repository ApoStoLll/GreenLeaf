package com.missclick.greenleaf.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.missclick.greenleaf.R
import com.missclick.greenleaf.fragments.ProfileFragment
import com.missclick.greenleaf.interfaces.ProfileView
import com.missclick.greenleaf.viewstates.ProfileViewState

class MainActivity : AppCompatActivity(), ProfileView {

    override fun render(state: ProfileViewState) {
        when(state){
            is ProfileViewState.ProfileLoadingFirstState -> {
                //TODO loading screen
            }
        }

    }

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                //startMenu(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

//    fun startMenu(num : Int){
//        val transaction = supportFragmentManager.beginTransaction()
//        when(num){
//
//            1-> transaction.replace(R.id.fragment_holder, ProfileFragment())
//        }
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
}
