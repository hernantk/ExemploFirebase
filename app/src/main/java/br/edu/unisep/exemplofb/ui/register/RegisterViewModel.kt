package br.edu.unisep.exemplofb.ui.register

import androidx.lifecycle.ViewModel
import br.edu.unisep.exemplofb.domain.repository.Repository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class RegisterViewModel(private val repository: Repository): ViewModel() {

    fun saveNewUser(username:String,password:String) :Task<AuthResult> {
        return repository.saveNewUser(username, password)

    }
}