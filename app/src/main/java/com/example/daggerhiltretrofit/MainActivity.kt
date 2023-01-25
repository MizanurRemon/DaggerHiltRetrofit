package com.example.daggerhiltretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.daggerhiltretrofit.Network.checkConnect
import com.example.daggerhiltretrofit.Utils.ShowToast
import com.example.daggerhiltretrofit.ViewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        checkNetwork()


        postViewModel.response.observe(this, Observer {
            Log.d("dataxx", "response: ${it[0].toString()}")
        })

    }

    private fun checkNetwork() {
        lifecycleScope.launchWhenStarted {
            checkConnect().collect {
                if (it) {
                    ShowToast.successToast(this@MainActivity, "Internet connected")
                } else {
                    ShowToast.successToast(this@MainActivity, "Connection Error")
                }
            }
        }
    }

    private fun initView() {

    }
}