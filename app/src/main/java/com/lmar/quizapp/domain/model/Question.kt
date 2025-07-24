package com.lmar.quizapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val id: Int,
    val question: String?,
    val answer1: String?,
    val answer2: String?,
    val answer3: String?,
    val answer4: String?,
    val correctAnswer: String?,
    val score: Int,
    val picPath: String?,
    val clickedAnswer: String?
): Parcelable