package com.lmar.quizapp.presentation.ui.state

import com.lmar.quizapp.domain.model.Question

data class QuestionState (
    val questions: List<Question>,
    val currentIndex: Int = 0,
    val score: Int = 0
)