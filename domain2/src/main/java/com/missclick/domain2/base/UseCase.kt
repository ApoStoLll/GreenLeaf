package com.missclick.domain2.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {
    /**
     * Runs the actual logic of the use case.
     */
    abstract suspend fun run(params: Params): Either<Exception, Type>

    suspend operator fun invoke(params: Params, onSuccess: (Type) -> Unit,
                                onFailure: (Exception) -> Unit) {
        val result = run(params)
        coroutineScope {
            launch(Dispatchers.IO) {
                result.fold(
                    failed = { onFailure(it) },
                    succeeded = { onSuccess(it) }
                )
            }
        }
    }

    /**
     * Placeholder for a use case that doesn't need any input parameters.
     */
    object None
}