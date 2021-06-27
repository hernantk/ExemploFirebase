package br.edu.unisep.exemplofb.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import br.edu.unisep.exemplofb.databinding.ActivityLoginBinding
import br.edu.unisep.exemplofb.ui.home.HomeActivity
import br.edu.unisep.exemplofb.ui.register.RegisterActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity() : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNotRegistered.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

        binding.btnLogin.setOnClickListener {
            login(binding.etLogin.text.toString(),binding.etPassword.text.toString())
        }

    }

    private fun login(username:String,password:String){
        viewModel.loginAuth(username,password).addOnSuccessListener(::onLoginSuccess)
            .addOnFailureListener { error ->
                error.printStackTrace()
                Snackbar.make(binding.root, "Dados inválidos para o login!", Snackbar.LENGTH_LONG).show()
            }
    }

    private fun onLoginSuccess(result: AuthResult) {
        if (binding.swRememberUser.isChecked) {
            val prefs = getSharedPreferences("example-firebase-prefs", MODE_PRIVATE)
            prefs.edit {
                putString("user-id", result.user?.uid)
                putString("user-email", result.user?.email)
                putString("user-password", binding.etPassword.text.toString())
            }
        }

        startActivity(HomeActivity.newIntent(this))
        finish()
    }



    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

}