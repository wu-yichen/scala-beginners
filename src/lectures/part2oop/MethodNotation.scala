package lectures.part2oop

object MethodNotation extends App {
  val mary = new Person("Mary", "inception", 21)
  val mary2 = mary + "the rockstar"
  println(mary2())

  println((+mary).age)
  println(mary learns "scala")
  // postfix notation
  println(mary learnsScala)

  println(mary(2))
}

/**
 * 1. overload the + operator
 *    mary + "the rockstar" => new person "mary (the rockstar)"
 * 2. Add an age to the Person class
 *    Add a unary + operator => new person with the age + 1
 * 3. Add a learns method in the person class => mary learns sclala
 *    Add a learnsScala method calls learns method with scalal
 *    use it in postfix notation
 * 4. overload the apply method
 *    mary.apply(2) => mary watched inception 2 times
 */

class Person(val name: String, favoritMovie: String, val age: Int = 0) {

  // infix notation = operation notation
  def +(nick: String) = new Person(s"$name ($nick)", favoritMovie, age)

  // unary_ prefix notation
  def unary_+ : Person = new Person(name, favoritMovie, age + 1)

  def learns(course: String) = s"$name learns $course"
  // postfix notation
  def learnsScala = this learns "scala"

  def apply(num: Int) = s"$name watched $favoritMovie $num times"
  def apply(): String = s"Hi, my name is $name and I am $age years old"

}

