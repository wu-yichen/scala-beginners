package lectures.part4pm

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "scala"
  val constants = x match {
    case 1 => "a number"
    case "scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnythin = x match {
    case _ =>
  }

  // 2.2 varibale
  val matchAvariable = x match {
    case something => s"I've found $something"
  }
  //3. tuples
  val aTuple= (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1,(2,3))
  val matchANestedTuple = nestedTuple match {
    case (_,(2,v)) =>
  }

  // 4 case classes  - constructor pattern

  // 5 list patterns
  val aList = List(1,2,3,42)
  val standardListmatching = aList match {
    case List(1,_,_,_) => //extractor - advanced
    case List(1,_*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1,2,3) :+ 42 => // infix pattern
  }

  // 6 type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptylist @ List(1,_,_,_) =>
  }

  // 8 - multi-patterns
  val multipattern = aList match {
    case List(1,2,_) | List(1, _*) =>
  }

  // 9 - if guards

  // JVM trick question - type erasure
  val numbers = List(1,2,3)
  val result = numbers match {
    case listOfStrings: List[String] => "string"
    case listOfNumbers: List[Int] => "iNT"
    case _ => "something else"
  }
  println(result)
}
