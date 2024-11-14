package com.example.kotlinraja.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlinraja.models.Hero
import com.example.kotlinraja.ui.components.TextLabel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(modifier: Modifier = Modifier, navController: NavController, id: Int) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Detail Hero") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF1976D2),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), id = id)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, id: Int){
    val getDataById = Hero.show(id)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray),

            contentAlignment = Alignment.Center
        ) {
            val painter = painterResource(id = getDataById[0].imageUrl)
            Image(
                painter = painter,
                contentDescription = "Image detail hero ${getDataById[0].heroName}",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
        ) {
            items(getDataById.size) {index ->
                val hero = getDataById[index]

                TextLabel("ID", hero.id.toString())
                TextLabel("Hero Name", hero.heroName)
                TextLabel("Role", hero.role)
                TextLabel("Recommended Lane", hero.recommendedLane)
                TextLabel("Status", hero.status.toString())
                TextLabel("Difficult", hero.difficult.toString())
            }
        }
    }
}