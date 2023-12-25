/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */
group = "com.animousen4"
version = "0.0.1-SNAPSHOT"

plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.animousen4.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.0")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

    implementation("org.projectlombok:lombok:1.18.28")
    implementation("org.postgresql:postgresql:42.5.1")

    implementation("net.andreinc:neatchess:1.0")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")

    annotationProcessor("org.projectlombok:lombok")
    compileOnly ("org.projectlombok:lombok")

    implementation(project(":utilities"))
}
configurations.forEach { it.exclude("org.springframework.boot", "spring-boot-starter-logging") }
application {
    // Define the main class for the application.
    mainClass.set("com.animousen4.gameengine.GameEngineApplication")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
