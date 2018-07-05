plugins {
    kotlin("jvm") version "1.2.51"
    `maven-publish`
    `java-gradle-plugin`
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:3.1.3")
    implementation(kotlin("stdlib", "1.2.51"))
    implementation("org.json:json:20171018")
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