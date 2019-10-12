package com.smarthead.msgshareapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.smarthead.msgshareapp.R
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity:: class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        //Concept of inheritance: Super method accesses Super class method onCreate.
        //The onCreate method is a mandatory method included in Android Class libraries by default, 
        //and implies the entry point into an application.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            //code
            Log.i(TAG,"Instance recorded.")
            showToast("Instance recorded.")

        }
        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()


            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)

        }

        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            //Intent allows communication with the system as well as other apps. For instance, to send mail, 
            //I would not incorporate the entire mail functionality in my app, but call out to apps like Gmail to help me with the same.
            intent.action = Intent.ACTION_SEND //What the intent does
            intent.putExtra(Intent.EXTRA_TEXT, message) //Intent also displays a message
            intent.type = "text/plain" //Type of message sent by intent
            startActivity(Intent.createChooser(intent, "Share to : "))
        }
        
        //setOnClickListener method gets activated when a button is clicked
        btnRecyclerViewDemo.setOnClickListener {
            
            //The HobbiesActivity, which is a class file, is called when the buttom is clicked
            val intent = Intent(this, HobbiesActivity::class.java)

            startActivity(intent)
        }
    }

}
