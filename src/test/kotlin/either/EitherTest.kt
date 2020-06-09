package either

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EitherTest {

    private companion object {

        fun <T> left(value: T): Either<T, String> =
            Either.Left(value)

        fun <T> right(value: T): Either<String, T> =
            Either.Right(value)
    }

    @Test
    fun map() {
        assertEquals(
            actual = left(5).map { it + "yes" },
            expected = Either.Left(5)
        )

        assertEquals(
            actual = right(5).map { it * 5 },
            expected = Either.Right(25)
        )
    }

    @Test
    fun flatMap() {
        assertEquals(
            actual = left(5).flatMap { left(it + "yes") },
            expected = Either.Left(5)
        )

        assertEquals(
            actual = right(5).flatMap { left(it * 5) },
            expected = Either.Left(25)
        )
    }

    @Test
    fun fold() {
        assertEquals(
            actual = left(5).fold({ "left" }, { "right" }),
            expected = "left"
        )

        assertEquals(
            actual = right(5).fold({ "left" }, { "right" }),
            expected = "right"
        )
    }
}
