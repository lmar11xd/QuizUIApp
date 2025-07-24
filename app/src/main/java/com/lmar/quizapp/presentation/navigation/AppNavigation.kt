package com.lmar.quizapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lmar.quizapp.domain.model.Question
import com.lmar.quizapp.domain.model.User
import com.lmar.quizapp.presentation.ui.screen.LeaderScreen
import com.lmar.quizapp.presentation.ui.screen.MainScreen
import com.lmar.quizapp.presentation.ui.screen.QuestionScreen
import com.lmar.quizapp.presentation.ui.screen.ScoreScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = AppRoutes.MainScreen.route) {

        composable(route = AppRoutes.MainScreen.route) {
            MainScreen(
                onSinglePlayerClick = {
                    navController.navigate(AppRoutes.QuestionScreen.route)
                },
                onBoardClick = {
                    navController.navigate(AppRoutes.LeaderScreen.route)
                }
            )
        }

        composable(route = AppRoutes.QuestionScreen.route) {
            val questions = listOf(
                Question(
                    1,
                    "Which planet is the largest planet in the solar system?",
                    "Earth",
                    "Mars",
                    "Neptune",
                    "Jupiter",
                    "d",
                    5,
                    "q_1",
                    null
                ),
                Question(
                    2,
                    "Which country is the largest country in the world by land area?",
                    "Russia",
                    "Canada",
                    "United States",
                    "China",
                    "a",
                    5,
                    "q_2",
                    null
                ),
                Question(
                    3,
                    "Which of the following substances is used as an anti-cancer medication?",
                    "Cheese",
                    "Lemon juice",
                    "Cannabis",
                    "Paspalum",
                    "c",
                    5,
                    "q_3",
                    null
                ),
                Question(
                    4,
                    "Which moon has an atmosphere?",
                    "Luna",
                    "Phobos",
                    "Venus' moon",
                    "None of the above",
                    "d",
                    5,
                    "q_4",
                    null
                ),
                Question(
                    5,
                    "Which symbol represents the element with atomic number 6?",
                    "O",
                    "H",
                    "C",
                    "N",
                    "c",
                    5,
                    "q_5",
                    null
                ),
                Question(
                    6,
                    "Who is credited with inventing theater as we know it?",
                    "Shakespeare",
                    "Arthur Miller",
                    "Ashkouri",
                    "Ancient Greeks",
                    "d",
                    5,
                    "q_6",
                    null
                ),
                Question(
                    7,
                    "Which ocean is the largest?",
                    "Pacific",
                    "Atlantic",
                    "Indian",
                    "Arctic",
                    "a",
                    5,
                    "q_7",
                    null
                ),
                Question(
                    8,
                    "Which religions are most practiced?",
                    "Islam, Christianity, Judaism",
                    "Buddhism, Hinduism, Sikhism",
                    "Zoroastrianism, Brahmanism",
                    "Taoism, Shintoism",
                    "a",
                    5,
                    "q_8",
                    null
                ),
                Question(
                    9,
                    "Which continent has the most independent countries?",
                    "Asia",
                    "Europe",
                    "Africa",
                    "Americas",
                    "c",
                    5,
                    "q_9",
                    null
                ),
                Question(
                    10,
                    "Which ocean has the greatest average depth?",
                    "Pacific",
                    "Atlantic",
                    "Indian",
                    "Southern",
                    "d",
                    5,
                    "q_10",
                    null
                )
            )

            QuestionScreen(
                questions = questions,
                onFinished = { finalScore ->
                    navController.navigate(
                        AppRoutes.ScoreScreen.withParam(
                            "score",
                            finalScore.toString()
                        )
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = AppRoutes.ScoreScreen.withArgs("score")) {
            ScoreScreen(
                score = 100,
                onBackToMain = {
                    navController.navigate(AppRoutes.MainScreen.route)
                }
            )
        }

        composable(route = AppRoutes.LeaderScreen.route) {
            val topUsers = listOf(
                User(1, "Sophia", "person1", 4850),
                User(2, "Daniel", "person2", 4560),
                User(3, "James", "person3", 3873),
            )

            val users = listOf(
                User(4, "John Smith", "person4", 3250),
                User(5, "Emily Johnson", "person5", 3015),
                User(6, "Sarah Wilson", "person6", 2970),
                User(7, "Mohamed Salah", "person7", 2870),
                User(8, "Silvestre Santos", "person8", 2670),
                User(9, "Neymar Jr.", "person9", 2380),
                User(10, "Michael Davis", "person6", 2376)
            )

            LeaderScreen(
                topUsers = topUsers,
                otherUsers = users,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
