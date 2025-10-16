# Проект автоматизации тестирования для Wikipedia Android Mobile App

![Wikipedia Android Mobile App Automation](./images/logo/Wikipedia_logo.png)

> Проект автоматизированного тестирования мобильного приложения Wikipedia для Android.

## 📋 О проекте

Проект включает автоматизированные тесты для мобильного приложения Andriod Wikipedia, охватывающие:

- Полный flow онбординга пользователя;

- Настройку языков и выбор локализации;

- Валидацию UI компонентов на всех экранах;

- Интеграционное тестирование пользовательских сценариев.

---

## 📚 Содержание

- [Технологии и инструменты](#технологии-и-инструменты)
- [Архитектура тестов](#архитектура-тестов)
- [Тест-кейсы](#тест-кейсы)
- [Запуск тестов](#запуск-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure отчет](#-allure-отчет)
- [Интеграция с TestOps](#-интеграция-с-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Телеграмм-бот с уведомлениями о результатах тестов](#-телеграмм-бот-с-уведомлениями-о-результатах-тестов)
- [Пример записи видео при выполнении тестов в Selenoid](#-пример-записи-видео-при-выполнении-тестов-в-selenoid)

---

<a id="технологии-и-инструменты"></a>
## 🛠 Технологии и инструменты

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.png" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.png" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure.png" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logo/Jira.png" width="50" height="50"  alt="Jira"/></a>  
</p>

---

<a id="архитектура-тестов"></a>
## 🏗 Архитектура тестов

```bash
src/test/java/
├── config/                  # Конфигурационные классы
│   ├── BrowserstackConfig.java
│   └── LocalConfig.java
├── drivers/                # Драйверы для разных окружений
│   ├── BrowserstackDriver.java
│   └── EmulationDriver.java
├── helpers/               # Вспомогательные классы
│   └── AttachHelper.java
├── screens/               # Screen Object модели экранов
│   ├── AddALanguageScreen.java
│   ├── BookmarksScreen.java
│   ├── DiscoveryScreen.java
│   ├── MainScreen.java
│   ├── PrivacyScreen.java
│   ├── WelcomeScreen.java
│   └── WikipediaLanguagesScreen.java
└── tests/                 # Тестовые классы
    ├── TestBase.java
    └── onboardingTests/   # Тесты онбординга
        ├── BookmarksScreenTests.java
        ├── CompleteOnboardingIntegrationTest.java
        ├── DiscoveryScreenTests.java
        ├── LanguageSettingsScreenTests.java
        ├── PrivacyScreenTests.java
        └── WelcomeScreenTests.java
````


---

<a id="тест-кейсы"></a>
## ✅ Тест-кейсы

🎯 Welcome Screen Тесты
✓ Проверка отображения логотипа Wikipedia

✓ Проверка текстов заголовков

✓ Проверка наличия языка по умолчанию

✓ Проверка кнопок Skip и Continue

✓ Переход к экрану Discovery

✓ Навигация к настройкам языка

🔍 Discovery Screen Тесты
✓ Проверка элементов экрана Discovery

✓ Валидация текстов описания

✓ Проверка изображения

✓ Переход к экрану Bookmarks

✓ Пропуск онбординга

📚 Bookmarks Screen Тесты
✓ Проверка элементов экрана Bookmarks

✓ Валидация текста "Reading lists with sync"

✓ Переход к экрану Privacy

✓ Пропуск онбординга

🔒 Privacy Screen Тесты
✓ Проверка элементов экрана Privacy

✓ Валидация текста "Data & Privacy"

✓ Проверка кнопки "Get started"

✓ Завершение онбординга

🌐 Language Settings Тесты
✓ Проверка экрана выбора языка

✓ Навигация к добавлению языка

✓ Проверка списка языков

✓ Выбор конкретных языков (параметризованный тест)

🔄 Интеграционные тесты
✓ Полный flow онбординга: Welcome → Discovery → Bookmarks → Privacy → Main

✓ Проверка корректности переходов между экранами

---

<a id="запуск-тестов"></a>
## 🚀 Запуск тестов

### Локальный запуск на эмуляторе
```bash
./gradlew clean test -DdeviceHost=emulator
```
### Локальный запуск на BrowserStack
```bash
./gradlew clean test -DdeviceHost=browserstack
```
### Запуск тестов с определенными тегами (если не указать device, то по умолчанию будет browserstack)
```bash
smoke_tests
./gradlew clean welcome_tests
./gradlew clean discovery_tests
./gradlew clean bookmarks_tests
./gradlew clean privacy_tests
./gradlew clean languages_tests
./gradlew clean regression_tests
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins
[Сборка в Jenkins](https://jenkins.autotests.cloud/job/android-wikipedia-app-tests/16/)
<p align="center">
    <img title="Jenkins Build" src="images/BuildJenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/AllureReport.png"> Allure-отчет
[Allure отчет](https://jenkins.autotests.cloud/job/android-wikipedia-app-tests/16/allure/)
<p align="center">
    <img title="Allure Overview" src="images/AllureJenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.png"> Интеграция с TestOps
[Интеграция с TestOps](https://allure.autotests.cloud/project/4952/dashboards)
<p align="center">
    <img title="Allure Overview" src="images/TestOpsDashboards.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Jira.png"> Интеграция с Jira
[Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-1513)
<p align="center">
    <img title="Jira Integration" src="images/JiraTask.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Telegram.png"> Телеграмм-бот с уведомлениями о результатах тестов
<p align="center">
<img width="70%" title="Telegram Notifications" src="images/TelegramBot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.png"> Пример записи видео при выполнении тестов
<p align="center">
<img title="Selenoid Video" src="images/VideoFromJenkinsTest.gif" width="250" height="550"  alt="video"> 
</p>

