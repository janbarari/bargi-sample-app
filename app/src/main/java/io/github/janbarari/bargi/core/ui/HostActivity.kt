package io.github.janbarari.bargi.core.ui

import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.activity.ViewModelActivity
import io.github.janbarari.bargi.databinding.MainLayoutBinding

@AndroidEntryPoint
class HostActivity: ViewModelActivity<MainLayoutBinding, HostViewModel>(
    R.layout.main_layout,
    HostViewModel::class.java
) {

    override fun getLayoutBinding(v: View): MainLayoutBinding {
        return MainLayoutBinding.bind(v)
    }

    override fun onActivityCreated() {
        super.onActivityCreated()

    }

}
