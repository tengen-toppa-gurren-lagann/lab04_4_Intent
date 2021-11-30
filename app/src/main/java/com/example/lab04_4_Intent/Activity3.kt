package com.example.lab04_4_Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val btnToActivity2 = findViewById<View>(R.id.bnToSecond)
        btnToActivity2.setOnClickListener { finish() }

        val btnToActivity1 = findViewById<View>(R.id.bnToFirst)
        btnToActivity1.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val navBottom : BottomNavigationView = findViewById<View>(R.id.nav_view) as BottomNavigationView
        navBottom.setOnNavigationItemReselectedListener {
            startActivity(Intent(applicationContext, ActivityAbout::class.java))
        }

        //Включаем кнопку "Назад" (Navigation Up) в верхней строке приложения
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}