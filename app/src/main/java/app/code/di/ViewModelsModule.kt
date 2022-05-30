package app.code.di

import app.code.model.ProjectsViewModelFactory
import app.code.repo.ProjectsRepository
import dagger.Module

@Module
abstract class ViewModelsModule {
    fun provideProjectsRepository(): ProjectsRepository {
        return ProjectsRepository()
    }
}