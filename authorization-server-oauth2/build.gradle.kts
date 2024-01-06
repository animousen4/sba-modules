group = "com.animousen4"
version = "0.0.1-SNAPSHOT"

plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.animousen4.java-application-conventions")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	// https://mvnrepository.com/artifact/org.springframework.security/spring-security-oauth2-authorization-server
	implementation("org.springframework.security:spring-security-oauth2-authorization-server")

	implementation("com.squareup.okhttp3:mockwebserver")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

	testImplementation("net.sourceforge.htmlunit:htmlunit")
}

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
	outputs.upToDateWhen { false }
}
