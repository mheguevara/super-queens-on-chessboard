import org.specs2.mutable.Specification

/**
 * Created by alaym on 25/01/15.
 */
class SolutionSpec extends Specification {

  "Solution" should {

    "place 1 queen" in {

      /**
       * q q q q
       * q q q -
       * q q q -
       * q - - q
       */

      val currentChessboard = Chessboard(
        List(
          Position(4, 2),
          Position(4, 3),
          Position(2, 4),
          Position(3, 4)
        ),
        List(
          Position(1, 1)
        )
      )

      Solution.canPlaceNQueens(currentChessboard, 1) must beEqualTo(true)
      Solution.canPlaceNQueens(currentChessboard, 2) must beEqualTo(false)

    }

  }

}
