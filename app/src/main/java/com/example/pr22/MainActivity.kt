package com.example.pr22

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.pr22.R


class MainActivity : AppCompatActivity(), Fragment.OnSelectedButtonListener {
    private var mIsDynamic = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragment2 = fragmentManager
            .findFragmentById(R.id.fragment2) as Fragment2?
        mIsDynamic = fragment2 == null || !fragment2.isInLayout
        Toast.makeText(applicationContext, mIsDynamic.toString() + "", Toast.LENGTH_SHORT).show()
    }
    override fun onButtonSelected(buttonIndex: Int) {

        val fragmentManager: FragmentManager = supportFragmentManager


        val fragment2 = fragmentManager.findFragmentById(R.id.fragment2) as Fragment2?


        if (fragment2 == null || !fragment2.isVisible) {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("buttonIndex", buttonIndex)
            startActivity(intent)
        } else {

            fragment2.setDescription(buttonIndex)
        }
    }
}