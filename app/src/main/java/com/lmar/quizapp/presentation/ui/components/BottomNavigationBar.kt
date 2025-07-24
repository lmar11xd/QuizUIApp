package com.lmar.quizapp.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.lmar.quizapp.R

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = colorResource(id = R.color.white)
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.home) },
            icon = {
                Icon(painter = painterResource(id = R.drawable.bottom_btn1), contentDescription = "Home")
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.board) },
            icon = {
                Icon(painter = painterResource(id = R.drawable.bottom_btn2), contentDescription = "Home")
            },
            label = { Text("Board") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.favorites) },
            icon = {
                Icon(painter = painterResource(id = R.drawable.bottom_btn3), contentDescription = "Home")
            },
            label = { Text("Favorites") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.profile) },
            icon = {
                Icon(painter = painterResource(id = R.drawable.bottom_btn4), contentDescription = "Home")
            },
            label = { Text("Profile") }
        )
    }
}