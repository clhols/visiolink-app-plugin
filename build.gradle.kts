plugins {
    kotlin("jvm") version "1.3.41"
    `maven-publish`
    `java-gradle-plugin`
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:3.4.2")
    implementation(kotlin("stdlib-jdk7", "1.3.41"))
    implementation("org.json:json:20190722")
}

repositories {
    jcenter()
    google()
}

publishing {
    publications {
        create("appPlugin", MavenPublication::class.java) {
            groupId = "com.visiolink"
            artifactId = "app"
            version = "1.4"

            from(components["java"])
        }
    }
}