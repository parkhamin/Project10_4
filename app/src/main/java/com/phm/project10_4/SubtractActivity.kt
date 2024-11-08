package com.phm.project10_4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.phm.project10_4.databinding.ActivitySubtractBinding

class SubtractActivity: AppCompatActivity() {
    private lateinit var bindingSub : ActivitySubtractBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingSub = ActivitySubtractBinding.inflate(layoutInflater)
        setContentView(bindingSub.root)

        val rxIntent: Intent = getIntent()
        val num1: Int = rxIntent.getIntExtra("Num1", 0)
        val num2: Int = rxIntent.getIntExtra("Num2", 0)
        val sub: Int = num1 - num2

        bindingSub.btnReturn2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val outIntent: Intent = Intent(this@SubtractActivity, MainActivity::class.java)
                outIntent.putExtra("Sub", sub)
                setResult(1002, outIntent)
                finish()
            }
        })
    }
}