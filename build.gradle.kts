plugins {
    kotlin("jvm") version "1.2.70"
    `maven-publish`
    `java-gradle-plugin`
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:3.1.4")
    implementation(kotlin("stdlib", "1.2.70"))
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