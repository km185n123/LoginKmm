package com.example.myloginkmm.feature.login.data.source.network

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.AuthInitiateRequest


abstract class LoginDataSource {
    abstract suspend fun authenticate(authInitiateRequest: AuthInitiateRequest): Response<AuthInitiateResponse>
}