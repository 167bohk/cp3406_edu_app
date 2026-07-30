package com.example.cp3406_a3_edu_app.data

import android.content.Context
import com.example.cp3406_a3_edu_app.data.local.AstronomyDatabase
import com.example.cp3406_a3_edu_app.data.network.NasaApi

interface AppContainer {
    val astronomyRepository: AstronomyRepository
    val apodRepository: ApodRepository
    val quizAttemptRepository: QuizAttemptRepository
}

class DefaultAppContainer(context: Context) : AppContainer {
    private val database = AstronomyDatabase.getDatabase(context)

    override val astronomyRepository: AstronomyRepository =
        DemoAstronomyRepository()

    override val apodRepository: ApodRepository =
        NetworkApodRepository(NasaApi.retrofitService)

    override val quizAttemptRepository: QuizAttemptRepository =
        OfflineQuizAttemptRepository(database.quizAttemptDao())
}
