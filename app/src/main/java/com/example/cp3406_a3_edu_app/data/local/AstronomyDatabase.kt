package com.example.cp3406_a3_edu_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [QuizAttempt::class],
    version = 1,
    exportSchema = false
)
abstract class AstronomyDatabase : RoomDatabase() {
    abstract fun quizAttemptDao(): QuizAttemptDao

    companion object {
        @Volatile
        private var Instance: AstronomyDatabase? = null

        fun getDatabase(context: Context): AstronomyDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AstronomyDatabase::class.java,
                    "astronomy_database"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
