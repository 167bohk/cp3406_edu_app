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
- ViewModel, UI state, and repository classes
- A unit test for the quiz scoring logic

## Data sources

The daily image and description come from the NASA APOD API:
https://api.nasa.gov/

The starter version uses NASA's `DEMO_KEY`, which has a low request limit.
A personal NASA API key should be supplied through local build configuration
before the app is distributed.

## Next steps

1. Add Room for quiz attempts and saved APOD items.
2. Add Preferences DataStore for settings.
3. Add a planet knowledge section.
4. Add repository, ViewModel, and Compose UI tests.
