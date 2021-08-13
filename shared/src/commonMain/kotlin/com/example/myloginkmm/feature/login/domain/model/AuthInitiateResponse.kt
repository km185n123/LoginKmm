package com.example.myloginkmm.feature.login.domain.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthInitiateResponse (
    @SerialName("ChallengeName")
    val   challengeName:String,
    @SerialName("Session")
    val  session:String,
)