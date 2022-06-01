package app.code.model

import androidx.lifecycle.ViewModel
import app.code.item.NewProject
import app.code.repo.ProjectsRepository
import javax.inject.Inject

class CreateProjectViewModel @Inject constructor(val projectsRepo: ProjectsRepository): ViewModel() {
    fun createProject(name: String, author: String, type: String) {
        projectsRepo.createProject(NewProject(
            name = name,
            author = author,
            type = type
        ))
    }
}