plugins {
    kotlin("jvm") version "1.5.30"
    `java-library`
}

group = "me.xtrm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api("com.fasterxml.jackson.core:jackson-databind:2.10.0")
    api("org.java-websocket:Java-WebSocket:1.5.1")
}