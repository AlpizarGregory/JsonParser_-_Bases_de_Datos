package com.example.jsonparser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import java.io.File
import java.io.IOException

// Pruebas PrintWriter
import java.io.FileWriter
import java.io.PrintWriter
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Prueba PrintWriter
        main()

        // Lectura Json
//        val gson = Gson()
//        val json = loadData("personas.json")
//        val persona = gson.fromJson(json, Response::class.java)

//        Log.d("RESPUESTA", persona.grupo)
//        persona.personas?.get(0)?.let { Log.d("RESPUESTA", it.nombre) }

    }

    // Prueba PrintWriter
    fun main() {
        val companies = Company("Microsoft", 182268,
            listOf("California", "Washington", "Virginia")
        )

        val path = "microsoft.json"
        try {
            // Opción 1
            val myFile = File(path)
            val gson = Gson()
            val jsonString = gson.toJson(companies)
            myFile.writeText(jsonString)

            // Opción 2
//            File(path).printWriter().use {
//                val gson = Gson()
//                val jsonString = gson.toJson(companies)
//                it.println(jsonString)
//                Log.d("RESPUESTA", jsonString)
//            }

            // Opción 3
//            PrintWriter(FileWriter(path)).use {
//                val gson = Gson()
//                val jsonString = gson.toJson(companies)
//                it.write(jsonString)
//            }
        } catch (e: Exception) {
            Log.d("RESPUESTA", "Error")
            e.printStackTrace()
        }
    }

    // Lectura Json
    fun loadData(inFile: String): String {
        var tContents = ""

        try {
            val stream = assets.open(inFile)

            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContents = String(buffer)
        } catch (e: IOException) {
            // Handle Exceptions here
        }

        return tContents
    }
}