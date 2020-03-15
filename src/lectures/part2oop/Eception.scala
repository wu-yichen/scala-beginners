package lectures.part2oop

object Eception extends App {
  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("no int for you")
    else 42
  val potentialFail = try{
    getInt(true)
  }catch {
    case e: RuntimeException => 43
  } finally {
    println("finally")
  }
  println(potentialFail)

  // how to define your own exceptions

  class MyException extends Exception
  throw new MyException
}
