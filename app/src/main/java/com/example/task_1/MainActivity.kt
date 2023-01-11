package com.example.task_1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val statisticsFragment = StatisticsFragment()
        val fileFragment = FileFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(statisticsFragment)

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener{
            when (it.itemId) {
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_statistics -> setCurrentFragment(statisticsFragment)
                R.id.nav_file -> setCurrentFragment(fileFragment)
                R.id.nav_profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.flFragment,fragment)
        commit()

    }
}