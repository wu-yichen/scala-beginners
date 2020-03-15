package exercises

object MyException extends App {
  class PocketCalculator {
    def add(a: Int, b: Int): Int =
      if (a > 0 && b > 0 && (a+b) < 0) throw new OverflowException
      else a + b
  }

  class UnderflowException extends Exception("Under flow")
  class OverflowException extends Exception("Over flow")

  println(new PocketCalculator().add(1, Int.MaxValue))
}
