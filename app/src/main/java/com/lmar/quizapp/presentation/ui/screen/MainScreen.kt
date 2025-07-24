package com.lmar.quizapp.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmar.quizapp.R
import com.lmar.quizapp.presentation.ui.components.Banner
import com.lmar.quizapp.presentation.ui.components.BottomNavigationBar
import com.lmar.quizapp.presentation.ui.components.CategoryGrid
import com.lmar.quizapp.presentation.ui.components.CategoryHeader
import com.lmar.quizapp.presentation.ui.components.GameModeButton
import com.lmar.quizapp.presentation.ui.components.TopUserSection

@Composable
@Preview
fun MainScreen(
    onSinglePlayerClick: () -> Unit = {},
    onBoardClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.grey))
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                TopUserSection()

                Spacer(modifier = Modifier.height(16.dp))

                GameModeButton(onSinglePlayerClick = onSinglePlayerClick)

                Spacer(modifier = Modifier.height(32.dp))

                CategoryHeader()
                CategoryGrid()
                Banner()
            }
        }

        BottomNavigationBar(
            onItemSelected = { itemId ->
                if (itemId == R.id.board) {
                    onBoardClick()
                }
            }
        )

    }
}