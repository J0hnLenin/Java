plugins {
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.serialization") version "2.1.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.8.1")
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("MainKt")
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}