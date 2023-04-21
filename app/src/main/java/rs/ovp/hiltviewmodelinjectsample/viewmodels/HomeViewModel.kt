package rs.ovp.hiltviewmodelinjectsample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import rs.ovp.hiltviewmodelinjectsample.repository.HomeRepository
import rs.ovp.hiltviewmodelinjectsample.states.HomeState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    init {
        observeData()
    }

    private val mutableHomeState: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState(isLoading = true))

    val state: StateFlow<HomeState> = mutableHomeState

    private fun observeData() {
        viewModelScope.launch {
            homeRepository.getTextData().collect { data ->
                mutableHomeState.update { it.copy(isLoading = false, helloMessage = data) }
            }
        }
    }

    fun loadData(): Job {
        mutableHomeState.update { it.copy(isLoading = true) }
        return viewModelScope.launch {
            homeRepository.getTextData().collect { data ->
                mutableHomeState.update { it.copy(isLoading = false, helloMessage = data) }
            }
        }
    }
}