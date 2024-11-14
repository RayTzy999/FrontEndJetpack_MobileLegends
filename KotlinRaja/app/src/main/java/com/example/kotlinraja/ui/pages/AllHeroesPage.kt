package com.example.kotlinraja.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlinraja.models.Hero
import com.example.kotlinraja.ui.components.BoxImage
import com.example.kotlinraja.ui.components.SearchTextField

@Composable
fun AllHeroesPage(modifier: Modifier = Modifier, navController: NavController) {
    var query by remember { mutableStateOf("") }
    var heroList by remember { mutableStateOf(Hero.getAllHero()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        SearchTextField(
            query = query,
            onQueryChange = { query = it },
            onSearchClick = {
                heroList = Hero.searchHero(query)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(heroList.size) {index ->
                    val hero = heroList[index]
                    BoxImage(hero.imageUrl, hero.heroName, function = {
                        navController.navigate("detail_screen/${hero.id}")
                    })
                }
            }
        }
    }
}