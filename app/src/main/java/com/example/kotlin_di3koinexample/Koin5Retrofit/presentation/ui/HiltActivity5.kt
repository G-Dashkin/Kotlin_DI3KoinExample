package com.example.kotlin_di3koinexample.Koin5Retrofit.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_di3koinexample.Koin5Retrofit.adapter.PhotoAdapter
import com.example.kotlin_di3koinexample.Koin5Retrofit.presentation.viewmodels.MainViewModel
import com.example.kotlin_di3koinexample.Koin5Retrofit.utils.DataStatus
import com.example.kotlin_di3koinexample.databinding.ActivityHilt5Binding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HiltActivity5 : AppCompatActivity() {

    private var _binding: ActivityHilt5Binding? = null
    private val binding get() = _binding

    private val viewModel: MainViewModel by inject()
    private val photosAdapter by lazy { PhotoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = ActivityHilt5Binding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setupRecyclerView()

        lifecycleScope.launch {

            binding.apply {
                viewModel.getPhoto("flower")
                viewModel.photoList.observe(this@HiltActivity5) {
                    when (it.status) {
                        DataStatus.Status.LOADING -> {
                            showProgressBar(false)
                        }
                        DataStatus.Status.SUCCESS -> {
                            showProgressBar(true)
                            photosAdapter.differ.submitList(it.data)
                        }

                        DataStatus.Status.ERROR -> {
                            showProgressBar(false)
                            Toast.makeText(
                                this@HiltActivity5,
                                "There is something wrong!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

    }

    private fun showProgressBar(isShown: Boolean) {
        binding!!.apply {
            if (isShown) {
                rvPhoto.visibility = View.VISIBLE
                pBarLoading.visibility = View.GONE
            } else {
                rvPhoto.visibility = View.GONE
                pBarLoading.visibility = View.VISIBLE
            }
        }
    }

    private fun setupRecyclerView() {
        binding!!.rvPhoto.apply {
            layoutManager = LinearLayoutManager(this@HiltActivity5)
            adapter = photosAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}