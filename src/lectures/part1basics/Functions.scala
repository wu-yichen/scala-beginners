package lectures.part1basics



object Functions extends App {
  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + "years old"
  }
  println(greeting("xiaoming",23))

  def factorial(n: Int): Int = {
    if (n == 1) n
    else n * factorial(n - 1)
  }
  println(factorial(4))

  def fab(n: Int): Int = {
    if (n == 1 || n == 2) n
    else fab(n - 1) + fab(n - 2)
  }
  println(fab(5))

  def isPrime(n: Int): Boolean = {
    if (n == 1) false
    else {
      def cal(next: Int): Boolean= {
        if (next <= 1) true
        else n % next != 0 && cal(next - 1)
      }
      cal(n / 2)
    }
  }
  val num = 37
  println(if (isPrime(num)) num +" is prime" else num + " is not a prime")
  // WHEN YOU NEED LOOP, USE TAIL_RECURSIION
//  def aRepeatableFunction(aStr: String, n: Int): String = {
//    if (n == 1) aStr
//    else aStr + aRepeatableFunction(aStr, n - 1)
//  }
//  println(aRepeatableFunction("Hello",3))
}
