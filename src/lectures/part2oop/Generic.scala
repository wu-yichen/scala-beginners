package lectures.part2oop

object Generic {
  def main(args: Array[String]): Unit = {

    class MyList[A] {
      def get[A]: MyList[A] = new MyList[A]
      def set[A] = "ok"
    }

    val l = new MyList[Int]
    println(l.get[Int].getClass)

    class Animal
    class Dog extends Animal
    class Cat

    // covariance
    class Covariance[+A]
    val dog: Covariance[Animal] = new Covariance[Dog]

    // invariance
    class Invariance[A]
    val dog2: Invariance[Dog] = new Invariance[Dog]

    // contravariance
    class Contravariance[-A]
    val dog3: Contravariance[Dog] = new Contravariance[Animal]

    // bounded type
    class Cage[A <: Animal](animal: A)
    val cage = new Cage[Dog](new Dog)
  }

}
