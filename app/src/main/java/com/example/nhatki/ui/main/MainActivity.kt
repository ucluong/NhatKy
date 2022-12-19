package com.example.nhatki.ui.main

import android.content.Intent
import com.example.nhatki.R
import com.example.nhatki.base.BaseActivity
import com.example.nhatki.data.AppDatabase
import com.example.nhatki.ui.chitietnhatky.ChiTietNhatKyActivity
import com.example.nhatki.ui.vietnhatKy.VietNhatKyActrivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_custom.*

class MainActivity : BaseActivity(R.layout.activity_main) {
    private val database = AppDatabase.getDatabase()

    private val nhatKyAdapter by lazy {
        NhatKyAdapter {
            //click 1 item sẽ nhảy vào đây.
            val intent = Intent(this, ChiTietNhatKyActivity::class.java).apply {
                putExtra(ChiTietNhatKyActivity.KEY_DATA, it)
            }
            startActivity(intent)

        }
    }


    override fun initToolbar() {
        tvTitle.text = "Danh sách nhật ký"
    }

    override fun initActions() {
        btnAddNhatKy.setOnClickListener {
            startActivity(Intent(this, VietNhatKyActrivity::class.java))
        }

    }

    override fun initViews() {

        database.nhatKyDao().getAll().observe(this){
            nhatKyAdapter.data = it.toMutableList()
        }

        rvNhatKy.apply {
            adapter = nhatKyAdapter
        }

    }


}