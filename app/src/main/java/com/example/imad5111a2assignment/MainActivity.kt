package com.example.imad5111a2assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imad5111a2assignment.ui.theme.IMAD5111A2AssignmentTheme

class MainActivity : ComponentActivity() {
    private val questions = arrayOf(
        "Is Football the most popular sport in the world ?",
        "Does Manchester United have 13 Premier League titles ?",
        "Does Cristiano Ronaldo have 6 Ballon d'ors ?",
        "Did Argentina win the 2022 FIFA World Cup in Qatar ?",
        "Is Real Madrid from France ?",
    )
