
case class Position(col: Int, row: Int) {

  def isInSameLine(other: Position): Boolean = col == other.col || row == other.row

  def isInL(other: Position): Boolean = {
    (Math.abs(col - other.col) == 2 && Math.abs(row - other.row) == 1) ||
      (Math.abs(col - other.col) == 1 && Math.abs(row - other.row) == 2)
  }

  def isInDiagonal(other: Position): Boolean = Math.abs(col - other.col) == Math.abs(row - other.row)

  def isInPowerZone(other: Position): Boolean = isInSameLine(other) || isInDiagonal(other) || isInL(other)

  override def toString: String = s"($row, $col)"

}

case class Chessboard(squares: List[Position], queens: List[Position]) {

  def placeSuperQueenInFirstEmptySlot: Option[Chessboard] = squares match {

    case Nil => None

    case head::tail => {

      Some(
        Chessboard(
          tail.filter(!_.isInPowerZone(head)),
          head :: queens
        )
      )

    }

  }

  def placeSuperQueenInPos(pos: Position): Chessboard = Chessboard(squares.filter(!_.isInPowerZone(pos)), pos :: queens)

}


object Solution {

  def canPlaceNQueens(chessboard: Chessboard, n: Int): Boolean = {

    if (n == 0) {
      true
    } else {
      chessboard.placeSuperQueenInFirstEmptySlot.fold(false)(canPlaceNQueens(_, n - 1))
    }

  }

  def placeNQueens(chessboard: Chessboard, n: Int): Int = {

    if (n == 0) {
      println(chessboard.queens)
      1
    } else {

      chessboard.squares match {

        case Nil => 0

        case _ => {

          val cbs = chessboard.squares.map(pos => chessboard.placeSuperQueenInPos(pos))
          println(s"new cbs ${cbs.size}")
          cbs.map(cb => placeNQueens(cb, n - 1)).sum

        }

      }

    }

  }

    def solveNSuperQueens(n: Int): Int = {

    // Fill Up this function body to display the number of arrangements
    // Of N Super-Quees on a chessboard

    val allPositions = (1 to n).flatMap(row => (1 to n).map(col => Position(col, row))).toList

    val chessboard = Chessboard(allPositions, Nil)

    placeNQueens(chessboard, n)

  }


  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    println(solveNSuperQueens(readInt))
  }
}
