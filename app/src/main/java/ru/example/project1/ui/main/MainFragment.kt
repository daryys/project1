package ru.example.project1.ui.main

import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.project1.R
import ru.example.project1.core.ui.BaseFragment
import ru.example.project1.databinding.FragmentMainBinding
import ru.example.project1.ui.folder_list.FolderListFragment
import ru.example.project1.ui.search.SearchFragment

class MainFragment : BaseFragment<Unit>(R.layout.fragment_main) {

    override val vm: MainViewModel by viewModel()

    override val binding: FragmentMainBinding
        get() = setupBinding(FragmentMainBinding::bind)

    override fun initListeners() {
        binding.btn.setOnClickListener {
            safeNavigate(requireActivity(), FolderListFragment())
        }
    }

    override fun renderState(state: Unit) = Unit

}