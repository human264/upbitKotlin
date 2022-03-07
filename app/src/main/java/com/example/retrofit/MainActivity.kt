package com.example.retrofit

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.retrofit.RetrofitManager
import com.example.retrofit.uitls.RESPONSE_STATE
import com.example.retrofit.uitls.SEARCH_TYPE

class MainActivity : AppCompatActivity() {

    private var currentSearchType: SEARCH_TYPE = SEARCH_TYPE.PHOTO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")
        var btn_search = findViewById<Button>(R.id.btn_search)
        var search_tern_edit_text = findViewById<EditText>(R.id.search_term_edit_text)

        btn_search.setOnClickListener {
            RetrofitManager.instance.searchPhotos(searchTerm = search_tern_edit_text.toString(), completion = {
                    responseState, responseBody ->

                when(responseState) {
                    RESPONSE_STATE.OKAY -> {
                        Toast.makeText(this,"Api 호출 성공. :$responseBody", Toast.LENGTH_SHORT).show()

                    }

                    RESPONSE_STATE.FAIL -> {
                        Toast.makeText(this,"Api 호출 에러입니다.: $responseBody", Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }


    }

}