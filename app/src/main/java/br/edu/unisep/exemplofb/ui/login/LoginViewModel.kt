package br.edu.unisep.exemplofb.ui.login

import android.content.Context
import android.content.Intent
import android.net.sip.SipSession
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import br.edu.unisep.exemplofb.databinding.ActivityLoginBinding
import br.edu.unisep.exemplofb.domain.repository.Repository
import br.edu.unisep.exemplofb.ui.home.HomeActivity
import br.edu.unisep.exemplofb.ui.register.RegisterActivity
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel(private val repository: Repository) : ViewModel() {



    fun loginAuth(username: String, password: String) :Task<AuthResult> {
        return repository.loginAuth(username, password)

    }



}