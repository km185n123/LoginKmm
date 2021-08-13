package com.example.myloginkmm.feature.login.data.source.network

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.base.exception.NetworkConnectionException
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.AuthInitiateRequest
import com.example.myloginkmm.utilis.isNetworkAvailable
import io.ktor.client.HttpClient
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.Logger
import io.ktor.client.request.*
import io.ktor.http.*

class LoginApi {

    suspend fun getAuthentication(client: HttpClient, authInitiateRequest: AuthInitiateRequest): Response<AuthInitiateResponse> {
        return try {
            if (isNetworkAvailable()) {
                Logger.DEFAULT.log("auth - ${authInitiateRequest.toString()}")
                val url = "https://pcoapigw-appuat.puntoscolombia.com/cognitomanager/auth/initiate"

                val response = client.post<AuthInitiateResponse>(url){
                    contentType(ContentType.Application.Json)
                    body = authInitiateRequest
                }
                Logger.DEFAULT.log("auth - $response")
                Response.Success(response)
            }else{
                Response.Error(NetworkConnectionException())
            }
        }catch (ex: Exception) {
            Logger.DEFAULT.log("getGitHubRepoList - "+ ex.message!!)
            Response.Error(ex)
        }
    }
}