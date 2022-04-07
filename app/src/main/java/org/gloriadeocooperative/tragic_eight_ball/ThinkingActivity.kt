package org.gloriadeocooperative.tragic_eight_ball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityAskQuestion2Binding
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityThinkingBinding

class ThinkingActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityThinkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityThinkingBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val intent = intent
        val theQuestion =intent.getStringExtra("question")
binding.theQuestionTextView.text = theQuestion
    }
}