package ru.example.project1.core.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ru.example.project1.ui.MainActivity

abstract class BaseFragment(@LayoutRes resId: Int) : Fragment(resId) {

    protected abstract val vm: BaseViewModel

    abstract val binding: ViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListeners()
    }

    protected open fun initView() = Unit

    protected open fun initListeners() = Unit

    protected fun safeNavigate(activity: Activity, fragment: Fragment) {
        (activity as? MainActivity)?.setFragment(fragment)
    }

    protected fun <B : ViewBinding> setupBinding(create: (View) -> B) = create(requireView())
}