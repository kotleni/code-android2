package app.code.repo

import android.content.SharedPreferences
import app.code.item.*
import java.io.File
import javax.inject.Inject

class ProjectsRepository @Inject constructor() {
    // get all projects list
    fun getAllProjects(): List<Project> {
        // fixme: hardcoded path
        val dir = File("/data/data/app.code/files/projects/")
        if(!dir.exists()) dir.mkdirs()

        return arrayListOf<Project>().apply {
            dir.list()?.forEach {
                val proj = Project.loadByPath("${dir.path}/$it/")
                add(proj)
            }
        }
    }

    fun createProject(proj: Project) {
        // fixme: hardcoded path
        val dir = File("/data/data/app.code/files/projects/${proj.name}/")
        dir.mkdir()
    }
}