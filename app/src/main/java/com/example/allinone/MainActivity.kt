package com.example.allinone

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//      lateinit var bottomNav : BottomNavigationView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        loadFragment(fragment_coin_flip())

        navBar.setOnItemSelectedListener{ item ->
            when(item.itemId) {
                R.id.coin_flip -> {
                    loadFragment(fragment_coin_flip())
                    Toast.makeText(this, "This is a test also", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.rng -> {
                    loadFragment(fragment_rng())
                    Toast.makeText(this,"This is a test", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.spin_the_wheel -> {
                    loadFragment(fragment_spin_the_wheel())
                    true
                }
                R.id.magic_ball -> {
                    loadFragment(fragment_magic_ball())
                    true
                }
                R.id.history -> {
                    loadFragment(fragment_history())
                    true
                }
                else -> false
            }
        }

        }

//        loadFragment(fragment_coin_flip())
//        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView
//        bottomNav.setOnNavigationItemReselectedListener {
//            when (it.itemId) {
//                R.id.coin_flip -> {
//                    loadFragment(fragment_coin_flip())
//                    return@setOnNavigationItemReselectedListener
//                }
//                R.id.rng -> {
//                    loadFragment(fragment_rng())
//                    return@setOnNavigationItemReselectedListener
//                }
//                R.id.spin_the_wheel -> {
//                    loadFragment(fragment_spin_the_wheel())
//                    return@setOnNavigationItemReselectedListener
//                }
//                R.id.magic_ball -> {
//                    loadFragment(fragment_magic_ball())
//                    return@setOnNavigationItemReselectedListener
//                }
//                R.id.history -> {
//                    loadFragment(fragment_history())
//                    return@setOnNavigationItemReselectedListener
//                }
//            }
//        }
//    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}