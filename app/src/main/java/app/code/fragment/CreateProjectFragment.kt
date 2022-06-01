package app.code.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import app.code.R
import app.code.databinding.FragmentCreateprojectBinding
import app.code.databinding.FragmentProjectsBinding
import app.code.getAppComponent
import app.code.model.CreateProjectViewModel
import app.code.model.ProjectsViewModel

class CreateProjectFragment: Fragment() {
    private lateinit var viewBinding: FragmentCreateprojectBinding
    private val model: CreateProjectViewModel by viewModels { getAppComponent().getCreateProjectViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentCreateprojectBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.cancel.setOnClickListener {
            popBack()
        }

        viewBinding.create.setOnClickListener {
            model.createProject(
                viewBinding.name.text.toString(),
                viewBinding.author.text.toString(),
                "java" // tempolary static
            )
            popBack()
        }
    }

    // to back fragment
    private fun popBack() {
        requireActivity().supportFragmentManager.commit {
            setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.fade_out
            )
            replace(R.id.container, ProjectsFragment())
        }
    }
}