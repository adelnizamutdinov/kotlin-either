# kotlin-either

an Either type for you to fold all day, inspired by scalaz https://github.com/scalaz/scalaz/blob/scalaz-seven/core/src/main/scala/scalaz/Either.scala

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

## Installation

```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
dependencies {
    compile "com.github.adelnizamutdinov:kotlin-either:$latestVersion"
}
```

[![CircleCI](https://circleci.com/gh/adelnizamutdinov/kotlin-either.svg?style=svg)](https://circleci.com/gh/adelnizamutdinov/kotlin-either)
[![](https://jitpack.io/v/adelnizamutdinov/kotlin-either.svg)](https://jitpack.io/#adelnizamutdinov/kotlin-either)
