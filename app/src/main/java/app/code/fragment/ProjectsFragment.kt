package app.code.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import app.code.R
import app.code.adapter.ProjectsListAdapter
import app.code.databinding.FragmentProjectsBinding
import app.code.getAppComponent
import app.code.item.Project
import app.code.model.ProjectsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog


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

        // setup model
        model.projectsList.observe(this, projectsListAdapter.projectsListObserver)
        model.updateProjectsList()

        viewBinding.create.setOnClickListener {
            showCreateProjectDialog()
        }
    }

    private fun showCreateProjectDialog() {
        val dialog = BottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme)
        // dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = LayoutInflater.from(requireContext())
            .inflate(R.layout.dialog_createproject, null, false)
        dialog.setContentView(view)
        dialog.show()
    }
}