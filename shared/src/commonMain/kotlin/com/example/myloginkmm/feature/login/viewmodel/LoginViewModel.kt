package com.example.myloginkmm.feature.login.viewmodel

import com.example.myloginkmm.base.Response
import com.example.myloginkmm.di.KodeinInjector
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.domain.usecase.AuthInitiateRequest
import com.example.myloginkmm.feature.login.domain.usecase.LoginUseCaseImplcase
import com.example.myloginkmm.utilis.Constants
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.kodein.di.instance

@ExperimentalCoroutinesApi
class LoginViewModel: ViewModel() {

    // LIVE DATA
     var authenticationSuccessLiveData =  MutableLiveData<GetLoginState>(LoadingGetGitHubRepoListState())


    // USE CASE
    private val loginUseCase by KodeinInjector.instance<LoginUseCaseImplcase>()

    /**
     * GET GITHUB REPO LIST
     */
    fun signIn(username: String) {
        viewModelScope.launch() {
            val request = AuthInitiateRequest(username,"sms")
            val response = loginUseCase.execute(request)
            processGitHubRepoListResponse(response)
        }
    }

    fun processGitHubRepoListResponse(response: Response<AuthInitiateResponse>) {
        if (response is Response.Success) {
            authenticationSuccessLiveData.postValue(
                SuccessGetGitHubRepoListState(
                    response
                )
            )
        } else if (response is Response.Error) {
            authenticationSuccessLiveData.postValue(
                ErrorGetGitHubRepoListState(
                    response
                )
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}