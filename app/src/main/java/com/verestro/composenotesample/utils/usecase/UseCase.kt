package com.verestro.composenotesample.utils.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class UseCase<out Type, in Params> where Type : Any {

    open suspend fun action(params: Params): Type? = null

    suspend fun executeAction(
            params: Params,
            dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Type? {
        return withContext(dispatcher) {
            action(params)
        }
    }

    open operator fun invoke(
        params: Params,
        viewModelScope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Type?>) -> Unit = {}
    ): Job = viewModelScope.launch {
        val result: Result<Type?> = runCatching {
            executeAction(params, executionDispatcher)
        }
        onResult(result)
    }
}