package com.sonu.jetpackcomposeexamples.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sonu.jetpackcomposeexamples.BottomMenuContent
import com.sonu.jetpackcomposeexamples.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression", "Diarrhea"))
            CurrentMeditation()
            Box(modifier = Modifier.fillMaxSize()) {
                BottomMenu(
                    items = listOf(
                        BottomMenuContent("Home", R.drawable.ic_home),
                        BottomMenuContent("Meditate", R.drawable.ic_bubble),
                        BottomMenuContent("Sleep", R.drawable.ic_moon),
                        BottomMenuContent("Music", R.drawable.ic_music),
                        BottomMenuContent("Profile", R.drawable.ic_profile),
                    ),
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }

}

@Composable
fun GreetingSection(
    name: String = "Sonu"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column {
            Text(
                text = "Good morning $name",
                style = MaterialTheme.typography.h2
            )

            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {

                Text(text = chips[it], color = TextWhite)
            }
        }
    }

}


@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 50.dp)
        ) {
            Text(
                text = "Daily  Thought",
                style = MaterialTheme.typography.h2,
                color = TextWhite
            )

            Text(
                text = "Mediation  .  3-10  min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(DeepBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}


@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    selectedItem: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(selectedItem)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {

        items.forEachIndexed { index, menuItem ->
            BottomMenuItem(
                item = menuItem,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                inactiveTextColor = inactiveTextColor,
                activeTextColor = activeTextColor,
            ) {
                selectedItemIndex = index
            }

        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.itemId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)
    }

}