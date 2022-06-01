package app.code.item

import app.code.config.Config
import java.io.File

class Project(
    val dirPath: String
) {
    val config = Config("$dirPath/project.cfg")

    val name: String = config.getString("name")!!
    val author: String = config.getString("author")!!
    val type: String = config.getString("type")!!
    val configVersion: Int = config.getInt("config_version")!!

    fun saveAll() {
        config.save()
    }

    companion object {
        // load project by path
        fun loadByPath(path: String): Project {
            val file = File(path)
            val proj = Project(path)
            return proj
        }
    }
}