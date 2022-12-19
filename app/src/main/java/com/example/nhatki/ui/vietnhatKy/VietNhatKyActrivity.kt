package com.example.nhatki.ui.vietnhatKy

import android.content.Intent
import com.example.nhatki.R
import com.example.nhatki.base.BaseActivity
import com.example.nhatki.data.AppDatabase
import com.example.nhatki.data.nhatky.entiry.NhatKy
import com.example.nhatki.utils.Utils
import com.example.nhatki.utils.dayMonthYear
import kotlinx.android.synthetic.main.activity_viet_nhat_ky.*
import kotlinx.coroutines.*

class VietNhatKyActrivity : BaseActivity(R.layout.activity_viet_nhat_ky) {
    private val database = AppDatabase.getDatabase()

    override fun initViews() {
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun initActions() {
        btnOk.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                database.nhatKyDao().insert(
                    NhatKy(
                        tenNhatKy = edtTennhatKy.text.toString(),
                        noiDung = edtNoiDUng.text.toString(),
                        ngayViet = Utils.currentDate().dayMonthYear()
                    )
                )
            }
            setResult(RESULT_OK, Intent())
            finish()
        }
    }

    companion object {
        const val KEY_NHATKY = "key_nhat_ky"
    }
}