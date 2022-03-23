package org.gloriadeocooperative.tragic_eight_ball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityUserAnswersBinding

class UserAnswersActivity : AppCompatActivity()
{
    private lateinit var viewBinding: ActivityUserAnswersBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        this.viewBinding = ActivityUserAnswersBinding.inflate(this.layoutInflater)
        setContentView(this.viewBinding.root)
    }

}