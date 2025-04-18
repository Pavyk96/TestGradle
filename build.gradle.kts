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
	implementation("org.springframework.boot:spring-boot-starter")

	// Spring Data JPA + PostgreSQL драйвер
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql:42.7.3")  // или актуальная версия

	implementation("org.springframework.boot:spring-boot-starter-web")

	// Lombok (для сокращения boilerplate-кода, опционально)
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
