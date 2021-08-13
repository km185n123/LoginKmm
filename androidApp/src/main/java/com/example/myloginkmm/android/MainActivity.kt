package com.example.myloginkmm.android

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myloginkmm.Greeting
import com.example.myloginkmm.base.Response
import com.example.myloginkmm.feature.login.domain.model.AuthInitiateResponse
import com.example.myloginkmm.feature.login.viewmodel.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    // View Model
    @ExperimentalCoroutinesApi
    lateinit var loginViewModel: LoginViewModel

    private lateinit var getLoginObserver : (state: GetLoginState) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.type)
        tv.text = greet()

        initViewModel()
        configView()
    }

    override fun onDestroy() {
        super.onDestroy()
        loginViewModel.authenticationSuccessLiveData.removeObserver(getLoginObserver)
    }

    private fun configView() {
        btnSignIn.setOnClickListener {
            loginViewModel.signIn(txtUser.text.toString())
        }

    }

    @ExperimentalCoroutinesApi
    private fun initViewModel() {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        observeViewModel()

    }

    /****************************************************************************
     * OBSERVER
     ***************************************************************************/
    private fun observeViewModel() {
        getLoginObserver = { getLoginState(loginViewModel.authenticationSuccessLiveData.value) }
        loginViewModel.authenticationSuccessLiveData.addObserver(getLoginObserver)
    }

    fun getLoginState(state: GetLoginState) {
        when (state) {
            is SuccessGetGitHubRepoListState -> {
                hideLoading()
                val response =  state.response as Response.Success
                onSuccessGetGitHubList(response.data)
            }

            is LoadingGetGitHubRepoListState -> {
                showLoading()
            }

            is ErrorGetGitHubRepoListState -> {
                hideLoading()
                val response =  state.response as Response.Error
                showError(response.exception.message)
            }
        }
    }

    /**
     * ON SUCCESS
     */
    private fun onSuccessGetGitHubList(aut: AuthInitiateResponse) {
       // configRecyclerView(list)
        Toast.makeText(this, "/"+aut.session, Toast.LENGTH_SHORT).show()
    }

    /**
     * SHOW LOADING
     */
    private fun showLoading() {
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
    }

    /**
     * HIDE LOADING
     */
    private fun hideLoading() {
    }

    /**
     * SHOW ERROR
     */
    private fun showError(message: String?) {
        Toast.makeText(this, "error "+message, Toast.LENGTH_SHORT).show()
    }

}
