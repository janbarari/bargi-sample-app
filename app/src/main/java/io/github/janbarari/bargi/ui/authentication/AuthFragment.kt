package io.github.janbarari.bargi.ui.authentication

import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.fragment.ViewModelFragment
import io.github.janbarari.bargi.databinding.MainLayoutBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

open class AuthFragment : ViewModelFragment<MainLayoutBinding, AuthViewModel>(
    R.layout.main_layout,
    AuthViewModel::class.java
) {

    private lateinit var connectionStatusDisposable: Disposable
    private var _connectionStatus: MutableLiveData<Boolean> = MutableLiveData(false)
    val connectionStatus: LiveData<Boolean> = _connectionStatus

    override fun getBindingLayout(v: View): MainLayoutBinding {
        return MainLayoutBinding.bind(v)
    }

    override fun onStart() {
        super.onStart()
        startRandomStateGenerator()
    }

    override fun onStop() {
        super.onStop()
        stopRandomStateGenerator()
    }

    private fun startRandomStateGenerator() {
        connectionStatusDisposable = Observable.interval(2, 5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val randomResult = Random().nextBoolean()
                viewModel.isConnected = randomResult
                _connectionStatus.value = randomResult
            }
    }

    private fun stopRandomStateGenerator() {
        connectionStatusDisposable.dispose()
    }

    fun showConnectionPopup(isConnected: Boolean) {
        Observable.range(0, 2)
            .concatMap { i: Int ->
                Observable.just(i).delay(1, TimeUnit.SECONDS)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { i: Int ->
                when (i) {
                    0 -> {
                        binding.connectionStatus.visibility = View.VISIBLE
                        binding.connectionStatus.background = ColorDrawable(requireContext().getColor(R.color.orange))
                        binding.connectionStatus.text = getString(R.string.connecting)
                    }
                    1 -> {
                        if (isConnected) {
                            binding.connectionStatus.visibility = View.VISIBLE
                            binding.connectionStatus.background = ColorDrawable(requireContext().getColor(R.color.green))
                            binding.connectionStatus.text = getString(R.string.connection_established)
                        } else {
                            binding.connectionStatus.visibility = View.VISIBLE
                            binding.connectionStatus.background = ColorDrawable(requireContext().getColor(R.color.red))
                            binding.connectionStatus.text = getString(R.string.connection_failed)
                        }
                    }
                }
            }
            .subscribe()
    }

}