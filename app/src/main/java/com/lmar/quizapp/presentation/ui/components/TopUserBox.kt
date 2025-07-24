package com.lmar.quizapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lmar.quizapp.R
import com.lmar.quizapp.domain.model.User

@Composable
fun TopUserBox(
    user: User,
    rank: Int,
    color: String,
    sizeDp: Int,
    crown: Boolean = false
) {
    Column(
        modifier = Modifier
            .width(sizeDp.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(220.dp)
                .width(sizeDp.dp)
        ) {
            val (imageRef, badgeRef, crownRef) = createRefs()
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(getDrawableId(user.pic))
                    .crossfade(true)
                    .build(),
                contentDescription = "User Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(sizeDp.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color(color.toColorInt()),
                        shape = CircleShape
                    )
                    .constrainAs(imageRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            if (crown) {
                Image(
                    painter = painterResource(R.drawable.crown),
                    contentDescription = "Crown",
                    modifier = Modifier
                        .constrainAs(crownRef) {
                            top.linkTo(imageRef.top)
                            bottom.linkTo(imageRef.top)
                            start.linkTo(imageRef.start)
                            end.linkTo(imageRef.end)
                        }
                )
            }

            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(color.toColorInt()))
                    .constrainAs(badgeRef) {
                        top.linkTo(imageRef.bottom)
                        bottom.linkTo(imageRef.bottom)
                        start.linkTo(imageRef.start)
                        end.linkTo(imageRef.end)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = rank.toString(),
                    color = Color.White,
                    fontSize = if (rank == 1) 20.sp else 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            Text(
                text = user.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = if (crown) 0.dp else 28.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .height(30.dp)
                .wrapContentWidth()
                .background(
                    brush = SolidColor(Color(color.toColorInt())),
                    shape = RoundedCornerShape(percent = 50)
                )
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.garnet),
                contentDescription = "Score Icon",
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = user.score.toString(),
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun TopThreeSection(
    users: List<User>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TopUserBox(
            user = users[2],
            rank = 3,
            color = "#AE844F",
            sizeDp = 100
        )

        TopUserBox(
            user = users[0],
            rank = 1,
            color = "#FFC107",
            sizeDp = 130,
            crown = true
        )

        TopUserBox(
            user = users[1],
            rank = 2,
            color = "#BFBFC0",
            sizeDp = 100
        )
    }
}

@Composable
fun getDrawableId(name: String): Int {
    return when(name) {
        "person1" -> R.drawable.person1
        "person2" -> R.drawable.person2
        "person3" -> R.drawable.person3
        "person4" -> R.drawable.person4
        "person5" -> R.drawable.person5
        "person6" -> R.drawable.person6
        "person7" -> R.drawable.person7
        "person8" -> R.drawable.person8
        "person9" -> R.drawable.person9
        else -> R.drawable.person7
    }
}

@Preview
@Composable
fun TopUserBoxPreview() {
    val user = User(
        id = 1,
        name = "John Doe",
        pic = "person1",
        score = 1000
    )

    TopUserBox(
        user = user,
        rank = 1,
        color = "#FFC107",
        sizeDp = 100,
        crown = true
    )
}

@Preview
@Composable
fun TopThreeSectionPreview() {
    val users = listOf(
        User(
            id = 1,
            name = "John Doe",
            pic = "person1",
            score = 1000
        ),
        User(
            id = 2,
            name = "User 2",
            pic = "person2",
            score = 900
        ),
        User(
            id = 3,
            name = "User 3",
            pic = "person3",
            score = 800
        )
    )

    TopThreeSection(users = users)
}