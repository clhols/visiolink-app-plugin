plugins {
    kotlin("jvm") version "1.2.0"
    `maven-publish`
    `java-gradle-plugin`
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:3.0.1")
    implementation(kotlin("stdlib", "1.2.0"))
    implementation("org.json:json:20160810")
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
            version = "1.2"

            from(components["java"])
        }
    }
}