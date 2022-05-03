package org.gloriadeocooperative.tragic_eight_ball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

        //this.setSupportActionBar(binding.toolbar2)

        // Create a demonstration/proof-of-concept ShakeDetector that simply
        // displays when a shake was detected.
        this.shakeDetector = ShakeDetector(this, this) {
            val theQuestion = binding.inputTextView.text
            val intent = Intent(this@AskQuestion2, ThinkingActivity::class.java)
            intent.putExtra("question", theQuestion)

            if (theQuestion.length > 0) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext, "you must ask a question to proceed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            //if shake detected and question is there move to thinking activity
            // else make toast saying "input question to continue."
        }
    } //oncreate

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbarmenu, menu)
        return true
    } //optionsMenu

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.toolbarMenu -> {
                val intent = Intent(this@AskQuestion2,
                    UserAnswersActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    } // ItemSelected

    }
