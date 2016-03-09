# kotlin-either

an Either type for you to fold all day

## Examples

Creating an `Either<Throwable, T>`

```kotlin
fun <T> Observable<T>.either(): Observable<Either<Throwable, T>> =
    map { Right(it) as Either<Throwable, T> }.onErrorReturn { Left(it) }
```

Folding an `Either<Int, Long>`

```kotlin
unmakeId(dialogId)
    .fold({ api.getHistory(chatId = it, messageId = messageId, userId = null) },
          { api.getHistory(userId = it, messageId = messageId, chatId = null) })
```

[![Build Status](https://travis-ci.org/adelnizamutdinov/kotlin-either.svg?branch=master)](https://travis-ci.org/adelnizamutdinov/kotlin-either)
[![](https://jitpack.io/v/adelnizamutdinov/kotlin-either.svg)](https://jitpack.io/#adelnizamutdinov/kotlin-either)
