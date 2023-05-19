package com.example.project.products


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.project.R
import com.example.project.databinding.ActivityAddItemBinding
import com.example.project.products.view_model.MyViewModel


class AddItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_item)
        viewModel = MyViewModel(application)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initializeObservers()

        binding.btnBack.setOnClickListener{
            finish()
        }
   }

    private fun initializeObservers(){
        viewModel.saveProductCallback.observe(this){
            if(it){
                finish()
                return@observe
            }

            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
    }
}