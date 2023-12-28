package ru.example.project1.ui.search

import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.project1.R
import ru.example.project1.core.ui.BaseFragment
import ru.example.project1.databinding.FragmentSearchBinding
import ru.example.project1.ui.main.MainFragment

class SearchFragment : BaseFragment<Unit>(R.layout.fragment_search) {

    override val binding: FragmentSearchBinding
        get() = setupBinding(FragmentSearchBinding::bind)

    override val vm: SearchViewModel by viewModel()

    override fun initListeners() {
        binding.btn.setOnClickListener {
            safeNavigate(requireActivity(), MainFragment())
        }
    }

    override fun renderState(state: Unit) = Unit

}