package lectures.part3fp

object AnonymousFunctions extends App {
  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2
  val doubler2: Int => Int = x => x * 2

  var adder: (Int,Int) => Int = (a,b) => a + b

  var justDoSomething: () => Int = () => 3
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  var stringToInt = { (str: String) =>
    str.toInt
  }

  var niceIncrementer: (Int => Int) = (x: Int) => x + 1
  var niceAdder: ((Int, Int) => Int) = (x: Int, y: Int) => x + y
}
