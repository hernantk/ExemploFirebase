package br.edu.unisep.exemplofb.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Repository(private val fbAuth: FirebaseAuth) {


    fun saveNewUser(username:String,password:String) : Task<AuthResult> {
        return fbAuth.createUserWithEmailAndPassword(username, password)

    }

    fun loginAuth(username: String, password: String) :Task<AuthResult> {
        return fbAuth.signInWithEmailAndPassword(username, password)
    }

    fun logout(){
        fbAuth.signOut()
    }

    fun getCurrentUser() : String{
        return fbAuth.currentUser?.email.toString()
    }
}