package lectures.part3fp

object HOFsCurries extends App {

  // higher order function (HOF) either take function as parameter or return a function

  def nTimes(f: Int => Int,n: Int,x: Int): Int = {
    if (n <= 1) f(x)
    else nTimes(f, n -1, f(x))
  }

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  println(nTimesBetter(_ + 1, 10)(5))

  // curried function
  val superAdder: Int => (Int => Int) = (x: Int) => ((y: Int) => x + y)
  println(superAdder(3)(7))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(d: Double): String = c.format(d)
  val standard: (Double => String) = curriedFormatter("%4.2f")
  println(standard(Math.PI))
}
