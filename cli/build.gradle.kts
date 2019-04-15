plugins {
    application
}

application {
    mainClassName = "cli.Main"
}

dependencies {
  implementation(project(":core"))
}
