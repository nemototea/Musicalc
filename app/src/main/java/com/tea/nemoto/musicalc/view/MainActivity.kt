package com.tea.nemoto.musicalc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.viewmodel.MainActivityViewModel
import com.tea.nemoto.musicalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBindingの場合はDataBindingUtilを利用する
        //setContentView(R.layout.activity_main)

        // ViewModelを設定する
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = MainActivityViewModel()

        if (savedInstanceState == null) {
            // 計算結果TextView部のFragment
            val resultAreaFragment = ResultAreaFragment()
            // 数字・演算子ボタン部のFragment
            val buttonAreaFragment = ButtonAreaFragment()

            // ActivityにFragmentを追加する
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, resultAreaFragment)
                .add(R.id.container, buttonAreaFragment)
                .commit()
        }
    }
}
