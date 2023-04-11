package com.example.intents_app_mark

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.LineNumberReader

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
            val takePictureintent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureintent, 1)
        }

        sharebutton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey its mark")
            startActivity(shareIntent)
        }

        mpesabutton.setOnClickListener {
            val simToolKitintent =applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitintent?.let { startActivity(it) }
        }

        callbutton.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL,)
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {


            }


        }





    }
}