package com.example.myloginkmm

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineContext = Dispatchers.Default