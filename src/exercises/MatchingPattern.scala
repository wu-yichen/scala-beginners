package exercises

object MatchingPattern extends App {
  /*
    simple function uses PM
    takes an Expr => Human readable form

    sum(Number(2), Number(3)) => 2 + 3
    Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
    Prod(Sum(Number(2),Number(1)), Number(3)) = (2 + 1) * 3
    Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  val expr1 = show(Sum(Number(2), Number(3)))
  val expr2 = show(Sum(Sum(Number(2), Number(3)), Number(4)))
  val expr3 = show(Prod(Sum(Number(2), Number(1)), Number(3)))
  val expr4 = show(Sum(Prod(Number(2), Number(1)), Number(3)))

  def show(e: Expr): String = e match {
    case Number(e) => s"$e"
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Prod(e1,e2) => {
      def showParentheses(expr: Expr): String = expr match {
        case Prod(_,_) => show(expr)
        case Number(_) => show(expr)
        case _ => "(" + show(expr) + ")"
      }

      showParentheses(e1) + " * " + showParentheses(e2)
    }
  }
  println(expr1)
  println(expr2)
  println(expr3)
  println(expr4)
}
