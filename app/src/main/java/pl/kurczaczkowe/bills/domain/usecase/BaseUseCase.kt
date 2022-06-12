package pl.kurczaczkowe.bills.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<out Type, in Params> where Type : Any? {

    abstract suspend fun run(params: Params): Type

    suspend fun execute(
        params: Params,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Type) -> Unit = {}
    ) {
        val result = withContext(dispatcher) {
            run(params)
        }

        onResult(result)
    }
}