package com.example.myloginkmm.feature.login.data.source.network

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.AuthInitiateRequest
import io.ktor.client.*

class LoginDataSourceImpl(
    private val loginApi: LoginApi,
    private val client: HttpClient
): LoginDataSource() {


    override suspend fun authenticate(authInitiateRequest: AuthInitiateRequest): Response<AuthInitiateResponse> {
        return loginApi.getAuthentication(client,authInitiateRequest)
    }
}