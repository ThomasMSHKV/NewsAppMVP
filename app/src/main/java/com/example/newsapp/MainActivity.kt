package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.view.NewsListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, NewsListFragment())
                .commit()
        }
    }
