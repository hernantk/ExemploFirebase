package br.edu.unisep.exemplofb.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.unisep.exemplofb.R
import br.edu.unisep.exemplofb.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    private val viewModel :RegisterViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener { saveNewUser() }
    }

    private fun saveNewUser() {
        val username = binding.etLogin.text.toString()
        val password = binding.etPassword.text.toString()

        viewModel.saveNewUser(username, password)
            .addOnSuccessListener {
                Snackbar.make(binding.root, "Usuário cadastrado com sucesso!", Snackbar.LENGTH_LONG).show()
            }
            .addOnFailureListener { error ->
                error.printStackTrace()
                Snackbar.make(binding.root, "Erro ao cadastrar usuário!", Snackbar.LENGTH_LONG).show()
            }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, RegisterActivity::class.java)
    }

}