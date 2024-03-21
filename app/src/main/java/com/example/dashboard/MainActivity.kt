package com.example.dashboard

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show the back arrow
        supportActionBar?.setDisplayShowHomeEnabled(true)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Close the drawer when back button is pressed
        return true

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show the hamburger icon

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home-> {
                    // Handle navigation item 1 click
                    true
                }
                R.id.nav_account -> {
                    // Handle navigation item 2 click
                    true
                }
                // Add more cases as needed
                else -> false
            }
        }
    }
}
