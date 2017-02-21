package newts

import cats.kernel.laws.{GroupLaws, OrderLaws}
import cats.laws.discipline.MonadTests

class MultTest extends NewtsSuite {

  checkAll("Mult[Int]", GroupLaws[Mult[Int]].monoid)
  checkAll("Mult[Int]", OrderLaws[Mult[Int]].eqv)
  checkAll("Mult[Int]", MonadTests[Mult].monad[Int, Int, Int])

  test("combine") {
    1L.asMult |+| 1L.asMult shouldEqual 1L.asMult
    1.asMult |+| 1.asMult shouldEqual 1.asMult
    0.asMult |+| 1.asMult shouldEqual 0.asMult
  }

}
