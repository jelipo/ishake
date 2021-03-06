plugins {
    java
}

group = "com.jelipo"
version = "0.0.1"

repositories {
    maven("https://repo.huaweicloud.com/repository/maven/")
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17
