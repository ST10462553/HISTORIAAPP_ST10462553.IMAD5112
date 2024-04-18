package com.example.historia_historyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor() : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity()
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            val url = "https://en.wikipedia.org/wiki/Amy_Winehouse "
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }
        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
            }

            private val ageToFamousPerson = mapOf(
                27 to "Amy Winehouse",
                21 to "Juice Wrld",
                29 to "Lebo Mathosa",
                39 to "Marilyn Monroe",
                37 to "Vincent Van Gogh",
                95 to "Nelson Mandela",
                81 to "Eartha Kitt",
                48 to "James Dean",
                52 to "John Lennon",
                67 to "Isaac Newton"
                )
            private lateinit var age: EditText
            private lateinit var generateHistory: Button
            private lateinit var clearButton: Button
            private lateinit var resultTextView: TextView

            @SuppressLint("SetTextI18n")
             override fun onCreate(
                savedInstanceState: Bundle?,
                persistentState: PersistableBundle?
            ) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                age = findViewById(R.id.EnterAge)
                generateHistory = findViewById(R.id.Button)
                clearButton = findViewById(R.id.button2)
                resultTextView = findViewById(R.id.TextView)

                generateHistory.setOnClickListener {
                    val ageInput = null
                    val age = ageInput.text.toString().toIntOrNull()
                    if (age != null) {
                        val famousPerson = ageToFamousPerson[age]
                        if (famousPerson != null) {
                            resultTextView.text =
                                "At the age of $age, $famousPerson passed away."
                        } else {
                            resultTextView.text =
                                "Sorry, no famous person found at the age of $age."
                        }
                    } else {
                        resultTextView.text = "Please enter a valid age."
                    }
                }
                clearButton.setOnClickListener {
                    val ageInput = null
                    ageInput.text.clear()
                    resultTextView.text = ""

                }
            }
        }
    }
}
