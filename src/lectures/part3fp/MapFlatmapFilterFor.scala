package lectures.part3fp

object MapFlatmapFilterFor extends App {
  var list = List(1,2,3)
  println(list.map(_+1))

  println(list.filter(_%2 == 0))

  println(list.flatMap(x => List(x, x+1)))

  var numbers = List(1,2,3,4)
  var chars = List('a','b','c', 'd')
  var colors = List("Black", "white")

  // iterating
  var combination = numbers.flatMap(n => (chars.flatMap(c => colors.map(co => "" + n + "" +c+ ""+co))))
  println(combination)

  // for-comprehensions
  var combination_for = for {
    n <- numbers if n % 2 == 0
    c <- chars
    co <- colors
  } yield "" + n + "" +c+ ""+co

  println(combination_for)
}
