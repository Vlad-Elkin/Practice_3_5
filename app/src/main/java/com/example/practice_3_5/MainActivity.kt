package com.example.practice_3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val blueFragment:BlueFragment = BlueFragment()
        val redFragment:RedFragment = RedFragment()
        val caption:Button = findViewById(R.id.caption)
        supportFragmentManager.beginTransaction().add(R.id.fragment1,redFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment2,blueFragment).commit()
        caption.setOnClickListener {
            with(supportFragmentManager){
                val fragment1=when(findFragmentById(R.id.fragment1)){
                    redFragment->blueFragment
                    blueFragment->redFragment
                    else -> {}
                }
                beginTransaction().replace(R.id.fragment1, fragment1 as Fragment).commit()
                val fragment2 = when(findFragmentById(R.id.fragment2)){
                    redFragment->blueFragment
                    blueFragment->redFragment
                    else -> {}
                }
                beginTransaction().replace(R.id.fragment2, fragment2 as Fragment).commit()
            }

        }
    }
}