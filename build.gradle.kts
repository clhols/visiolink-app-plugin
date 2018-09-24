plugins {
    kotlin("jvm") version "1.2.71"
    `maven-publish`
    `java-gradle-plugin`
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:3.2.0")
    implementation(kotlin("stdlib", "1.2.71"))
    implementation("org.json:json:20180130")
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