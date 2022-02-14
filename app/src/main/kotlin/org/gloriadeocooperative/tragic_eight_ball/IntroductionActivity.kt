package org.gloriadeocooperative.tragic_eight_ball

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.gloriadeocooperative.tragic_eight_ball.ShakeDetector.OnShakeListener


class IntroductionActivity : AppCompatActivity()
    {
    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometer: Sensor
    private lateinit var mShakeDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?)
        {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

            // ShakeDetector initialization
//            this.mSensorManager = this.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            this.mSensorManager = this.getSystemService(SensorManager::class.java)
            this.mAccelerometer = this.mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            this.mShakeDetector = ShakeDetector(
                object : OnShakeListener
                    {
                    override fun onShake(count: Int)
                        {
                        handleShakeEvent(count)
                        }
                   })
        } // onCreate()

        override fun onResume()
            {
            super.onResume()
            // Add the following line to register the Session Manager Listener onResume()
            this.mSensorManager.registerListener(this.mShakeDetector,
                                                 this.mAccelerometer,
                                                 SensorManager.SENSOR_DELAY_UI)
            }

        override fun onPause()
            {
            // Add the following line to unregister the Sensor Manager onPause
            this.mSensorManager.unregisterListener(this.mShakeDetector)
            super.onPause()
            }

    fun handleShakeEvent(count: Int)
        {
        Toast.makeText(this, "Shake detected ${count}", Toast.LENGTH_SHORT).show()
        }
    } // class
