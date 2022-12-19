package com.example.nhatki.ui.chitietnhatky

import com.example.nhatki.R
import com.example.nhatki.base.BaseActivity
import com.example.nhatki.data.nhatky.entiry.NhatKy
import kotlinx.android.synthetic.main.activity_chitiet_nhatky.*

class ChiTietNhatKyActivity : BaseActivity(R.layout.activity_chitiet_nhatky) {
    override fun initViews() {
      val nhatKy =  intent.getSerializableExtra(KEY_DATA) as? NhatKy

        tvName.text = nhatKy?.tenNhatKy
        tvDes.text = nhatKy?.noiDung
    }

    override fun initActions() {
    }

    companion object {
        const val KEY_DATA = "keydata"
    }
}