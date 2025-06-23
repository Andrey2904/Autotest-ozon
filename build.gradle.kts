plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.seleniumhq.selenium:selenium-java:4.20.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.5.3")
}

tasks.test {
    useJUnitPlatform()
}
