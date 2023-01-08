package com.example.fixedlabelleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {

    lateinit var image : ImageView
    lateinit var info : TextView
    lateinit var brand : TextView
    lateinit var product_name : TextView
    lateinit var howToUse : TextView
    lateinit var ingredients : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setFullScreen(window)
        lightStatusBar(window)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        val gambar = intent.getStringExtra("logo")
        val ini_brand = intent.getStringExtra("brand")
        val productname = intent.getStringExtra("product_name")
        val infone = intent.getStringExtra("info")
        val caraPakai = intent.getStringExtra("how_to_use")
        val kandungan = intent.getStringExtra("ingredients")

        image = findViewById(R.id.img_mediheal_dtl)
        info = findViewById(R.id.supabase_info)
        howToUse = findViewById(R.id.supabase_how2use)
        ingredients = findViewById(R.id.supabase_ingredients)
        product_name = findViewById(R.id.txt_name_product_dtl)
        brand = findViewById(R.id.txt_brand_dtl)

        Glide.with(this).load(gambar).into(image)
        info.text = infone
        howToUse.text = caraPakai
        ingredients.text = kandungan
        product_name.text = productname
        brand.text = ini_brand




    }
}