package org.gloriadeocooperative.tragic_eight_ball

import android.app.Application

class TragicEightBallApplication: Application()
    {
    val answerSetDAO by lazy { AnswerSetDAO(applicationContext) }

    override fun onCreate()
        {
        super.onCreate()
        instance = this
        answerSetDAO.initializeBuiltInAnswerSets()
        } // onCreate()

    companion object {
        lateinit var instance: TragicEightBallApplication
            private set

        } // companion object
    } // class