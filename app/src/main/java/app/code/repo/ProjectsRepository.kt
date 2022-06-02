package app.code.repo

import android.content.SharedPreferences
import app.code.config.Config
import app.code.item.*
import io.reactivex.rxjava3.core.Observable
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

    // fixme: hardcoded path
    // create new project
    fun createProject(proj: NewProject): Project {
        // make dirs and files
        File("/data/data/app.code/files/projects/${proj.name}/")
            .mkdirs() // make project dir
        File("/data/data/app.code/files/projects/${proj.name}/build/")
            .mkdirs() // make build dir
        File("/data/data/app.code/files/projects/${proj.name}/src/")
            .mkdirs() // make source dir
        File("/data/data/app.code/files/projects/${proj.name}/src/Main.java")
            .writeText("class Main {}")

        // make config
        Config("/data/data/app.code/files/projects/${proj.name}/project.cfg")
            .commit {
                set("name", proj.name)
                set("author", proj.author)
                set("type", proj.type)
                set("config_version", proj.configVersion)
            }

        return Project(dirPath = "/data/data/app.code/files/projects/${proj.name}/")
    }
}