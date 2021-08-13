package com.example.myloginkmm.feature.login.domain.usecase

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.feature.login.data.repository.LoginRepository
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.base.BaseUseCase

class LoginUseCaseImplcase(
    val loginRepository: LoginRepository
): BaseUseCase<AuthInitiateRequest, AuthInitiateResponse>() {

    override suspend fun run(): Response<AuthInitiateResponse> {
        request?.username = "2${request!!.username}"
        return loginRepository.signIn(request!!)
    }

}