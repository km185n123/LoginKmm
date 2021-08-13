package com.example.myloginkmm.di

import com.example.myloginkmm.feature.login.data.repository.LoginRepository
import com.example.myloginkmm.feature.login.data.source.network.LoginApi
import com.example.myloginkmm.feature.login.data.source.network.LoginDataSource
import com.example.myloginkmm.feature.login.data.source.network.LoginDataSourceImpl
import com.example.myloginkmm.feature.login.domain.usecase.LoginUseCaseImplcase
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import kotlinx.coroutines.Dispatchers
import org.kodein.di.*
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val KodeinInjector = DI {

    bind<CoroutineContext>() with provider { Dispatchers.Main }

    val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = Json {
                isLenient = false
                ignoreUnknownKeys = true
                allowSpecialFloatingPointValues = true
                useArrayPolymorphism = false
            })
        }
    }

    /**
     * NETWORK API
     */
    bind<LoginApi>() with provider { LoginApi() }

    /**
     * NETWORK DATA SOURCE
     */
    bind<LoginDataSource>() with provider { LoginDataSourceImpl(instance(), client) }

    /**
     * REPOSITORIES
     */
    bind<LoginRepository>() with provider { LoginRepository(instance()) }

    /**
     * USECASES
     */
    bind<LoginUseCaseImplcase>() with singleton { LoginUseCaseImplcase(instance()) }
}