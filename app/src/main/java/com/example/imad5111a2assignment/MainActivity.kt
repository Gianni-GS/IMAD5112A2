package com.example.imadproject2

import android.R.attr.id
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
import com.example.imad5111a2assignment.R.*
import com.example.imad5111a2assignment.R.id.questionText
import com.example.imad5111a2assignment.ui.theme.IMAD5111A2AssignmentTheme
import org.w3c.dom.Text


class MainActivity : ComponentActivity() {
    private val questions = arrayOf(
        "Is Football the most popular sport in the world ?",
        "Does Manchester United have 13 Premier League titles ?",
        "Does Cristiano Ronaldo have 6 Ballon d'ors ?",
        "Did Argentina win the 2022 FIFA World Cup in Qatar ?",
        "Is Real Madrid from France ?",
    )

    private val answers = arrayOf(true, true, false, true, false)
    private var currentQuestion = 0
    private var score = 0
    private val feedbackList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showWelcomeScreen()
    }

    private fun showWelcomeScreen() {
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.btnStart)
        startButton.setOnClickListener {
            currentQuestion = 0
            score = 0
            feedbackList.clear()
            showQuestionScreen()
        }
    }


    private fun showQuestionScreen() {
        setContentView(R.layout.activity_question1)

        val questionText = findViewById<TextView>(R.id.questionText)
        val trueButton = findViewById<Button>(R.id.btnTrue)
        val falseButton = findViewById<Button>(R.id.btnFalse)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val nextButton = findViewById<Button>(R.id.btnNext)

        questionText.text = questions[currentQuestion]
        feedbackText.text = ""
        var answered = false

        trueButton.setOnClickListener {
            if (!answered) {
                checkAnswer(true, feedbackText)
                answered = true
            }

        }

        falseButton.setOnClickListener {
            if (!answered) {
                checkAnswer(true, feedbackText)
                answered = false
            }
        }

        nextButton.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                showQuestionScreen()

            } else {
                showScoreScreen()
            }
        }

    }

    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView) {
        val correct = answers[currentQuestion]
        if (userAnswer == correct) {
            feedbackText.text = "Correct"
            score++
            feedbackList.add("Q${currentQuestion + 1}:")
        } else {
            feedbackText.text = "Incorrect"
            feedbackList.add("Q${currentQuestion + 1}")

        }
    }

    private fun showScoreScreen() {
        setContentView(R.layout.activity_score)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val finalFeedback = findViewById<TextView>(R.id.finalFeedbackText)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExit)

        scoreText.text = "You scored $score out of ${questions.size}"
        finalFeedback.text = if (score >=3) "You definitely know much about football !" else " Better luck next time !"

        reviewButton.setOnClickListener {
            val facts = questions.mapIndexed { index, q ->
                "${index + 1}. $q\nAnswer: ${answers[index]}"
            }.joinToString("\n\n")
            Toast.makeText(this, facts, Toast.LENGTH_LONG).show()
        }

        exitButton.setOnClickListener {
            finish()
        }



    }


}

