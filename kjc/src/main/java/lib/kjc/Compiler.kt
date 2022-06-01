package lib.kjc

import org.eclipse.jdt.internal.compiler.batch.Main
import java.io.PrintWriter
import java.io.StringWriter

class JavaCompiler {
    // in future
//    fun compileProject(projectDirPath: String) {
//        val _out = StringWriter()
//        val _err = StringWriter()
//        val compiler = Main(
//            PrintWriter(_out),
//            PrintWriter(_err),
//            false,
//            null,
//            null)
//        val args = mutableListOf<String>()
//        args.addAll(listOf(
//            // "-extdirs", libsFolder,
//            // "-bootclasspat", androidJar
//            "-1.7",
//            "-proc:none",
//            "-target", "1.7",
//            "-d $projectDirPath/build/classes/",
//            "$projectDirPath/src/"
//        ))
//        compiler.compile(args.toTypedArray())
//    }
}