package br.edu.unisep.exemplofb.koin

import br.edu.unisep.exemplofb.domain.repository.Repository
import br.edu.unisep.exemplofb.ui.home.HomeViewModel
import br.edu.unisep.exemplofb.ui.login.LoginViewModel
import br.edu.unisep.exemplofb.ui.register.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val firebaseAuth = module {
    single{FirebaseAuth.getInstance()}
}

val repositoryModule = module {
    single{Repository(get())}
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get())}
    viewModel { HomeViewModel(get())}
}