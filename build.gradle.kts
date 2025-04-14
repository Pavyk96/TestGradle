plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.pavyk96"
version = "0.0.1-SNAPSHOT"
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")

	implementation("javax.annotation:javax.annotation-api:1.3.2")
	// Для Jakarta EE (Spring Boot 3+ использует jakarta вместо javax)
	implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")

	// Для интеграции с Servlet API
	implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}