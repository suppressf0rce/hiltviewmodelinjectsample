package rs.ovp.hiltviewmodelinjectsample.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(): HomeRepository {

    override fun getTextData(): Flow<String> = flow {
        delay(1000)
        emit("Hello from compose")
    }.flowOn(Dispatchers.Default)

}