import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	kotlin("kapt") version "1.8.21"
	id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "com.mikechoe.cocsi"
version = "0.0.1-SNAPSHOT"

extra["springCloudGcpVersion"] = "4.5.0"
extra["springCloudVersion"] = "2022.0.3"

allprojects {
	apply(plugin = "idea")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

	repositories {
		mavenCentral()
		mavenLocal()
	}

	java {
		sourceCompatibility = JavaVersion.VERSION_17
	}

	dependencies {
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
		implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
		implementation("com.google.cloud:spring-cloud-gcp-starter-pubsub:4.5.0")


		testImplementation("io.projectreactor:reactor-test")
		testImplementation("org.springframework.boot:spring-boot-starter-test")

	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs += "-Xjsr305=strict"
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<org.jlleitschuh.gradle.ktlint.tasks.BaseKtLintCheckTask> {
        workerMaxHeapSize.set("512m")
    }
}

var libprojects = allprojects.filter {
    it.findProperty("type").toString().contains("lib")
}
configure(libprojects) {
    apply(plugin = "org.springframework.boot")
    val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
    bootJar.enabled = false

    val jar: Jar by tasks

    jar.enabled = true
}
