package com.example.nhatki.ui.vietnhatKy

import android.content.Intent
import com.example.nhatki.R
import com.example.nhatki.base.BaseActivity
import com.example.nhatki.data.AppDatabase
import com.example.nhatki.data.model.NhatKy
import com.example.nhatki.utils.Utils
import com.example.nhatki.utils.dayMonthYear
import kotlinx.android.synthetic.main.activity_viet_nhat_ky.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VietNhatKyActrivity : BaseActivity(R.layout.activity_viet_nhat_ky) {

    override fun initViews() {
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun initActions() {
        val database = AppDatabase.getDatabase(this)


        btnOk.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                database.nhatKyDao().insertAll(NhatKy(tenNhatKy = edtTennhatKy.text.toString(), noiDung = edtNoiDUng.text.toString(),ngayViet = Utils.currentDate().dayMonthYear()))
            }
//            val nhatKy = NhatKy(edtTennhatKy.text.toString(),edtNoiDUng.text.toString(), Utils.currentDate().dayMonthYear())
//            val intent = Intent().apply {
//                putExtra(KEY_NHATKY,nhatKy)
//            }
            setResult(RESULT_OK, Intent() )
            finish()
        }
    }

    companion object {
        const val KEY_NHATKY = "key_nhat_ky"
    }
}