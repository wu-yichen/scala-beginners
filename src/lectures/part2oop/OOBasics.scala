package lectures.part2oop

object OOBasics extends App {

  // constructor
  // class parameters are not FIELDS
  class Writer(firstName: String, surname: String, val year: Int) {
    def fullname=
      this.firstName + this.surname
  }

  class Novel(name: String, yearOfRelease: Int, author: Writer) {
    def authorAge = this.yearOfRelease - this.author.year
    def isWrittenBy(author: Writer) = this.author == author
    def copy(yearOfRelease: Int): Novel = new Novel(this.name, yearOfRelease, this.author)
  }

  class Counter(val count: Int) {
    def increaseCounter = {
      println("incrementing by one")
      new Counter(this.count + 1)
    }

    def decreaseCounter = {
      println("decrementing")
      new Counter(this.count - 1)
    }

    def increaseCounter(num: Int): Counter = {
      if (num <= 0) this
      else increaseCounter.increaseCounter(num - 1)
    }

    def decreaseCounter(num: Int): Counter = {
      if (num <= 0) this
      else decreaseCounter.decreaseCounter(num - 1)
    }
  }

  val c = new Counter(5)

  c.decreaseCounter(4)
}
