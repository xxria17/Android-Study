package com.dhxxn.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("!!!MainActivity!!!", "1. onCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.d("!!!MainActivity!!!", "2. onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("!!!MainActivity!!!", "3. onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("!!!MainActivity!!!", "4. onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("!!!MainActivity!!!", "5. onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("!!!MainActivity!!!", "6. onDestroy")
    }
}