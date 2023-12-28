package ru.example.project1.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Navigator(
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {

    fun selectFragment(fragment: Fragment) {
        val currentFragment =
            fragmentManager.fragments.firstOrNull { it.isVisible && it.tag != null }

        val tag = fragment::class.java.simpleName
        val newFragment = fragmentManager.findFragmentByTag(tag)

        if (currentFragment != null && newFragment != null && currentFragment === newFragment)
            return

        val transaction = fragmentManager.beginTransaction()
        if (newFragment == null) {
            transaction.add(containerId, fragment, tag)
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        if (newFragment != null) {
            transaction.show(newFragment)
        }
        transaction.commitNow()
    }
}