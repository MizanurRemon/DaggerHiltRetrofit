package com.example.daggerhiltretrofit.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.daggerhiltretrofit.Model.Post_response
import com.example.daggerhiltretrofit.Repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject
constructor(private val postRepository: PostRepository) : ViewModel() {

    val response: LiveData<List<Post_response>> = postRepository.getPost().catch { e ->
        Log.d(
            "dataxx",
            "ERROR ${e.message} "
        )
    }.asLiveData()
}