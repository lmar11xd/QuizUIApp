package com.lmar.quizapp.presentation.navigation

sealed class AppRoutes(val route: String) {
    object MainScreen : AppRoutes("mainScreen")
    object QuestionScreen : AppRoutes("questionScreen")
    object ScoreScreen : AppRoutes("scoreScreen")
    object LeaderScreen : AppRoutes("leaderScreen")

    fun withArgs(vararg args: String): String =
        route + args.joinToString(separator = "&", prefix = "?") { "$it={$it}" }

    fun withParam(key: String, value: String): String =
        "$route?$key=$value"
}