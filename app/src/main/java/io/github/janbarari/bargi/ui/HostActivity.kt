package io.github.janbarari.bargi.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.AndroidEntryPoint
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.activity.ViewModelActivity
import io.github.janbarari.bargi.databinding.HostActivityBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.reactivestreams.Subscription
import java.util.*
import java.util.concurrent.Flow
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class HostActivity: ViewModelActivity<HostActivityBinding, HostViewModel>(
    R.layout.host_activity,
    HostViewModel::class.java
) {

    override fun getLayoutBinding(v: View): HostActivityBinding {
        return HostActivityBinding.bind(v)
    }

}
