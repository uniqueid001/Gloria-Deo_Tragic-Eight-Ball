package org.gloriadeocooperative.tragic_eight_ball

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

import kotlin.math.sqrt

/**
 * Original Source: http://jasonmcreynolds.com/?p=388
 */
class ShakeDetector(
        private val context: Context,
        owner: LifecycleOwner,
        private val mListener: OnShakeListener
        )
    {
    fun interface OnShakeListener
        {
        fun onShake(count: Int)
        }

    private val lifecyleObserver = object: DefaultLifecycleObserver
        {
        override fun onCreate(owner:LifecycleOwner) { this@ShakeDetector.onCreate() }
        override fun onResume(owner:LifecycleOwner) { this@ShakeDetector.onResume() }
        override fun onPause(owner: LifecycleOwner) { this@ShakeDetector.onPause() }
        } // LifecycleObserver

    private val sensorEventListener = object: SensorEventListener
        {
        override fun onSensorChanged(event: SensorEvent) { this@ShakeDetector.onSensorChanged(event) }
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) { }
        } // SensorEventListener

    init
        {
        owner.getLifecycle().addObserver(this.lifecyleObserver)
        }


    private var mShakeTimestamp: Long = 0
    private var mShakeCount = 0

    private fun onSensorChanged(event: SensorEvent)
        {
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]
        val gX = x / SensorManager.GRAVITY_EARTH
        val gY = y / SensorManager.GRAVITY_EARTH
        val gZ = z / SensorManager.GRAVITY_EARTH

        // gForce will be close to 1 when there is no movement.
        val gForce = sqrt(gX * gX + gY * gY + gZ * gZ)
        if (gForce > SHAKE_THRESHOLD_GRAVITY)
            {
            val now = System.currentTimeMillis()
            // ignore shake events too close to each other (500ms)
            if (mShakeTimestamp + SHAKE_SLOP_TIME_MS > now)
                { return }

            // reset the shake count after 3 seconds of no shakes
            if (mShakeTimestamp + SHAKE_COUNT_RESET_TIME_MS < now)
                { mShakeCount = 0 }

            mShakeTimestamp = now
            mShakeCount++
            mListener.onShake(mShakeCount)
            }
        } // onSensorChanged()

    companion object
        {
        /*
	 * The gForce that is necessary to register as shake.
	 * Must be greater than 1G (one earth gravity unit).
	 * You can install "G-Force", by Blake La Pierre
	 * from the Google Play Store and run it to see how
	 *  many G's it takes to register a shake
	 */
        private const val SHAKE_THRESHOLD_GRAVITY = 2.7f
        private const val SHAKE_SLOP_TIME_MS = 500
        private const val SHAKE_COUNT_RESET_TIME_MS = 3000
        } // companion object


    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometer: Sensor

    private fun onCreate()
        {
        this.mSensorManager = this@ShakeDetector.context.getSystemService(SensorManager::class.java)
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }

    private fun onResume()
        {
        this.mSensorManager.registerListener(this@ShakeDetector.sensorEventListener,
                                             this.mAccelerometer,
                                             SensorManager.SENSOR_DELAY_UI)
        }

    private fun onPause()
        {
        this.mSensorManager.unregisterListener(this@ShakeDetector.sensorEventListener)
        }

    } // class ShakeDetector

