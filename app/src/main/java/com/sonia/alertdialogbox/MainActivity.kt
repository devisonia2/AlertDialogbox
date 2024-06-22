package com.sonia.alertdialogbox

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var enteranynumber: TextView? = null
    var etnum: EditText? = null
    var btnperformcalculation: Button? = null
    var array = arrayOf("press + to add$(etnum),press- to subtract$(etnum),press 0 to reset")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        enteranynumber = findViewById(R.id.number)
        etnum = findViewById(R.id.etnum)
        btnperformcalculation = findViewById(R.id.btncalculation)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
                btnperformcalculation?.setOnClickListener {
            if (etnum?.text?.trim().isNullOrEmpty()){
                etnum?.error="Enter any number"
            }else{
                var num=etnum?.text.toString().trim()
                AlertDialog.Builder(this).apply {
                    setTitle("Hello")
                    setMessage("Press ADD to add ${num} \nPress SUB to subtract ${num} \nPress 0 to reset")
                    setCancelable(false)
                    setPositiveButton("Add${num}"){_,_->
                        etnum?.setText("${num.toInt()+num.toInt()}")
                    }
                    setNegativeButton("Sub${num}"){_,_->
                        etnum?.setText("${num.toInt()-num.toInt()}")
                    }
                    setNeutralButton("0"){_,_->
                        etnum?.setText("0")
                    }
                    show()
                }
            }
        }
    }


    }