import org.specs2.mutable.Specification

/**
 * Created by alaym on 25/01/15.
 */
class PositionSpec extends Specification {

  "Position" should {

    "be in same line" in {

      val pos = Position(1, 1)

      val other = Position(1, 2)
      val other2 = Position(2, 1)
      val other3 = Position(2, 2)

      pos.isInSameLine(other) must beEqualTo(true)
      pos.isInSameLine(other2) must beEqualTo(true)
      pos.isInSameLine(other3) must beEqualTo(false)

    }

    "be in diagonal" in {

      val pos = Position(1, 1)

      val other = Position(2, 2)
      val other2 = Position(3, 3)
      val other3 = Position(3, 4)

      pos.isInDiagonal(other) must beEqualTo(true)
      pos.isInDiagonal(other2) must beEqualTo(true)
      pos.isInDiagonal(other3) must beEqualTo(false)

    }

    "be in L" in {

      val pos = Position(1, 1)

      val other = Position(3, 2)
      val other2 = Position(2, 3)
      val other3 = Position(3, 3)

      pos.isInL(other) must beEqualTo(true)
      pos.isInL(other2) must beEqualTo(true)
      pos.isInL(other3) must beEqualTo(false)

    }

  }

}
