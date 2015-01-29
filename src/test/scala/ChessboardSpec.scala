import org.specs2.mutable.Specification

/**
 * Created by alaym on 25/01/15.
 */
class ChessboardSpec extends Specification {

  "Chessboard" should {

    "place super queen" in {

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

      val n = 4

      val expectedChessboard = Some(Chessboard(Nil, List(Position(4, 2), Position(1, 1))))

      currentChessboard.placeSuperQueenInFirstEmptySlot must beEqualTo(expectedChessboard)


    }

    "place super queen in pos" in {

      val n = 4
      val positions = (1 to n).flatMap(r => (1 to n).map(c => Position(c, r))).toList
      val pos = Position(1, 1)
      val chessboard = Chessboard(positions, Nil)

      val expected = Chessboard(
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

      chessboard.placeSuperQueenInPos(pos) must beEqualTo(expected)


    }

  }

}
