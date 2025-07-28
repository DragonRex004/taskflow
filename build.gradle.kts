plugins {
    id("java")
    id("maven-publish")
}

group = "de.dragonrex.taskflow"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}
