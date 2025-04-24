## Instagram Helper

Приложение написанное с помощью технологии : **Kotlin Multiplatform App**. Состоит из трех частей :
- Модуль с логикой, сервисами, UI и классами модели общими для всех платформ (shared)
- iOS приложение
- Android приложение

# Shared модуль
- Язык : Kotlin
- DI : ??
- Библиотека локального хранилища настроек: Реализовано для каждой платформы (iOS - UserDefaults, Android - SharedPreferences)
- UI : [Compose Mulitplatform](https://www.jetbrains.com/compose-multiplatform/)
- Библиотека локального хранилища данных : [Room](https://developer.android.com/kotlin/multiplatform/room?hl=ru)
- Тесты : Нет

# iOS приложение
- Язык : Swift
- DI : ??
- Navigation : ??
- Linter : [SwiftLint](https://github.com/realm/SwiftLint)
- Тесты : Нет

# Android приложение
- Язык : Kotlin
- DI : ??
- Navigation : [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)
- Тесты : Нет

# Дизайн шаблон
[Figma](https://www.figma.com/design/F2nXOggRcrHbINmVJhHjov/InstagramHelper?node-id=0-1&t=4UIMUN24j7k5oAA7-1)

