package com.example.fixedlabelleproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fixedlabelleproject.API.RetrofitHelper
import com.example.fixedlabelleproject.hypeProductRecycler.AdapterHypeProduct
import com.example.fixedlabelleproject.hypeProductRecycler.ApiHypeProduct
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter : AdapterHypeProduct

    val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inh1YXdqbGFramNrdGN6eHZhaW1vIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzE5NDk0ODgsImV4cCI6MTk4NzUyNTQ4OH0.GJQ0y2G4zZuaNLIvDdnBdqyLRMuDUHJ6otjo5Xui9ZI"
    val token = "Bearer $apiKey"
    val api = RetrofitHelper.getInstance().create(ApiHypeProduct::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFullScreen(window)
        lightStatusBar(window)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        recyclerView = findViewById(R.id.rv_Main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        CoroutineScope(Dispatchers.Main).launch {
            val data = ArrayList<Model>()
            val response = api.get(token = token, apiKey = apiKey)
            response.body()?.forEach {
                data.add(
                    Model(
                        Imgrc = it.imgrc,
                        Brand = it.brand,
                        How_to_use = it.how_to_use,
                        Info = it.info,
                        Ingredients = it.ingredients,
                        Logo = it.logo,
                        Product_name = it.product_name,
                    )
                )
            }
            adapter = AdapterHypeProduct(data)
            recyclerView.adapter = adapter
        }

    }
}