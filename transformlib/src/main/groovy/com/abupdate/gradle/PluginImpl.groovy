package com.abupdate.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginImpl implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('testPlugin', type: MyCustomTask)
    }
}