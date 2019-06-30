import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
	id("org.springframework.boot") version "2.2.0.BUILD-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"

	kotlin("jvm") version "1.3.31"
	kotlin("plugin.spring") version "1.3.31"
	kotlin("kapt") version "1.3.40"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val coroutinesVersion = "1.2.1"

val jacksonModuleKotlinVersion = "2.9.8"
val jacksonDatatypeJsr310 = "2.9.8"

val retrofit_version = "2.6.0"
val moshi_version = "1.8.0"
val okhttp_version = "3.11.0"



repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://repo.spring.io/milestone") }
	jcenter()
}

dependencies {
	// spring
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	// jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${coroutinesVersion}")

	implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonDatatypeJsr310")
	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion")
	implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
	implementation ("com.squareup.retrofit2:converter-moshi:$retrofit_version")
	implementation ("com.squareup.moshi:moshi:$moshi_version")
	implementation ("com.squareup.moshi:moshi-kotlin:$moshi_version")
	kapt ("com.squareup.moshi:moshi-kotlin-codegen:$moshi_version")
	implementation ("com.squareup.okhttp3:okhttp:$okhttp_version")
	implementation ("com.squareup.okhttp3:logging-interceptor:$okhttp_version")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(group = "junit", module = "junit")
	}
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
