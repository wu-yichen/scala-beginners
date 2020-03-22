package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val ran = new Random()
  val num = ran.nextInt(10)
  var result =  num match {
    case 1 => "The one"
    case 2 => "double"
    case 3 => "third time"
    case _ => "default"
  }

  println(num)
  println(result)

  // decompose values

  case class Person(name: String, age: Int) {

    def matching(): String = {
      this match {
        case Person(n,a) if a < 22 => s"hey I am $n and I am $a years old"
        case _ => "I do not know who you are"
      }
    }
  }
  val p = Person("bob",21)
  println(p.matching)
}
