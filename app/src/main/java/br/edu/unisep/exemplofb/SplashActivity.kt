package br.edu.unisep.exemplofb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.edu.unisep.exemplofb.databinding.ActivitySplashBinding
import br.edu.unisep.exemplofb.ui.home.HomeActivity
import br.edu.unisep.exemplofb.ui.login.LoginActivity
import br.edu.unisep.exemplofb.ui.login.LoginViewModel
import br.edu.unisep.exemplofb.ui.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity() : AppCompatActivity() {


    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    private val viewModel: LoginViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({

            if(checkUserSaved()){
                startActivity(HomeActivity.newIntent(this))
            }else{
                startActivity(LoginActivity.newIntent(this))
            }

            finish()
        },3000)

    }

    private fun checkUserSaved() : Boolean{
        val prefs = getSharedPreferences("example-firebase-prefs", MODE_PRIVATE)
        if (prefs.contains("user-id")) {
            val username = prefs.getString("user-email", "") ?: ""
            val password = prefs.getString("user-password", "") ?: ""

            viewModel.loginAuth(username,password)

            return true

        }
        else{
            return false
        }

    }

}