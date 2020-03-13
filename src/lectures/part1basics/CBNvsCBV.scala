package lectures.part1basics

object CBNvsCBV extends App {

  // call by value - value is computed before call and same value used everywhere
  def callByValue(time: Long): Unit = {
    println(time)
    println(time)
  }

  // it will pass literal when you use it - lazy loading
  def callbyName(time: => Long): Unit = {
    println(time)
    println(time)
  }

  callByValue(System.nanoTime())
  callbyName(System.nanoTime())

  def infinite(): Int = infinite() + 1
  def callByName2(x: Int, y: => Int): Unit = println(x)
  callByName2(34, infinite())
}
