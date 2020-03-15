package lectures.part2oop

object CaseClass extends App {
  case class Person (name: String, age: Int)

  val jim = new Person("Jim",34)

  // 1. case class paremeters are fileds
  println(jim.name)

  // 2. sensible tostring
  println(jim)

  // 3. equals and hashcode implemented OOTB

  var jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case class have handy copy method
  var jim3 = jim.copy("jim3")
  println(jim3)

  // 5. case class have companion objects
  var thePerson = Person
  println(thePerson)

  // 6. case class are serializable
  // AKKa

  // 7. case class have extractor patterns = ccs can be used in Pattern matching

  case object unitedKindom{
    def name: String = "united kindom"
  }
}
