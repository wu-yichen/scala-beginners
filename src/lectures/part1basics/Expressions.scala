package lectures.part1basics

object Expressions extends App {

  var x = 1+ 32 // Expression
  println(x)

  // Instructions (DO) VS Expressions (VALUE)
  val acondition = true
  val aVal = if (acondition) 5 else 3 // this is an expression
  println(aVal)

  // everything in scala is an expression !~ do not use loop, reassigning... which reutrns unit

  val weirdVal = (x = 3) // it returns a unit which is equivalent with void
  println(weirdVal)

  var i = 0
  val w = while (i < 10) {
    print(i)
    i += 1
  }
  println(w)
  // side effects: println(), whiles, reassigning  should avoid

  // code blocks -  the value of the code block is the value of its last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > y) "Hellow" else "World"
  }
  print(aCodeBlock)

  // basic expressions: operations, if statement, code blocks
}
