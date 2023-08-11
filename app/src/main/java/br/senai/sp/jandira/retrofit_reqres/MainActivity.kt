package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //BOTÃO DE GET
        findViewById<Button>(R.id.btnGET).setOnClickListener ()  {
            //Log.e("TESTE XML", " '*click'; AÍ, ME ERRA CARA! ")
            getUserByID()
        }

        //BOTÃO DE PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener ()  {
            Log.e("TESTE XML", " '*click'; AÍ, ME ERRA CARA! ")
        }

        //BOTÃO DE DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener ()  {
            Log.e("TESTE XML", " '*click'; AÍ, ME ERRA CARA! ")
        }

        //BOTÃO DE POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener ()  {
            Log.e("TESTE XML", " '*click'; AÍ, ME ERRA CARA! ")
        }

    }

    private fun getUserByID() {
        lifecycleScope.launch {
            val result = apiService.getUserByID("2")

            if (result.isSuccessful){
                Log.e("TESTE XML GET", " '*click'; TÓ OQ TU QUER! ${result.body()?.data}")
            } else {
                Log.e("TESTE XML GET", " '*click'; SAI FORA, TO SEM MONEY! ${result.message()}")
            }
        }
    }
}