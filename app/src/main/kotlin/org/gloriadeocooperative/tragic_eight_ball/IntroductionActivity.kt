package org.gloriadeocooperative.tragic_eight_ball

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IntroductionActivity : AppCompatActivity()
    {
    private lateinit var mShakeDetector: LifecycleAwareShakeDetector

    override fun onCreate(savedInstanceState: Bundle?)
        {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        // ShakeDetector initialization
        this.mShakeDetector = LifecycleAwareShakeDetector(this, this, this::handleShakeEvent)
        } // onCreate()

    fun handleShakeEvent(count: Int)
        {
        Toast.makeText(this, "Shake detected ${count}", Toast.LENGTH_SHORT).show()
        }
    } // class
