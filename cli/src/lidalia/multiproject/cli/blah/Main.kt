@file:JvmName("Main")
package lidalia.multiproject.cli.blah

import lidalia.multiproject.core.blah.DeepThought

fun main(vararg args: String) {
  val answer = DeepThought.compute()
  println("The answer to the ultimate question of Life, the Universe and Everything is $answer.")
}
