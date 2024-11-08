package com.phm.project10_4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.phm.project10_4.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private  lateinit var bindingAdd: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingAdd = ActivityAddBinding.inflate(layoutInflater)
        setContentView(bindingAdd.root)

        val rxIntent: Intent = getIntent()
        val num1: Int = rxIntent.getIntExtra("Num1", 0)
        val num2: Int = rxIntent.getIntExtra("Num2", 0)
        val sum: Int = num1 + num2

        bindingAdd.btnReturn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val outIntent: Intent = Intent(this@AddActivity, MainActivity::class.java)
                outIntent.putExtra("Sum", sum)
                setResult(1001, outIntent)
                finish()
            }
        })
    }
}