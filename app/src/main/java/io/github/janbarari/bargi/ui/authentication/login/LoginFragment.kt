package io.github.janbarari.bargi.ui.authentication.login

import android.widget.Toast
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import io.github.janbarari.bargi.R
import io.github.janbarari.bargi.ui.authentication.AuthFragment

@AndroidEntryPoint
class LoginFragment : AuthFragment() {

    override fun views() {
        binding.title.text = "LOGIN\nTO\nBARGI"
    }

    override fun observers() {
        connectionStatus.observe(viewLifecycleOwner) { isConnected ->
            showConnectionPopup(isConnected)
        }

        viewModel.sendMessageResponse.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Message Sent!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun listeners() {

        binding.nextScreen.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.goto_signup)
        }

        binding.checkConnectionButton.setOnClickListener {
            viewModel.sendMessage()
        }

    }

}