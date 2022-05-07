package io.github.janbarari.bargi.ui.login

import android.view.View
import androidx.navigation.Navigation
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.fragment.ViewModelFragment
import io.github.janbarari.bargi.databinding.MainLayoutBinding

class LoginFragment : ViewModelFragment<MainLayoutBinding, LoginViewModel>(
    R.layout.main_layout,
    LoginViewModel::class.java
) {

    override fun getBindingLayout(v: View): MainLayoutBinding {
        return MainLayoutBinding.bind(v)
    }

    override fun views() {
        binding.title.text = "LOGIN\nTO\nBARGI"
    }

    override fun listeners() {

        binding.nextScreen.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.goto_signup)
        }

    }

}