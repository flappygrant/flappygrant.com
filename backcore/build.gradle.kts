plugins {
    `java-library`
    id("com.gradleup.shadow") version "9.6.1"
}

repositories {
    mavenCentral()
    maven("https://mvn.flappygrant.com")
}

dependencies {
    compileOnly("com.pghserver:pghserver-api:9")
    implementation("com.google.code.gson:gson:2.14.0")
}

tasks.jar.get().archiveClassifier.set("raw")
tasks.shadowJar.get().archiveClassifier.set("")