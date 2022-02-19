package org.gloriadeocooperative.tragic_eight_ball

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IntroductionActivity : AppCompatActivity()
    {
    /**
     * A "hard" reference to the ShakeDetector instance, so that it will not be
     * garbage-collected too early.
     */
    private lateinit var shakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?)
        {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        // Create a demonstration/proof-of-concept ShakeDetector that simply
        // displays when a shake was detected.
        this.shakeDetector = ShakeDetector(this, this,
                    { count -> Toast.makeText(this, "Shake detected ${count}", Toast.LENGTH_SHORT).show() } )
        } // onCreate()

    } // class
