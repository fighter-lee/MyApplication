package com.abupdate.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyCustomTaskWithParams extends DefaultTask {
    @TaskAction
    void output() {
        println "Sender is ${project.myArgs.sender},\nmessage: ${project.myArgs.message}"
        println "name is ${project.myArgs.myArgs1.name},\nphone: ${project.myArgs.myArgs1.phone}"
    }
}