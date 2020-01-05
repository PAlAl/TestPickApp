package com.example.test.presentation.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AppToolbarFragment.OnAppToolbarTitleChangeListener {

    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onAppToolbarTitleChange(title: String) {
        supportActionBar?.title = title
    }
}
