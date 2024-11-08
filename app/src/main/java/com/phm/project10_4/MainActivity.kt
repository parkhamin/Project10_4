package com.phm.project10_4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.phm.project10_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        {
            if (it.resultCode == 1001){
                val rxIntent: Intent? = it.data
                val rxSum: Int? = rxIntent?.getIntExtra("Sum", 0)
                Toast.makeText(this@MainActivity, "Sum= " + rxSum?.toString(), Toast.LENGTH_LONG).show()
            } else{
                val rxIntent: Intent? = it.data
                val rxSub: Int? = rxIntent?.getIntExtra("Sub", 0)
                Toast.makeText(this@MainActivity, "Sub= " + rxSub?.toString(), Toast.LENGTH_LONG).show()
            }
        }

        bindingMain.btnAdd.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val mIntent: Intent = Intent(this@MainActivity, AddActivity::class.java)
                mIntent.putExtra("Num1", Integer.parseInt(bindingMain.edtNum1.text.toString()))
                mIntent.putExtra("Num2", Integer.parseInt(bindingMain.edtNum2.text.toString()))
                requestLauncher.launch(mIntent)
            }
        })

        bindingMain.btnSub.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val mIntent: Intent = Intent(this@MainActivity, SubtractActivity::class.java)
                mIntent.putExtra("Num1", Integer.parseInt(bindingMain.edtNum1.text.toString()))
                mIntent.putExtra("Num2", Integer.parseInt(bindingMain.edtNum2.text.toString()))
                requestLauncher.launch(mIntent)
            }
        })
    }
}