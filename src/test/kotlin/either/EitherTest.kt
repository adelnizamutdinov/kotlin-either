package either

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EitherTest {

    @Test
    fun left() {
        val la = when (val x: Either<Int, Int> = Either.Left(value = 123)) {
            is Either.Left -> x.value * 2
            is Either.Right -> -1
        }

        assertEquals(expected = 123 * 2, actual = la)
    }

    @Test
    fun right() {
        val lala = when (val y: Either<Int, String> = Either.Right(value = "right")) {
            is Either.Left -> "${y.value}left"
            is Either.Right -> "${y.value}right"
        }

        assertEquals(expected = "rightright", actual = lala)
    }

    @Test
    fun map() {
        val l: Either<Int, String> = Either.Left(value = 5)

        assertEquals(Either.Left(value = 5), l.map { it + "yes" })
        assertEquals(Either.Right(value = 25), Either.Right(value = 5).map { it * 5 })
    }
}
