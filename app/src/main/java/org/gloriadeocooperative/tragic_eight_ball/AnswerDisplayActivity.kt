package org.gloriadeocooperative.tragic_eight_ball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnswerDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_display)
        val questionDisplay= findViewById<TextView>(R.id.Question)
        val theQuestion = intent.getStringExtra(EXTRA_QUESTION)
        questionDisplay.setText("$theQuestion")
    }
}
