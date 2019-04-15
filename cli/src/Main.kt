@file:JvmName("Main")
package org.gradle.kotlin.dsl.samples.multiproject.cli

import org.gradle.kotlin.dsl.samples.multiproject.core.DeepThought

fun main(vararg args: String) {
  val answer = DeepThought.compute()
  println("The answer to the ultimate question of Life, the Universe and Everything is $answer.")
}
