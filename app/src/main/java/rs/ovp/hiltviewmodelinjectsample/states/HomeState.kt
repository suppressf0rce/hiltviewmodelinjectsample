package rs.ovp.hiltviewmodelinjectsample.states

data class HomeState(
    val helloMessage: String? = null,
    val error: String? = null,
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false
)
