package com.azat_sabirov.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azat_sabirov.movies.R
import com.azat_sabirov.movies.view.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}