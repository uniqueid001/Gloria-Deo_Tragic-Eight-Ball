package org.gloriadeocooperative.tragic_eight_ball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

class thinking2_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thinking2)
        lifecycleScope.launchWhenResumed {
            println("Hello World")
            delay(5000)
            println("Now what?")
            val theQuestion = intent.getStringExtra(EXTRA_QUESTION)


                val answerSetName = intent.getStringExtra(EXTRA_ANSWERSET)

            val notintent: Intent = Intent(this@thinking2_activity, AnswerDisplayActivity::class.java)
            val randomnumber = (1..3).random()
            notintent.putExtra(EXTRA_ANSWERNUMBER,randomnumber)
            notintent.putExtra(EXTRA_QUESTION,theQuestion)
            notintent.putExtra(EXTRA_ANSWERSET,answerSetName)
            startActivity(notintent)

        }
    }
}