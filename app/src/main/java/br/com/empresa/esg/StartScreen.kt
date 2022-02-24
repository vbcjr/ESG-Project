package br.com.empresa.esg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_start_screen)

        val button: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button)

        button.setOnClickListener{
        val i = Intent(this, FormLogin2::class.java)
        startActivity(i)
        }
    }
}