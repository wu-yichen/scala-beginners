package lectures.part3fp

object WhatsAFunction extends App {

  // use functions as first class elements
  // problem: oop
  /*
    1. a function which takes 2 strings and concatenates them
    2. define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  val fun1 = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }
  println(fun1("hello", "scala"))

  val fun2 = new Function1[Int, Function1[Int,Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  println(fun2(1)(2)) // curried function
}
