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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kotlinraja.R
import com.example.kotlinraja.models.Hero
import com.example.kotlinraja.ui.components.BoxImage
import com.example.kotlinraja.ui.components.CustomText
import com.example.kotlinraja.ui.components.DisabledTextField
import com.example.kotlinraja.ui.components.HeadingText

@Composable
fun ProfilePage(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoxImage(R.drawable.profil, "Foto Profil")
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                HeadingText("RajaTzy")
                CustomText(
                    text = "razaashariyazid@gmail.com",
                    color = Color.Gray
                )
                CustomText(
                    text = "\"Infokan Permabaran\"",
                    color = Color(0xFF1976D2)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        DisabledTextField("Perguruan Tinggi", "Universitas Labuhanbatu")
        DisabledTextField("Asal Jurusan", "Sistem Informasi")
    }
}