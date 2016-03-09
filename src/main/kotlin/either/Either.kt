package either

interface Either<out L, out R>
data class Left<T>(val value: T) : Either<T, Nothing>
data class Right<T>(val value: T) : Either<Nothing, T>

inline fun <L, R, T> Either<L, R>.fold(left: (L) -> T, right: (R) -> T): T =
    when (this) {
      is Left  -> left(value)
      is Right -> right(value)
      else     -> error("exhaust")
    }
