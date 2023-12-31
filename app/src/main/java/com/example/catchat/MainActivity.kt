package com.example.catchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        // getting the reference to the navigation controller from the navogation host
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // getting a reference to the drawerlayout
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        // this builds a configuration linking the toolbar to the navigation graph
        val builder = AppBarConfiguration.Builder(navController.graph)
        // the toolbar will display a drawer icon with which to open the drawer
        builder.setOpenableLayout(drawer)
        val appBarConfiguration = builder.build()
        // applying the configuration to the toolbar
        toolbar.setupWithNavController(navController, appBarConfiguration)
        val naView = findViewById<NavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(naView, navController)

        // implementing bottom navigation bar and linking the bar to the navigation controller

    }

    // Add any menu items to the to the toolbar(the hellp menu item)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Navigate to a destination when an item is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
}