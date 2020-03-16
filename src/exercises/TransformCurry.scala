package exercises

object TransformCurry extends App {
  /*
    toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
    fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
   */
  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = x => y => f(x,y)
  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = (x,y) => f(x)(y)

  val fun1 = toCurry(_+_)
  println(fun1(1)(2))

  val fun2 = fromCurry(fun1)
  println(fun2(5,2))
}
