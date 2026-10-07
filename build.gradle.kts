plugins {
    base
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
