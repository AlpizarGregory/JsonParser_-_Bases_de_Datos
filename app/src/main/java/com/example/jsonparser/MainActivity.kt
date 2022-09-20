package com.example.jsonparser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.google.gson.Gson
import java.io.*

// Pruebas PrintWriter
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Prueba PrintWriter
//        main()

        // Lectura Json
        val gson = Gson()
        val json = loadData()
        val user = gson.fromJson(json, Database::class.java)

        user.users.get(4).let { Log.d("RESPUESTA", it.addresses.get(0)) }

    }

    // Prueba PrintWriter
    fun main() {
        val path = "microsoft.json"
        try {
            // Opción 1
//            val myFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),path)
//            val gson = Gson()
//            var dataBase = Database()
//            val user = User()
//            user.username = "Root"
//            user.password = "123"
//            user.fName = "Marco"
//            user.lName1 = "Rivera"
//            user.lName2 = "Meneses"
//            user.id = "2010784512"
//            user.email = "mrivera@itcr.ac.cr"
//            user.addresses.add("Cartago")
//            user.addresses.add("San Jose")
//            user.phoneNumbers.add("88888888")
//            dataBase.users.add(user)
//            val json:String = gson.toJson(dataBase)
//            myFile.writeText(json)

            // Opción 2
            val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),path)
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),path).printWriter().use {
                var dataBase = Database()
                val user = User()
                val user2 = User()
                val gson = Gson()
                user.username = "Root"
                user.password = "123"
                user.fName = "Marco"
                user.lName1 = "Rivera"
                user.lName2 = "Meneses"
                user.id = "2010784512"
                user.email = "mrivera@itcr.ac.cr"
                user.addresses.add("Cartago")
                user.addresses.add("San Jose")
                user.phoneNumbers.add("88888888")
                dataBase.users.add(user)
                user2.username = "Admin"
                user2.password = "admin"
                user2.fName = "Gregory"
                user2.lName1 = "Alpizar"
                user2.id = "2020039796"
                user2.email = "gregory.ac@estudiantec.cr"
                user2.addresses.add("Zarcero")
                user2.phoneNumbers.add("62192009")
                user2.phoneNumbers.add("62192008")
                dataBase.users.add(user2)
                val use = User()
                use.username = "God"
                use.password = "654"
                dataBase.users.add(use)
                dataBase.users.add(user)
                dataBase.users.add(user)
//                val json:String = gson.toJson(dataBase.users.get(0))
//                val jsn:String = gson.toJson(dataBase.users.get(1))
                it.println()
                it.println("{\"users\":[")
//                it.println("$json,")
//                it.println(jsn)
//                it.println("]")
//                it.println("}")
//                it.println(gson.toJson(dataBase.users))
                var count = 0
                for (i in dataBase.users) {
                    it.println(gson.toJson(dataBase.users.get(count)))
                    if (count < dataBase.users.size-1) {
                        it.println(",")
                    }
                    count++
                }
                it.println("]")
                it.println("}")
//                it.println()
//                it.println(gson.toJson(dataBase))

//                Log.d("RESPUESTA", file.toString())
            }

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
    fun loadData(): String {
        var tContents = ""
        val path = "microsoft.json"
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),path)



        try {
//            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),path).readText()
//            val stream = assets.open(inFile)
            val stream = FileInputStream(file)

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