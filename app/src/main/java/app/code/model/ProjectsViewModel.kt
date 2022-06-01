package app.code.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.code.item.Project
import app.code.repo.ProjectsRepository
import javax.inject.Inject

class ProjectsViewModel @Inject constructor(val projectsRepo: ProjectsRepository):  ViewModel() {

    // private
    private val _projectsList: MutableLiveData<List<Project>> by lazy { MutableLiveData<List<Project>>() }

    // public
    val projectsList: LiveData<List<Project>> = _projectsList

    // update projects list
    fun updateProjectsList() {
        _projectsList.value = projectsRepo.getAllProjects()
    }
}