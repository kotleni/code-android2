package app.code.item

import java.io.File

class Project(
    val name: String
) {
    companion object {
        // load project by path
        fun loadByPath(path: String): Project {
            val file = File(path)
            val proj = Project(file.name)
            return proj
        }
    }
}