package io.github.janbarari.bargi.ui.signup

import android.view.View
import androidx.navigation.Navigation
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.fragment.ViewModelFragment
import io.github.janbarari.bargi.databinding.MainLayoutBinding

class SignupFragment  : ViewModelFragment<MainLayoutBinding, SignupViewModel>(
    R.layout.main_layout,
    SignupViewModel::class.java
) {

    override fun getBindingLayout(v: View): MainLayoutBinding {
        return MainLayoutBinding.bind(v)
    }

    override fun views() {
        binding.title.text = "SIGNUP\nIN\nBARGI"
    }

    override fun listeners() {

        binding.nextScreen.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.goto_forgot_my_password)
        }

    }

}