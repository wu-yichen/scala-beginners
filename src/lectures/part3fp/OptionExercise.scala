package lectures.part3fp

import scala.util.Random

object OptionExercise extends App {

//  val myFirstOption: Option[String] = Some("first option")
//  val noOption: Option[String] = None
//  println(myFirstOption.isEmpty)
//  println(myFirstOption.get) // unsafe do not use this
//
//  println(myFirstOption.map(_ * 2))
//  println(myFirstOption.filter(_ == "rr"))
//  println(myFirstOption.flatMap(x => Option(x * 2)))
//
//  def unsafeMethod1(): String = null
//  def backupMethod1() = "This is back up"
//  println(Option(unsafeMethod1()).orElse(Option(backupMethod1())))
//
//  def unsafeMethod(): Option[Int] = None
//  def backupMethod(): Option[Int] = Some(3)
//  val result = unsafeMethod() orElse backupMethod()
//  println(result)

  /*
    exercise
   */
  val conf: Map[String, String] = Map("host" -> "176.45.36.1", "port" -> "80")

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }
  // try to establish a connection, if so - print the connect method
  // method 1: using for-comprehension
  var con = for {
    h <- conf.get("host")
    p <- conf.get("port")
    connection <- Connection(h,p)
  } yield connection.connect
  con.foreach(println)

  // method 2: using flatMap
 // conf.get("host").flatMap(h => conf.get("port").flatMap(p => Connection(h,p))).map(c => c.connect).foreach(println)

}
