package br.edu.unisep.exemplofb.app

import android.app.Application
import br.edu.unisep.exemplofb.koin.firebaseAuth
import br.edu.unisep.exemplofb.koin.repositoryModule
import br.edu.unisep.exemplofb.koin.viewModelModule
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FbApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Firebase.messaging.token.addOnSuccessListener { token ->
            println("Firebase Messaging Token: $token")
        }

        startKoin{
            androidLogger()
            androidContext(applicationContext)
            modules(
                firebaseAuth,
                repositoryModule,
                viewModelModule

            )
        }
    }

}