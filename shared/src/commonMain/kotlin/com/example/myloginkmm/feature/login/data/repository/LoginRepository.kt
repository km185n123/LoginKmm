package com.example.myloginkmm.feature.login.data.repository

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.feature.login.data.source.network.LoginDataSource
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.AuthInitiateRequest

class LoginRepository(
    private val loginDataSource: LoginDataSource
) {

    /***********************************************************************************************
     * SIGN IN
     **********************************************************************************************/
    suspend fun signIn(authInitiateRequest: AuthInitiateRequest): Response<AuthInitiateResponse> {
        return loginDataSource.authenticate(authInitiateRequest)
    }

}