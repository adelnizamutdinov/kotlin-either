package either

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EitherTest {

  @Test
  fun left() {
    val x: Either<Int, Int> = Left(123)

    val la = when (x) {
      is Left  -> x.value * 2
      is Right -> -1
    }

    assertThat(la).isEqualTo(123 * 2)
  }

  @Test
  fun right() {
    val y: Either<Int, String> = Right("right")

    val lala = when (y) {
      is Left  -> "${y.value}left"
      is Right -> "${y.value}right"
    }

    assertThat(lala).isEqualTo("rightright")
  }

  @Test
  fun map() {
    val l: Either<Int, String> = Left(5)

    check(l.map { it + "yes" } == Left(5))

    check(Right(5).map { it * 5 } == Right(25))

  }
}
