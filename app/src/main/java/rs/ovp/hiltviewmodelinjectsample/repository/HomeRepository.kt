package rs.ovp.hiltviewmodelinjectsample.repository

import kotlinx.coroutines.flow.Flow


interface HomeRepository {

    fun getTextData(): Flow<String>

}