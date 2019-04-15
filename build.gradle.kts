import org.gradle.api.JavaVersion.VERSION_11
import org.javamodularity.moduleplugin.ModuleSystemPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  base
  kotlin("jvm") version "1.3.30"
  id("org.javamodularity.moduleplugin") version "1.5.0" apply false
}

allprojects {

  group = "org.gradle.kotlin.dsl.samples.multiproject"

  version = "1.0"

  repositories {
    jcenter()
    mavenCentral()
  }
}

val javaVersion = VERSION_11

subprojects {

  apply<KotlinPlatformJvmPlugin>()
  apply<ModuleSystemPlugin>()

  java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
  }

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
    kotlinOptions.jvmTarget = javaVersion.toString()
  }
}

dependencies {
  // Make the root project archives configuration depend on every subproject
  subprojects.forEach {
    archives(it)
  }
}
