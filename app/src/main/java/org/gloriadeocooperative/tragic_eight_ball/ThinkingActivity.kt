package org.gloriadeocooperative.tragic_eight_ball

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityThinkingBinding

class ThinkingActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityThinkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThinkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_thinking)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val theQuestion = intent.getStringExtra(EXTRA_QUESTION)
        lifecycleScope.launchWhenResumed {
            println("Hello World")
            delay(5000)
            println("Now what?")
            val sendQuestion=(Intent(this@ThinkingActivity, AnswerDisplayActivity::class.java))
            val answerSetName = intent.getStringExtra(EXTRA_ANSWERSET)

            sendQuestion.putExtra(EXTRA_QUESTION,theQuestion)
            sendQuestion.putExtra(EXTRA_ANSWERSET,answerSetName)
            startActivity(sendQuestion)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_thinking)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}