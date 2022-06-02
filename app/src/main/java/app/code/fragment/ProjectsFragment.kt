package app.code.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import app.code.R
import app.code.adapter.ProjectsListAdapter
import app.code.databinding.FragmentProjectsBinding
import app.code.getAppComponent
import app.code.model.ProjectsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class ProjectsFragment: Fragment() {
    private lateinit var viewBinding: FragmentProjectsBinding
    private lateinit var projectsListAdapter: ProjectsListAdapter
    private val model: ProjectsViewModel by viewModels { getAppComponent().getProjectsViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentProjectsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // setup recycler view
        projectsListAdapter = ProjectsListAdapter()
        viewBinding.recycler.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recycler.adapter = projectsListAdapter

        // load data
        model.getProjectsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                projectsListAdapter.update(it)
            }

        viewBinding.create.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.fade_out
                )
                replace(R.id.container, CreateProjectFragment())
            }
        }
    }
}