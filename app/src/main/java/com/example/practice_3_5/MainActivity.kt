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
        val caption:Button = findViewById(R.id.caption)
        supportFragmentManager.beginTransaction().add(R.id.fragment1,RedFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment2,BlueFragment()).commit()
        var swap = false
        caption.setOnClickListener {
            val fragment1:Fragment
            val fragment2:Fragment
            if (swap){
                fragment1=RedFragment()
                fragment2=BlueFragment()
                swap = false
            }else{
                fragment1=BlueFragment()
                fragment2=RedFragment()
                swap = true
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment1,fragment1).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fragment2,fragment2).commit()
        }
    }
}