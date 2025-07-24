plugins {
    id("java")
    id("maven-publish")
}

group = "de.dragonrex.taskflow"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {

}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}
