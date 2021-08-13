package com.example.myloginkmm.feature.login.domain.usecase.base

interface BaseRequest {
    fun validate(): Boolean
}