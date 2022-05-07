package io.github.janbarari.bargi.ui.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.janbarari.bargi.core.viewmodel.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(): BaseViewModel() {

    var isConnected: Boolean = false
    private var _sendMessageResponse: MutableLiveData<Boolean> = MutableLiveData()
    val sendMessageResponse: LiveData<Boolean> = _sendMessageResponse

    fun sendMessage() {
        if (isConnected) {
            _sendMessageResponse.value = true
        }
    }


}