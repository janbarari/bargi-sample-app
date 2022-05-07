package io.github.janbarari.bargi.ui

import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.activity.ViewModelActivity
import io.github.janbarari.bargi.databinding.HostActivityBinding

@AndroidEntryPoint
class HostActivity: ViewModelActivity<HostActivityBinding, HostViewModel>(
    R.layout.host_activity,
    HostViewModel::class.java
) {

    override fun getLayoutBinding(v: View): HostActivityBinding {
        return HostActivityBinding.bind(v)
    }

}
