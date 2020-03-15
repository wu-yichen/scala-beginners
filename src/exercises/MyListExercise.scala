package exercises

object MyListExercise extends App {

  abstract class MyList[+A] {
    /*
     head = first element of the list
     tail - remainder of the list
     isEmpty
     add(int) => new list with this element added
     toString => a string representation of the list
    */
    def head: A

    def tail: MyList[A]

    def isEmpty(): Boolean

    def add[B >:A](element: B): MyList[B]

    def printElement(): String

    override def toString(): String = s"[$printElement]"

    def ++[B >: A](list: MyList[B]): MyList[B]

    // higher-order functions
    def map[B](transformer: A => B): MyList[B]

    def flatMap[B](transform: A => MyList[B]): MyList[B]

    def filter(predicate: A => Boolean): MyList[A]
  }

  case object Empty extends MyList[Nothing] {

    def head: Nothing = throw new NoSuchElementException

    def tail: MyList[Nothing] = throw new NoSuchElementException

    def add[B >: Nothing](element: B): MyList[B] = new greatList(element, Empty)

    def isEmpty(): Boolean = true

    def printElement(): String = ""

    override def map[B](transformer: Nothing => B): MyList[B] = Empty

    override def flatMap[B](transform: Nothing => MyList[B]): MyList[B] = Empty

    override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  case class greatList[+A](val head: A, val tail: MyList[A]) extends MyList[A] {

    def isEmpty(): Boolean = false

    def add[B >: A](element: B): MyList[B] = new greatList(element, this)

    def printElement(): String = {
      if (tail.isEmpty()) head + ""
      else head + " " + tail.printElement()
    }

    override def map[B](transformer: A => B): MyList[B] = new greatList(transformer(head), tail.map(transformer))

    override def flatMap[B](transform: A => MyList[B]): MyList[B] = transform(head) ++ tail.flatMap(transform)

    override def filter(predicate: A => Boolean): MyList[A] = if (predicate(head)) new greatList(head, tail.filter(predicate)) else tail.filter(predicate)

    override def ++[B >: A](list: MyList[B]): MyList[B] = new greatList(head, tail ++ list)
  }

  val list: greatList[Int] = new greatList[Int](1, new greatList(2, new greatList(3, Empty)))

  println(list.head)
  println(list.add(5))

  val newList = list.add(6).add(5)
  println(newList)
  println(newList.tail.head)
  println(newList.isEmpty())
  println(newList.toString())

  val stringList = new greatList[String]("hello", new greatList[String]("scala", Empty))
  println(stringList.toString())

  println(newList.map(new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }).toString())

  println(newList.filter(new Function1[Int, Boolean] {
    override def apply(v1: Int): Boolean = v1 % 2 != 0
  }).toString())

  println(newList.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(v1: Int): MyList[Int] = new greatList[Int](v1, new greatList[Int](v1 + 1, Empty))
  }).toString())
}