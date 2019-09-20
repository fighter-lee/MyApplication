package com.abupdate.packer

import org.gradle.api.Plugin
import org.gradle.api.Project

public class AutoPacker implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def task = project.task('customTaskWithParams')

        task.doFirst {
            println("-----------------doFirst-------------------")
            def autoPackerFile = project.getProject().file("auto-packer.properties")
            if (!autoPackerFile.canRead()) {
                println("file which named auto-packer.properties was not found")
                return
            }
            def autoPackerProperties = new Properties()
            autoPackerProperties.load(new FileInputStream(autoPackerFile))

            if (!autoPackerProperties.containsKey("OUTPUT_DIR")) {
                println("file which named keystore.properties miss some entries:OUTPUT_DIR")
                return
            }

            project.getProject().task("assembleDebug").shouldRunAfter(task)
        }

        task.doLast {
            println("-----------------doLast-------------------")
        }

    }
}