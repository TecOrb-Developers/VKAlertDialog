package com.vkp.vkalertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vkp.vkalertdialog.databinding.ActivityMainBinding
import com.vkpal.alertlibrary.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.btnSuccess.setOnClickListener {
            VKAlertDialog.build(this)
                .title("Success", titleColor = R.color.black)
                .subtitle(
                    "You have successfully logged in.",
                    color = com.google.android.material.R.color.material_blue_grey_800
                )
                .type(type = Type.SUCCESS)
                .position(Positions.CENTER)
                //.background(R.drawable.layout_rounded_grey)
                .onPositive("OK", shouldIDismissOnClick = true) {
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel", shouldIDismissOnClick = true) {
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
                .setCancelable(true)
        }

        binding.btnError.setOnClickListener {
            VKAlertDialog.build(this)
                .title("Error!", titleColor = R.color.black)
                .subtitle(
                    "This is the bad request for getting the category.",
                    color = com.google.android.material.R.color.material_blue_grey_800
                )
                .type(type = Type.ERROR)
                .position(Positions.CENTER)
                .onPositive("Ok", shouldIDismissOnClick = true) {
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel", shouldIDismissOnClick = true) {
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
                .setCancelable(true)
        }


        binding.btnInfo.setOnClickListener {
            VKAlertDialog.build(this)
                .title("Information", titleColor = R.color.black)
                .subtitle(
                    "This is the best information for you.",
                    color = com.google.android.material.R.color.material_blue_grey_800
                )
                .type(type = Type.INFO)
                .position(Positions.CENTER)
                .onPositive("Ok", shouldIDismissOnClick = true) {
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                }
                .onNegative("Cancel", shouldIDismissOnClick = true) {
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .hideNegativeButton(hide = false)
                .setCancelable(true)
        }
    }
}