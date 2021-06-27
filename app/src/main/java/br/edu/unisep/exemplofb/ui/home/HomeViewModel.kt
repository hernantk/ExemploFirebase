package br.edu.unisep.exemplofb.ui.home

import androidx.lifecycle.ViewModel
import br.edu.unisep.exemplofb.domain.repository.Repository
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel(private val repository: Repository):ViewModel() {


    fun logout(){
        repository.logout()
    }

    fun getCurrentUser():String{
        return repository.getCurrentUser()
    }



}