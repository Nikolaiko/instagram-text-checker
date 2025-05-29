## Instagram Helper

Приложение написанное с помощью технологии : **Kotlin Multiplatform App**. Служит хранилищем заметок, а также проверяет - удовлетворяет ли заметка ограничениям инстаграмма по количеству символов. Состоит из трех частей :
- Модуль с логикой, сервисами, UI и классами модели общими для всех платформ (shared)
- iOS приложение
- Android приложение

# Shared модуль
- Язык : Kotlin
- DI : [Koin](https://insert-koin.io/docs/4.1/reference/koin-mp/kmp)
- Библиотека локального хранилища настроек: Реализовано для каждой платформы (iOS - UserDefaults, Android - SharedPreferences)
- UI : [Compose Mulitplatform](https://www.jetbrains.com/compose-multiplatform/)
- Библиотека локального хранилища данных : [Room](https://developer.android.com/kotlin/multiplatform/room?hl=ru)
- Navigation : [Compose-Mulitplatform Navigation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html)
- ViewModel : [ViewModel](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)
- Тесты : Нет

# iOS приложение
- Язык : Swift
- DI : Koin (инициализация)
- Тесты : Нет

# Android приложение
- Язык : Kotlin
- DI : Koin (инициализация)
- Тесты : Нет

# Дизайн шаблон
[Figma](https://www.figma.com/design/F2nXOggRcrHbINmVJhHjov/InstagramHelper?node-id=0-1&t=4UIMUN24j7k5oAA7-1)

