package org.gloriadeocooperative.tragic_eight_ball

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityIntroductionBinding

class IntroductionActivity : AppCompatActivity()
    {

    private lateinit var viewBinding: ActivityIntroductionBinding

    /**
     * A "hard" reference to the ShakeDetector instance, so that it will not be
     * garbage-collected too early.
     */
    private lateinit var shakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?)
        {
        super.onCreate(savedInstanceState)
        this.viewBinding = ActivityIntroductionBinding.inflate(this.layoutInflater)
        this.setContentView(this.viewBinding.root)

        // Create a demonstration/proof-of-concept ShakeDetector that simply
        // displays when a shake was detected.
        this.shakeDetector = ShakeDetector(this, this,
                    { count -> Toast.makeText(this, "Shake detected ${count}", Toast.LENGTH_SHORT).show() } )
        } // onCreate()

    } // class
