plugins {
    java
}

group = "com.jelipo"
version = "0.0.1"

repositories {
    maven("https://repo.huaweicloud.com/repository/maven/")
}

dependencies {
    implementation("cglib:cglib:3.3.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17
