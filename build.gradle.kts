val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.8"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-freemarker-jvm")
    implementation("io.ktor:ktor-server-host-common-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

/**
 * ktor-server-core-jvm adds Ktor's core components to our project.
 *
 * ktor-server-freemarker-jvm allows us to use the FreeMarker template engine, which we'll use to create the main page of our journal.
 *
 * ktor-server-netty-jvm adds the Netty engine to our project, allowing us to use server functionality without having to rely on an external application container.
 *
 * logback-classic provides an implementation of SLF4J, allowing us to see nicely formatted logs in a console.
 *
 * ktor-server-test-jvm and kotlin-test-junit allow us to test parts of our Ktor application without having to use the whole HTTP stack in the process.
 *
 * Configurations: application.conf and logback.xml﻿
 */
