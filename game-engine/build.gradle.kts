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
    implementation("org.projectlombok:lombok:1.18.28")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    annotationProcessor("org.projectlombok:lombok")
    compileOnly ("org.projectlombok:lombok")

    implementation(project(":utilities"))
}

application {
    // Define the main class for the application.
    mainClass.set("com.animousen4.gameengine.GameEngineApplication")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
