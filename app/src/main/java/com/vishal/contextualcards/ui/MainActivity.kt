package com.vishal.contextualcards.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vishal.contextualcards.R

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}