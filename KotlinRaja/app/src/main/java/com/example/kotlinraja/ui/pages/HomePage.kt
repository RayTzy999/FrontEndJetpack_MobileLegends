package com.example.kotlinraja.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlinraja.models.Hero
import com.example.kotlinraja.ui.components.BoxImage
import com.example.kotlinraja.ui.components.CustomText
import com.example.kotlinraja.ui.components.HeadingText

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController) {
    val filterMeta = Hero.filterMeta()
    val filterNonMeta = Hero.filterNonMeta()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        HeadingText("Meta Heroes")
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(filterMeta.size) {index ->
                val hero = filterMeta[index]
                BoxImage(hero.imageUrl, hero.heroName, function = {
                    navController.navigate("detail_screen/${hero.id}")
                })
            }
        }

        HeadingText("Non-Meta Heroes")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            items(filterNonMeta.size) {index ->
                val hero = filterNonMeta[index]
                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BoxImage(hero.imageUrl, hero.heroName, function = {
                        navController.navigate("detail_screen/${hero.id}")
                    })
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        CustomText(hero.heroName)
                        CustomText(
                            text = hero.difficult.toString(),
                            color = Color(0xFF1976D2)
                        )
                        CustomText(
                            text = hero.role + " | " + hero.recommendedLane,
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}