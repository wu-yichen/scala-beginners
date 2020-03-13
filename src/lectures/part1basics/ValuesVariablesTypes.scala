package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  val xy = 42
  println(x)

  var aStr: String = "test"
  val aBoolean: Boolean = true // false
  val ch: Char = 'a'
  var i: Int = 2
  val aShort: Short = 23
  val aLong: Long = 345242342787987987L
  val aFloat: Float = 3123.0f
  val aDouble: Double = 321.213
  // VALS ARE IMMUTABLE, Compiler can infer types

  // var is mutable
  var aVar: Int = 4
  aVar = 5
}
