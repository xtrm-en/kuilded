plugins {
    kotlin("jvm") version "1.5.30"
    java
}

group = "me.xtrm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.java-websocket:Java-WebSocket:1.5.1")
}