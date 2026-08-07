package com.example.cp3406_a3_edu_app.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

data class UserPreferences(
    val soundEnabled: Boolean = true,
    val difficulty: String = "Medium"
)

interface UserPreferencesRepository {
    val preferences: Flow<UserPreferences>

    suspend fun saveSoundEnabled(enabled: Boolean)
    suspend fun saveDifficulty(difficulty: String)
}

private val Context.userPreferencesDataStore by preferencesDataStore(
    name = "user_preferences"
)

class OfflineUserPreferencesRepository(context: Context) : UserPreferencesRepository {
    private val dataStore = context.userPreferencesDataStore

    override val preferences: Flow<UserPreferences> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val savedDifficulty = preferences[DIFFICULTY] ?: "Medium"

            UserPreferences(
                soundEnabled = preferences[SOUND_ENABLED] ?: true,
                difficulty = if (savedDifficulty in DIFFICULTIES) {
                    savedDifficulty
                } else {
                    "Medium"
                }
            )
        }

    override suspend fun saveSoundEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[SOUND_ENABLED] = enabled
        }
    }

    override suspend fun saveDifficulty(difficulty: String) {
        if (difficulty !in DIFFICULTIES) return

        dataStore.edit { preferences ->
            preferences[DIFFICULTY] = difficulty
        }
    }

    private companion object {
        val SOUND_ENABLED = booleanPreferencesKey("sound_enabled")
        val DIFFICULTY = stringPreferencesKey("difficulty")
        val DIFFICULTIES = listOf("Easy", "Medium", "Hard")
    }
}
