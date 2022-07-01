import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.thinkimi.gradle.MybatisGenerator") version "2.4"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "jp.ac.it_college.std.s21011"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.4.0")
    implementation("mysql:mysql-connector-java:8.0.29")
    mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.1")

    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.springframework.session:spring-session-data-redis")
    implementation("redis.clients:jedis")
}

mybatisGenerator {
    verbose = true
    configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
