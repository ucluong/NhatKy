package com.example.nhatki.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar_custom.*

abstract class BaseActivity(layoutId: Int) : AppCompatActivity(layoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initActions()
        initToolbar()

    }

    open fun initToolbar() {
        imvBack?.setOnClickListener {
            onBackPressed()
            //nếu trong fragment thì là requeiActivity().onBackPressed()
        }
    }
    //khởi tạo views
    abstract fun initViews()
    //xử lý sự kiện nút bấm
    abstract fun initActions()
}