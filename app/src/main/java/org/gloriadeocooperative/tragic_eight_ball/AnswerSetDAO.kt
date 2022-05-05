package org.gloriadeocooperative.tragic_eight_ball

import android.content.Context
import android.content.SharedPreferences

/**
 * This object is a "Data Access Object" (DAO)
 */
class AnswerSetDAO(private val context: Context)
    {

    fun initializeBuiltInAnswerSets()
        {
        val categoryPref = loadCategories()

        if (!categoryPref.contains("sassy"))
            {
            with(categoryPref.edit()) {
                putString("1", "sassy")
                putString("2", "tragic")
                apply()
                }

            with(loadAnswerSet("sassy").edit()) {
                putString("1", "Try learning English and ask again")
                putString("2", "Yeah baby!")
                putString("3", "Yeah no")
                apply()
                }

            with(loadAnswerSet("tragic").edit()) {
                putString("1", "What is the point, ask again")
                putString("2", "I mean anything is possible")
                putString("3", "Sorry buddy")
                apply()
                }
            }
        } // initializeBuiltInAnswerSets()


    fun loadCategories(): SharedPreferences
        = context.getSharedPreferences("categories", Context.MODE_PRIVATE)

    fun loadAnswerSet(name: String): SharedPreferences
        {
        if (name.isEmpty() || name.isBlank())
            { throw IllegalArgumentException("Name must not be empty or blank") }
        if (name == "categories")
            { throw IllegalArgumentException("Name 'categories' is reserved") }
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
        }

    } // class AnswerSetDAO
