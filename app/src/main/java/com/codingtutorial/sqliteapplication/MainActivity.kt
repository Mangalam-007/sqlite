package com.codingtutorial.sqliteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this
        var btn:Button=findViewById(R.id.btn_insert)
        var btnr:Button=findViewById(R.id.btn_read)
        var na:EditText=findViewById(R.id.etvName)
        var tvResult:TextView=findViewById(R.id.tvResult)
        var ag:EditText=findViewById(R.id.etvAge)
        var db = DataBaseHandler(context)
        btn.setOnClickListener {
            if(na.text.toString().length>0 && ag.text.toString().length>0)
            {
                var user:User = User(na.text.toString(),(ag.text.toString()).toInt())
                db.insertData(user)
            }
            else
            {
                Toast.makeText(context,"Please fill all data",Toast.LENGTH_SHORT).show()
            }
        }
        btnr.setOnClickListener ({
            var data = db.readData()
            tvResult.text =""
            for(i in 0..(data.size-1)){
                tvResult.append(" "+ data.get(i).id.toString()+ " "+data.get(i).name + " " + data.get(i).age.toString()+"\n")
            }
        })
    }
}