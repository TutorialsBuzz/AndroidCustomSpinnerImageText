package com.tutorialsbuzz.customspinnerwithimagetext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val modelList: List<Model> = readFromAsset()

        val customDropDownAdapter = CustomDropDownAdapter(this, modelList)
        spinner04.adapter = customDropDownAdapter
    }

    private fun readFromAsset(): List<Model> {
        val file_name = "android_version.json"

        val bufferReader = application.assets.open(file_name).bufferedReader()

        val json_string = bufferReader.use {
            it.readText()
        }
        val gson = Gson()
        val modelList: List<Model> = gson.fromJson(json_string, Array<Model>::class.java).toList()
        return modelList
    }

}
