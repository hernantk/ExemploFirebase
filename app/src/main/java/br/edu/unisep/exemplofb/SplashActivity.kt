package br.edu.unisep.exemplofb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.edu.unisep.exemplofb.databinding.ActivitySplashBinding
import br.edu.unisep.exemplofb.ui.login.LoginActivity
import br.edu.unisep.exemplofb.ui.register.RegisterActivity

class SplashActivity() : AppCompatActivity() {


    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(LoginActivity.newIntent(this))
            finish()
        },3000)

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, SplashActivity::class.java)
    }


}