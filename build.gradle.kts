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
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.projectlombok:lombok")

	annotationProcessor("org.projectlombok:lombok")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final") // Указана версия

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")
}



tasks.withType<Test> {
	useJUnitPlatform()
}
