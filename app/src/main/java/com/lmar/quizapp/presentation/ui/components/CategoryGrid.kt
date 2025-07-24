package com.lmar.quizapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lmar.quizapp.R

@Composable
@Preview
fun CategoryGrid() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCard(
                title = "Science",
                iconResource = R.drawable.cat1,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 12.dp, top = 16.dp)
            )

            CategoryCard(
                title = "History",
                iconResource = R.drawable.cat2,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 12.dp, top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCard(
                title = "Sport",
                iconResource = R.drawable.cat3,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 12.dp, top = 16.dp)
            )

            CategoryCard(
                title = "Art",
                iconResource = R.drawable.cat4,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 12.dp, top = 16.dp)
            )
        }
    }
}

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String,
    iconResource: Int
) {
    Row(
        modifier = modifier
            .height(height = 55.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorResource(id = R.color.white))
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(iconResource),
            contentDescription = "resource",
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.padding(start = 16.dp))

        Text(
            text = title,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}