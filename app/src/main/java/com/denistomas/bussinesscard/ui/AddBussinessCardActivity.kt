package com.denistomas.bussinesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.denistomas.bussinesscard.App
import com.denistomas.bussinesscard.R
import com.denistomas.bussinesscard.data.BusinessCard
import com.denistomas.bussinesscard.databinding.ActivityAddBussinessCardBinding

class AddBussinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBussinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                company_name = binding.tilCompany.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                personalizedBackground = binding.tilColor.editText?.text.toString()

            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}