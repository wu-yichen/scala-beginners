package exercises

abstract class MyList {
   /*
    head = first element of the list
    tail - remainder of the list
    isEmpty
    add(int) => new list with this element added
    toString => a string representation of the list
   */
  def head: Int

  def tail: MyList

  def isEmpty(): Boolean

  def add(element: Int): MyList

  def printElement(): String

  override def toString(): String = s"[$printElement]"
}

object Empty extends MyList {

  def head: Int = throw new NoSuchElementException

  def tail: MyList = throw new NoSuchElementException

  def add(element: Int): MyList = new greatList(element, Empty)

  def isEmpty(): Boolean = true

  def printElement(): String = ""
}

class greatList(val head: Int, val tail: MyList) extends MyList {

  def isEmpty(): Boolean = false

  def add(element: Int): MyList = new greatList(element, this)

  def printElement(): String = {
    if (tail.isEmpty()) head + ""
    else head + " " + tail.printElement()
  }
}

object run extends App {
  val list = new greatList(1, new greatList(2, new greatList(3, Empty)))
  println(list.head)
  println(list.add(5))
  val newList = list.add(6).add(5)
  println(newList)
  println(newList.tail.head)
  println(newList.isEmpty())
  println(newList.toString())
}