package org.gloriadeocooperative.tragic_eight_ball

import android.app.Application

class TragicEightBallApplication: Application()
    {

    override fun onCreate()
        {
        super.onCreate()
        initializeBuiltInAnswerSets()
        } // onCreate()

    private fun initializeBuiltInAnswerSets()
        {
        println("TODO")
        }

    } // class