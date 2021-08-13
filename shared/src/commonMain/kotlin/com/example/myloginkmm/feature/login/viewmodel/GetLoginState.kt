package com.example.myloginkmm.feature.login.viewmodel

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.AuthInitiateRequest

sealed class GetLoginState {
    abstract val response: Response<AuthInitiateResponse>?
}
data class SuccessGetGitHubRepoListState(override val response: Response<AuthInitiateResponse>) : GetLoginState()
data class LoadingGetGitHubRepoListState(override val response: Response<AuthInitiateResponse>? = null) : GetLoginState()
data class ErrorGetGitHubRepoListState(override val response: Response<AuthInitiateResponse>) : GetLoginState()