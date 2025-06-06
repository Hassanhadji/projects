import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
	id("org.jetbrains.kotlin.plugin.lombok") version "1.9.10"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}

group = "seg3102.group25.wellmeadows"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	implementation("org.springframework.boot:spring-boot-starter-security")

	implementation("com.google.firebase:firebase-admin:9.2.0")

	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.junit.platform:junit-platform-suite:1.10.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("io.cucumber:cucumber-java:7.14.0")
	testImplementation("io.cucumber:cucumber-spring:7.14.0")
	testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
	systemProperty("cucumber.junit-platform.naming-strategy", "long")
}

tasks.withType<BootJar> {
	archiveFileName = "hmspms.jar" // Specify your custom JAR name here
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	from("src/main/resources") {
		into("BOOT-INF/classes")
	}
}

configurations {
	all {
		// OPTIONAL: Exclude JUnit 4
		exclude(group = "junit", module = "junit")
		// OPTIONAL: Exclude JUnit 5 vintage engine
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		// OPTIONAL: Exclude JUnit 5 jupiter engine
		exclude(group = "org.junit.jupiter", module = "junit-jupiter-engine")
	}
}

