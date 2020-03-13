package lectures.part1basics

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Recurision extends App {

  // use tail recursive -  key is use accumulators

  // example - factorial
  def factorial(num: Int): BigInt = {
    @tailrec
    def helper(n: Int, accumulator: BigInt=1): BigInt =
      if (n <= 1) accumulator
      else helper(n - 1, n * accumulator)

    helper(num)
  }
  //println(factorial(20000))

  // 1. Concatenate a string n times
  def concatenate(str: String, n: Int): String = {
    @tailrec
    def cal(n: Int, accumulator: String): String =
      if (n <= 1) accumulator
      else cal(n - 1, str + accumulator)

    cal(n, str)
  }

  //println(concatenate("hello",5))

  // 2. IsPrime function tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def helper(nums: Int, accumulator: Boolean): Boolean =
      if (!accumulator || nums <= 1) accumulator
      else helper(nums - 1, n % nums != 0 && accumulator)

    helper(n / 2, true)
  }
  val num = 13
  println(if (isPrime(num)) num + " is prime" else num + " is not prime")

  // 3.  Fibonacci
  def fibonacci(num: Int): Int = {
    @tailrec
    def helper(n: Int, acc1: Int, acc2: Int): Int =
      if (n <= 1) acc2
      else helper(n - 1, acc2, acc1+acc2)

    helper(num,0,1)
  }
  println(fibonacci(20))
}
