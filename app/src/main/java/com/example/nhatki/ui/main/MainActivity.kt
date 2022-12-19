package com.example.nhatki.ui.main

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import com.example.nhatki.R
import com.example.nhatki.base.BaseActivity
import com.example.nhatki.data.AppDatabase
import com.example.nhatki.data.model.NhatKy
import com.example.nhatki.ui.chitietnhatky.ChiTietNhatKyActivity
import com.example.nhatki.ui.vietnhatKy.VietNhatKyActrivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_custom.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    private var listNhatKy : LiveData<List<NhatKy>>? = null

    private val nhatKyAdapter by lazy { NhatKyAdapter{
        //click 1 item sẽ nhảy vào đây.
        val intent = Intent(this, ChiTietNhatKyActivity::class.java).apply {
            putExtra(ChiTietNhatKyActivity.KEY_DATA, it)
        }
        startActivity(intent)

    } }


    @OptIn(DelicateCoroutinesApi::class)
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
           val dta = GlobalScope.async {
                val database = AppDatabase.getDatabase(this@MainActivity)
               val data = database.nhatKyDao().getAll().toMutableList()
               nhatKyAdapter.data = data.await()

           }

        }
    }
//  thay đổi tên ds
    override fun initToolbar() {
        tvTitle.text = "Danh sách nhật ký"
    }

    override fun initActions() {
        btnAddNhatKy.setOnClickListener {
            startForResult.launch(Intent(this, VietNhatKyActrivity::class.java))
        }

    }

    override fun initViews() {
        val database = AppDatabase.getDatabase(this@MainActivity)

        GlobalScope.launch {
            nhatKyAdapter.data =  database.nhatKyDao().getAll().toMutableList()
        }

        rvNhatKy.apply {
            adapter = nhatKyAdapter
        }

    }



}