

plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.animousen4.java-application-conventions")
}


dependencies {
	implementation ("com.squareup.okhttp3:mockwebserver")
	implementation ("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation ("org.springframework.boot:spring-boot-starter-web")

	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("org.springframework.security:spring-security-test")
}

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
	outputs.upToDateWhen { false }
}
