package exercises

object Compose extends App {
  /*
    def compose(f,g) => x => f(g(x))
    def andThen(f,g) => x => g(f(x))
   */
  def compose[A,B,C](f: A => B, g: C => A): C => B = {
    x => f(g(x))
  }

  def andThen[A,B,C](f: A => B, g: B => C):A => C = x => g(f(x))
}
