package com.example.myloginkmm.feature.login.domain.usecase

import com.example.myloginkmm.feature.login.domain.usecase.base.BaseRequest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AuthInitiateRequest (
    @SerialName("username")
    var username: String,
    @SerialName("Method")
    val method: String,
    ) : BaseRequest {
    override fun validate(): Boolean {
        return !username.isEmpty()
    }
}