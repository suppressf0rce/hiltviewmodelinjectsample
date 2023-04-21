package rs.ovp.hiltviewmodelinjectsample

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rs.ovp.hiltviewmodelinjectsample.repository.HomeRepository

class MockedHomeRepository: HomeRepository {
    override fun getTextData(): Flow<String> = flow {
        emit("Hello from compose test with mocked repository")
    }.flowOn(Dispatchers.Default)
}