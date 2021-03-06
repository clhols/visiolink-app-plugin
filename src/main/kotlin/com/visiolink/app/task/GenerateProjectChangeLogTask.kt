package com.visiolink.app.task

import com.visiolink.app.execute
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * Generates Project change log since last tag
 */
open class GenerateProjectChangeLogTask : VisiolinkGroupTask() {

    init {
        description = "Generates Project change log since last tag"
    }

    @TaskAction
    fun action() {
        val tag = "git describe --tags --abbrev=0".execute(File(".")).trim()

        val log = "git log $tag..HEAD --oneline".execute(File("."))
        //println("Got log: $log")

        project.file("src/main/assets").mkdirs()
        project.file("src/main/assets/git.log").writeText(log)
    }
}