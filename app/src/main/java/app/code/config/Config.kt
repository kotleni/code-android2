package app.code.config

import app.code.removeAllUnsafe
import java.io.File

// configuration file (decoding + encoding)
class Config(private val pathToFile: String) {
    private val map = HashMap<String, Any>() // stored keys&values

    init {
        val file = File(pathToFile)
        if(file.exists()) { // is config exist
            load(file.readText()) // load this
        }
    }

    // load config by content
    private fun load(content: String) {
        val lines = content.split("\n")
        lines.forEach {
            val safeIt = it.removeAllUnsafe(allowSafeChars = true, allowSafeNumbers = true)
            if(safeIt.isNotEmpty()) { // is has content
                val spl = safeIt.split("=")
                if(spl.size > 1) { // is has equeal
                    if(spl[1][0] == '\'') // is string
                        map[spl[0]] = spl[1].replace("'", "")
                    else if(spl[1] == "false" || spl[1] == "true") // is bool
                        map[spl[0]] = spl[1] == "true"
                    else // is int
                        map[spl[0]] = spl[1].toInt()
                }
            }
        }

//        // for debug
//        println("Loaded config: $pathToFile")
//        map.keys.forEach {
//            println("$it : ${map[it]}")
//        }
    }

    // save config to file
    fun save() {
        val builder = StringBuilder()

        map.keys.forEach {  key ->
            val value = map[key]!!
            if(value is String)
                builder.append("$key = '$value'\n")
            else if(value is Boolean)
                builder.append("$key = $value\n")
            else if(value is Int)
                builder.append("$key = $value\n")
        }

        val file = File(pathToFile)
        file.writeText(builder.toString())
    }

    // update config and save
    fun commit(h: Config.() -> Unit) {
        h.invoke(this)
        save()
    }

    // get loaded string
    fun getString(key: String): String? {
        return map[key] as String?
    }

    // get loaded boolean
    fun getBoolean(key: String): Boolean? {
        return map[key] as Boolean?
    }

    // get loaded int
    fun getInt(key: String): Int? {
        return map[key] as Int?
    }

    // set config value
    fun set(key: String, value: Any) {
        map[key] = value
    }
}