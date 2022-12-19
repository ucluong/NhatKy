package com.example.nhatki.ui.login

import android.content.Intent
import android.os.Bundle
import com.example.nhatki.R
import com.example.nhatki.base.BaseActivity
import com.example.nhatki.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initActions()
    }

    override fun initActions() {
        btnOk.setOnClickListener {
            if (edtUserName.text.toString() == "admin" && edtPassword.text.toString() == "123456"){
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    override fun initViews() {

    }

    override fun initToolbar() {
    }
}