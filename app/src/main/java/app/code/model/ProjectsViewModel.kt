package app.code.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import app.code.item.Project
import app.code.repo.ProjectsRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ProjectsViewModel @Inject constructor(val projectsRepo: ProjectsRepository):  ViewModel() {
    fun getProjectsList(): Observable<List<Project>> {
        return Observable.just(projectsRepo.getAllProjects())
    }
}