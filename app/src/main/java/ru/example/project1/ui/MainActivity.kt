package ru.example.project1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.example.project1.R
import ru.example.project1.core.navigation.Navigator
import ru.example.project1.databinding.ActivityMainBinding
import ru.example.project1.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigator()
        setFragment(MainFragment())
    }

    private fun initNavigator() {
        navigator = Navigator(supportFragmentManager, R.id.nav_host_fragment_activity_main)
    }

    fun setFragment(fragment: Fragment) {
        navigator.selectFragment(fragment)
    }
}