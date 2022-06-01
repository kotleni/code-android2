package app.code.di

import android.content.Context
import app.code.model.CreateProjectViewModelFactory
import app.code.model.ProjectsViewModel
import app.code.model.ProjectsViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelsModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun getProjectsViewModelFactory(): ProjectsViewModelFactory
    fun getCreateProjectViewModelFactory(): CreateProjectViewModelFactory

    fun inject(q: ProjectsViewModel)
}