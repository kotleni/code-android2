package app.code.model

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import app.code.item.NewProject
import app.code.item.Project
import app.code.repo.ProjectsRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class CreateProjectViewModel @Inject constructor(val projectsRepo: ProjectsRepository): ViewModel() {
    fun createProject(name: String, author: String, type: String): Observable<Project> {
        if(name.isNotEmpty() && author.isNotEmpty() && type.isNotEmpty()) {
            return Observable.just(
                projectsRepo.createProject(NewProject(
                    name = name,
                    author = author,
                    type = type
                ))
            )
        } else {
            return Observable.error(Exception("Invalid input data"))
        }
    }
}