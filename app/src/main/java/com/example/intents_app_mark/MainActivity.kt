package com.example.intents_app_mark

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var smsbutton: Button
    private lateinit var emailbutton: Button
    private lateinit var camerabutton: Button
    private lateinit var sharebutton: Button
    private lateinit var mpesabutton: Button
    private lateinit var callbutton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsbutton = findViewById(R.id.btnsms)
        emailbutton = findViewById(R.id.btnemail)
        camerabutton = findViewById(R.id.btncamera)
        sharebutton = findViewById(R.id.btnshare)
        mpesabutton = findViewById(R.id.btnmpesa)
        callbutton = findViewById(R.id.btncall)


        smsbutton.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0795869932")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Vipi Boss")
            startActivity(intent)
        }

        emailbutton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "marcwafula635@gmail.com",null))
            intent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            intent.putExtra(Intent.EXTRA_TEXT, "Hello my name is Mark Wafula")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        camerabutton.setOnClickListener {
            var takePictureintent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureintent, 1)

        }





    }
}