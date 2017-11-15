package com.visiolink.app.task

import com.visiolink.app.execute

/**
 * Task to tag project with version code
 */
open class TagProjectTask : VisiolinkGroupTask() {

    init {
        description = "Tag project in Git with version code"
    }

    @org.gradle.api.tasks.TaskAction
    fun action() {

        getAndroidBasePlugin()
                ?: throw org.gradle.api.GradleException("You must apply the Android plugin or the Android library plugin before using the visiolink plugin")

        val android = project.extensions.getByName("android") as com.android.build.gradle.AppExtension

        val versionCodes = android.applicationVariants
                .filter { it.buildType.name != "release" }
                .map { it.productFlavors[0].versionCode }
                .toSet()

        if (versionCodes.size != 1) {
            throw org.gradle.api.GradleException("Flavors must have the same version code. Please use getVersionCodeTimestamp()")
        }

        val versionCode = versionCodes.first()

        val tagResult = "git tag $versionCode".execute()
        if (tagResult.trim().isNotEmpty())
            throw org.gradle.api.GradleException("Error tagging project with $versionCode: $tagResult")

        val pushResult = "git push origin $versionCode".execute()
        if (pushResult.trim().isNotEmpty())
            throw org.gradle.api.GradleException("Error pushing tag: $pushResult")
    }

    fun getAndroidBasePlugin(): com.android.build.gradle.BasePlugin? {
        val plugin = project.plugins.findPlugin("com.android.application") ?:
                project.plugins.findPlugin("com.android.library")

        return plugin as com.android.build.gradle.BasePlugin
    }
}