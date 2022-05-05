package org.gloriadeocooperative.tragic_eight_ball

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.gloriadeocooperative.tragic_eight_ball.databinding.ActivityUserAnswersBinding
import android.widget.Toast


class UserAnswersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserAnswersBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.binding = ActivityUserAnswersBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        val use = binding.useanswerset
        val save = binding.saveanswerset
        var catName = ""
        var ans1 = ""
        var ans2 = ""
        var ans3 = ""
        var ans4 = ""
        var ans5 = ""
        var ans6 = ""
        var ans7 = ""
        var ans8 = ""
        var userPrefName: String? = catName

        // Should go into main activity. New answer activity will assume it's built...
        val categoryPref = getSharedPreferences("categories", Context.MODE_PRIVATE)


        save.setOnClickListener {
            var catName = binding.CatName.text.toString().replace(" ", "")
            var ans1 = binding.UserAnswer1.text
            var ans2 = binding.UserAnswer2.text
            var ans3 = binding.UserAnswer3.text
            var ans4 = binding.UserAnswer4.text
            var ans5 = binding.UserAnswer5.text
            var ans6 = binding.UserAnswer6.text
            var ans7 = binding.UserAnswer7.text
            var ans8 = binding.UserAnswer8.text
            var userPrefName: String? = catName

            val categoryPref = TragicEightBallApplication.instance.answerSetDAO.loadCategories()

            val userPref = getSharedPreferences("$userPrefName", Context.MODE_PRIVATE)
            with(userPref.edit()) {
                putString("1", "$ans1")
                putString("2", "$ans2")
                putString("3", "$ans3")
                putString("4", "$ans4")
                putString("5", "$ans5")
                putString("6", "$ans6")
                putString("7", "$ans7")
                putString("8", "$ans8")
                apply()
            }

            with(categoryPref.edit()){
                // will figure out the proper key count
                val sharedPreferenceIds = categoryPref.all.map { it.key } //returns List<String>
                var valNum = sharedPreferenceIds.size + 1
                var keyValue = "$valNum"
                putString("$keyValue", "$userPrefName")
                apply()
                val toast = Toast.makeText(applicationContext,valNum.toString(),Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        use.setOnClickListener {
            val intent = Intent(this, AskQuestion2::class.java)
            intent.putExtra("newPrefName", "$userPrefName")
            //               intent.putExtra("question","what is the deal?")

            startActivity(intent)
        }
    }
}
