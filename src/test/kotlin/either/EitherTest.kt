package either

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EitherTest {
  @Test fun testFold() {
    val x: Either<Int, Int> = Left(123)
    assertThat(x.fold({ it * 2 }, { it * 3 })).isEqualTo(123 * 2)

    val y: Either<Int, String> = Right("right")
    assertThat(y.fold({ "${it}left" }, { "${it}right" })).isEqualTo("rightright")
  }
}
