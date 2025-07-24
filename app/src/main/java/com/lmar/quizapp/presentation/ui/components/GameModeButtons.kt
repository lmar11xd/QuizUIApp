package com.lmar.quizapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmar.quizapp.R

@Composable
fun GameModeButton(
    onSinglePlayerClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(145.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GameButton(
            modifier = Modifier.weight(1f),
            backgroundColor = R.color.blue,
            iconResource = R.drawable.btn1,
            text = "Create Quiz",
            onClick = onSinglePlayerClick
        )

        Spacer(modifier = Modifier.width(12.dp))

        GameButton(
            modifier = Modifier.weight(1f),
            backgroundColor = R.color.purple,
            iconResource = R.drawable.btn2,
            text = "Single Player",
            onClick = onSinglePlayerClick
        )

        Spacer(modifier = Modifier.width(12.dp))

        GameButton(
            modifier = Modifier.weight(1f),
            backgroundColor = R.color.orange,
            iconResource = R.drawable.btn3,
            text = "Multi Player",
            onClick = onSinglePlayerClick
        )
    }
}

@Composable
fun GameButton(
    modifier: Modifier = Modifier,
    backgroundColor: Int,
    iconResource: Int,
    text: String,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() }
            )
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorResource(id = backgroundColor))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconResource),
            contentDescription = "resource",
            modifier = Modifier.fillMaxWidth().height(60.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = text,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
private fun GameModeButtonPreview() {
    GameModeButton()
}