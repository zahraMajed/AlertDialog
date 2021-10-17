package com.example.alertdialog

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var btnShow:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShow=findViewById(R.id.btnShow)

        btnShow.setOnClickListener(){
            AlertDailog()
        }

    }

    fun AlertDailog(){

        var U_Text:String=""

        //build dialog in this activity
        val dialogBuilder = AlertDialog.Builder(this)

        /********set dialog title********/
        dialogBuilder.setTitle("Dialog")

        /********to set msg to user if you want********/
        dialogBuilder.setMessage("Welcome to my app!")

        /********to set view inside the dialog (such as edit text)********/
        //1) create variable of view type you want

        val userText=EditText(this)
        //2) design your view
        userText.setHint("Enter some text")
        //3)finally you should add the view to the builder
        dialogBuilder.setView(userText)


        /********to set button inside the dialog********/
        dialogBuilder.setPositiveButton("Get text",DialogInterface.OnClickListener(){
            //this require (DialogInterface!, Int) → Unit
            // so we should wirte dialog, which -> or any two name
                dialog, which ->
            U_Text = userText.text.toString()
        } )

        dialogBuilder.setNegativeButton("Go",DialogInterface.OnClickListener(){
            //this require (DialogInterface!, Int) → Unit
            // so we should wirte dialog, which -> or any two name
                dialog, which ->
            intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("text",userText.text.toString())
            startActivity(intent)
        } )

        /********show the dialog, so important after you finish the building********/
        dialogBuilder.create()
        dialogBuilder.show()
    }
}
