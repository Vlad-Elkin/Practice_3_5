package com.example.practice_3_5

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var swap:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().add(R.id.fragment1,RedFragment()).commit()
            supportFragmentManager.beginTransaction().add(R.id.fragment2,BlueFragment()).commit()
        }

        findViewById<Button>(R.id.caption).setOnClickListener{
            if (swap){
                supportFragmentManager.beginTransaction().replace(R.id.fragment1,BlueFragment()).commit()
                supportFragmentManager.beginTransaction().replace(R.id.fragment2,RedFragment()).commit()
            }
            else{
                supportFragmentManager.beginTransaction().replace(R.id.fragment2,BlueFragment()).commit()
                supportFragmentManager.beginTransaction().replace(R.id.fragment1,RedFragment()).commit()
            }
            swap=!swap
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("swap",swap)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState.getBoolean("swap")){
            supportFragmentManager.beginTransaction().add(R.id.fragment2,BlueFragment()).commit()
            supportFragmentManager.beginTransaction().add(R.id.fragment1,RedFragment()).commit()
        }
        else{
            supportFragmentManager.beginTransaction().add(R.id.fragment1,BlueFragment()).commit()
            supportFragmentManager.beginTransaction().add(R.id.fragment2,RedFragment()).commit()
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
}