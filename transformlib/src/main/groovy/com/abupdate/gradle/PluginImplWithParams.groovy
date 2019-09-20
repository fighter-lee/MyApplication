package com.abupdate.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginParams {
    def message = "From MyCustomPluginExtention"
    def sender = "MyCustomPluin"
}

class PluginParams1 {
    def name = "adbcefdggjgj"
    def phone = "121345666"
}

public class PluginImplWithParams implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.extensions.create('myArgs', PluginParams)
        project.myArgs.extensions.create('myArgs1', PluginParams1)
        def task = project.task('customTaskWithParams', type: MyCustomTaskWithParams)

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