package com.lmar.quizapp.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.lmar.quizapp.R
import com.lmar.quizapp.domain.model.User
import com.lmar.quizapp.presentation.ui.components.LeaderRow
import com.lmar.quizapp.presentation.ui.components.OnBackRow
import com.lmar.quizapp.presentation.ui.components.TopThreeSection

@Composable
fun LeaderScreen(
    topUsers: List<User>,
    otherUsers: List<User>,
    onBack: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey)),
        verticalArrangement = Arrangement.Top
    ) {
        item {
            OnBackRow(onBack = onBack)
        }

        item {
            TopThreeSection(topUsers)
        }

        itemsIndexed(otherUsers) { index, user ->
            LeaderRow(user = user, rank = index + 4)
        }
    }
}

@Preview
@Composable
fun LeaderScreenPreview() {
    val topUsers = listOf(
        User(1, "Sophia", "person1", 4850),
        User(2, "Daniel", "person2", 4560),
        User(3, "James", "person3", 3873),
    )

    val otherUsers = listOf(
        User(4, "John Smith", "person4", 3250),
        User(5, "Emily Johnson", "person5", 3015),
        User(6, "Sarah Wilson", "person6", 2970),
    )

    LeaderScreen(topUsers = topUsers, otherUsers = otherUsers, onBack = {})
}