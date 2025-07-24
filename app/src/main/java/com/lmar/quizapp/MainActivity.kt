package com.lmar.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.lmar.quizapp.core.ui.theme.QuizAppTheme
import com.lmar.quizapp.presentation.navigation.AppNavigation
import com.lmar.quizapp.presentation.ui.screen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                AppNavigation()
            }
        }
    }
}