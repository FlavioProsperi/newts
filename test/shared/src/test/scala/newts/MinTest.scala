package newts

import cats.kernel.laws.{GroupLaws, OrderLaws}
import cats.laws.discipline.MonadTests

class MinTest extends NewtsSuite {

  checkAll("Min[Int]", GroupLaws[Min[Int]].semigroup)
  checkAll("Min[Int]", GroupLaws[Min[Int]].monoid)
  checkAll("Min[Int]", OrderLaws[Min[Int]].order)
  checkAll("Min[Int]", MonadTests[Dual].monad[Int, Int, Int])

  test("combine"){
    5.asMin |+| 1.asMin shouldEqual Min(1)
    1.asMin |+| 5.asMin shouldEqual Min(1)
  }

  test("show") {
    Min(5).show shouldEqual "Min(5)"
    Min("1").show shouldEqual "Min(1)"
  }
}
