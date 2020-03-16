package lectures.part3fp

import scala.util.Random

object VectorVSList extends App {
  val maxRun = 1000
  val maxCapcity = 1000000

  def perfTest(collection: Seq[Int]): Double = {
    val randomNum = new Random()
    val times = for {
      _ <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(randomNum.nextInt(maxCapcity), randomNum.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRun
  }

  val l = (1 to maxCapcity).toList
  val v = (1 to maxCapcity).toVector

  println(perfTest(l))
  println(perfTest(v))
}
