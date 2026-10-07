plugins {
    id("app.morphe.patches")
    kotlin("jvm")
}

group = "app.morphe.viber"
version = "1.0.0"

patches {
    about {
        name = "Viber Morphe Patches"
        description = "Feature enhancements, privacy controls, and ad removal for Viber (com.viber.voip)."
        source = "https://github.com/kal/viber-morphe-patches"
        author = "Kal"
        contact = "na"
        website = "https://morphe.software"
        license = "GPL-3.0"
    }
}

val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    implementation("com.google.guava:guava:33.0.0-jre")
    implementation("com.google.code.gson:gson:2.10.1")
    
    // Extensions runtime reference (provides symbols during patch compilation)
    compileOnly(project(":extensions:viber"))

    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}
