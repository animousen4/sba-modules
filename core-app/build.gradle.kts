/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */
group = "com.animousen4"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven {url = uri("https://jitpack.io")}
}


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
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")




    implementation("org.projectlombok:lombok:1.18.28")
    implementation("org.postgresql:postgresql:42.5.1")

    implementation("net.andreinc:neatchess:1.0")

    implementation("com.github.bhlangonijr:chesslib:1.3.3")


    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.testcontainers:postgresql:1.17.3")
    testImplementation("uk.org.webcompere:model-assert:1.0.0")

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
