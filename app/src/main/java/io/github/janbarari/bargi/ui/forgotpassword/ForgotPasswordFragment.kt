package io.github.janbarari.bargi.ui.forgotpassword

import android.view.View
import androidx.navigation.Navigation
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.core.fragment.ViewModelFragment
import io.github.janbarari.bargi.databinding.MainLayoutBinding

class ForgotPasswordFragment : ViewModelFragment<MainLayoutBinding, ForgotPasswordViewModel>(
    R.layout.main_layout,
    ForgotPasswordViewModel::class.java
) {

    override fun getBindingLayout(v: View): MainLayoutBinding {
        return MainLayoutBinding.bind(v)
    }

    override fun views() {
        binding.title.text = "FORGOT\nMY\nPASSWORD"
    }

    override fun listeners() {

        binding.nextScreen.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.goto_login)
        }

    }

}