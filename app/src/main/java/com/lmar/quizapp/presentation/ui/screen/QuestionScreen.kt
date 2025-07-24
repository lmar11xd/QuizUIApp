package com.lmar.quizapp.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lmar.quizapp.R
import com.lmar.quizapp.domain.model.Question
import com.lmar.quizapp.presentation.ui.components.AnswerItem
import com.lmar.quizapp.presentation.ui.state.QuestionState

@Composable
fun QuestionScreen(
    questions: List<Question>,
    onFinished: (finalScore: Int) -> Unit,
    onBack: () -> Unit
) {
    //https://www.youtube.com/watch?v=L6Noa0_k7hg&t=67s

    var state by remember { mutableStateOf(QuestionState(questions)) }

    val currentQuestion = if(questions.isNotEmpty()) state.questions[state.currentIndex] else null
    var selectedAnswer = currentQuestion?.clickedAnswer

    val imageMap = mapOf(
        "q_1" to R.drawable.q_1,
        "q_2" to R.drawable.q_2,
        "q_3" to R.drawable.q_3,
        "q_4" to R.drawable.q_4,
        "q_5" to R.drawable.q_5,
        "q_6" to R.drawable.q_6,
        "q_7" to R.drawable.q_7,
        "q_8" to R.drawable.q_8,
        "q_9" to R.drawable.q_9,
        "q_10" to R.drawable.q_10
    )

    val imageResId = imageMap[currentQuestion?.picPath] ?: R.drawable.q_1

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey))
    ) {
        item {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        onBack()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = colorResource(R.color.navy_blue)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Single Player",
                    fontSize = 20.sp,
                    color = colorResource(R.color.navy_blue),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            // Questions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Question ${state.currentIndex + 1}/${state.questions.size}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = {
                        if (state.currentIndex > 0) {
                            selectedAnswer = null
                            state = state.copy(currentIndex = state.currentIndex - 1)
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.left_arrow),
                        contentDescription = "Back",
                        tint = colorResource(R.color.navy_blue)
                    )
                }
                IconButton(
                    onClick = {
                        if (state.currentIndex == state.questions.size - 1) {
                            onFinished(state.score)
                        } else {
                            selectedAnswer = null
                            state = state.copy(currentIndex = state.currentIndex + 1)
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.right_arrow),
                        contentDescription = "Back",
                        tint = colorResource(R.color.navy_blue)
                    )
                }
            }
        }

        item {
            LinearProgressIndicator(
                progress = { (state.currentIndex + 1) / state.questions.size.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(14.dp)
                    .clip(RoundedCornerShape(percent = 50)),
                color = colorResource(R.color.orange),
                trackColor = Color(0xffd1d1d1)
            )
        }

        item {
            Text(
                text = currentQuestion?.question ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Center,
                color = colorResource(R.color.navy_blue),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Question Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }

        itemsIndexed(
            listOf(
                currentQuestion?.answer1 ?: "",
                currentQuestion?.answer2 ?: "",
                currentQuestion?.answer3 ?: "",
                currentQuestion?.answer4 ?: "",
            )
        ) { index, answer ->
            val answerLetter = listOf("a", "b", "c", "d")[index]
            val isCorrect = selectedAnswer != null && answerLetter == currentQuestion?.correctAnswer
            val isWrong = selectedAnswer == answerLetter && !isCorrect

            AnswerItem(
                text = answer,
                isCorrect = isCorrect,
                isWrong = isWrong,
                isSelected = selectedAnswer != null
            ) {
                val updatedQuestion = state.questions.toMutableList()
                val updatedCurrentQuestion = updatedQuestion[state.currentIndex].copy(clickedAnswer = answerLetter)
                updatedQuestion[state.currentIndex] = updatedCurrentQuestion
                val scoreToAdd = if(answerLetter == updatedCurrentQuestion.correctAnswer) 5 else 0
                state = state.copy(
                    questions = updatedQuestion,
                    score = state.score + scoreToAdd
                )
                selectedAnswer = answerLetter
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    val questions = listOf(
        Question(
            id = 1,
            question = "What is the capital of France?",
            answer1 = "Paris",
            answer2 = "London",
            answer3 = "Berlin",
            answer4 = "Madrid",
            correctAnswer = "Paris",
            score = 10,
            picPath = null,
            clickedAnswer = ""
        ),
        Question(
            id = 2,
            question = "What is the largest country in the world?",
            answer1 = "Russia",
            answer2 = "China",
            answer3 = "India",
            answer4 = "USA",
            correctAnswer = "Russia",
            score = 10,
            picPath = null,
            clickedAnswer = ""
        )
    )

    QuestionScreen(questions = questions, onFinished = {}, onBack = {})
}