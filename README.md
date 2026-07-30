# Stellar Academy

Stellar Academy is an astronomy education app built with Kotlin and Jetpack
Compose for CP3406 Assessment 3.

## Current features

- Four main screens: Home, Quiz, Statistics, and Settings
- NASA Astronomy Picture of the Day on the Home screen
- Retrofit and kotlinx.serialization for the NASA web service
- Coil for loading the daily image
- Loading, success, and error states with a retry button
- A short astronomy quiz with explanations
- Room database storage for every quiz answer
- Persistent accuracy, answer totals, and completed quiz statistics
- A list of the ten most recent answers
- ViewModel, UI state, and repository classes
- A unit test for the quiz scoring logic

## Project structure

The app follows the architecture introduced in Android Basics with Compose:

```text
Compose screen
    -> ViewModel
    -> Repository
    -> Retrofit service or Room DAO
```

`AppContainer` creates the repositories and provides them to
`AstronomyViewModel` through `AstronomyViewModelFactory`.

## Local database

Room stores one `QuizAttempt` after the user submits an answer. Each record
contains:

- the question ID and question text
- whether the answer was correct
- whether it completed a quiz
- the time the answer was submitted

The DAO uses SQL queries to calculate the number of answers, correct answers,
completed quizzes, and the ten most recent attempts. These values are exposed
as `Flow`, so the Statistics screen updates after a new answer is saved.

## Data sources

The daily image and description come from the NASA APOD API:
https://api.nasa.gov/

The starter version uses NASA's `DEMO_KEY`, which has a low request limit.
A personal NASA API key should be supplied through local build configuration
before the app is distributed.

## Run the project

Open the project in Android Studio, sync the Gradle files, start an emulator,
and run the `app` configuration. An internet connection is required for the
daily NASA image, but the quiz and saved statistics work locally.

To run the current unit tests:

```text
gradlew.bat :app:testDebugUnitTest
```

## Next steps

1. Add Room storage for saved APOD items.
2. Add Preferences DataStore for settings.
3. Add a planet knowledge section.
4. Add repository, DAO, ViewModel, and Compose UI tests.
