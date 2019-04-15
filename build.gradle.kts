import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  base
  kotlin("jvm") version "1.3.30"
}

allprojects {

  group = "org.gradle.kotlin.dsl.samples.multiproject"

  version = "1.0"

  repositories {
    jcenter()
    mavenCentral()
  }
}

subprojects {

  apply<KotlinPlatformJvmPlugin>()

  dependencies {
    implementation(kotlin("stdlib-jdk8"))
  }

  kotlin {
    sourceSets {
      main {
        kotlin.setSrcDirs(setOf("src"))
      }
      test {
        kotlin.setSrcDirs(setOf("tests"))
      }
    }
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "10"
  }
}

dependencies {
  // Make the root project archives configuration depend on every subproject
  subprojects.forEach {
    archives(it)
  }
}
