package org.gloriadeocooperative.tragic_eight_ball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityAskQuestion2Binding

class AskQuestion2 : AppCompatActivity() {

    private lateinit var binding: ActivityAskQuestion2Binding
    private lateinit var shakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityAskQuestion2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val theQuestion = binding.inputTextView.text

        // Create a demonstration/proof-of-concept ShakeDetector that simply
        // displays when a shake was detected.
        this.shakeDetector = ShakeDetector(this, this
        ) {
            val intent = Intent(this@AskQuestion2, ThinkingActivity ::class.java)
            intent.putExtra("question",theQuestion)
            startActivity(intent)
        }

    //count ->
          //Toast.makeText(this, "Shake detected ${count}", Toast.LENGTH_SHORT).show()
//                        viewBinding.centralTextView.setText( "Detected ${count} shakes in a row" )
       //
    }
}

