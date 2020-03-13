package lectures.part1basics

object StringOps extends App {
  var str = "Hello, I am learning scala"
  println(str.charAt(2)) // l
  println(str.substring(1,4)) // ell
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // s- interpolators
  val name = "xiaogang"
  val age = 23

  val greeting = s"Hello, my name is $name, and I am $age years old"
  val greeting2 = s"Hello, my name is $name, and I am ${age+1} years old"
  println(greeting2)

  // f - interpolators

  val price = 1.2f
  println(f"this is $price%2.2f")

  // raw - interpolators

  println(raw"this will not be a \n new line")
  val newLine = "this will be a \n line"
  println(raw"$newLine")
}
