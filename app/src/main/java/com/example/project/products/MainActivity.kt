package com.example.project.products


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.products.adapter.ProductAdapter
import com.example.project.R
import com.example.project.databinding.ActivityMainBinding
import com.example.project.products.view_model.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var productAdapter: ProductAdapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initializeViews()
        initializeObserver()

        viewModel.loadProduct()
    }

    private fun initializeViews(){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }

        binding.savebtn.setOnClickListener{
            val intent = Intent(this, AddItemActivity::class.java)
            intent.putExtra("EXTRA_KEY","extra_value")
            startActivity(intent)
            Toast.makeText(this, "goods", Toast.LENGTH_SHORT).show()

            viewModel.loadProduct()
        }
    }

    private fun initializeObserver(){
        viewModel.getProducts().observe(this) { products ->
            productAdapter.submitList(products)
        }
    }
}