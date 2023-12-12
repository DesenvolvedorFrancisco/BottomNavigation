package dev.francisco.bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.francisco.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // Fragment inicial e o direcionamento para cada fragment especifico
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_home -> replaceFragment(HomeFragment())
                R.id.item_account -> replaceFragment(AccountFragment())
                R.id.item_search -> replaceFragment(SearchFragment())
                R.id.item_logout -> finish()
                else -> {
                    replaceFragment(HomeFragment())
                }
            }

            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}