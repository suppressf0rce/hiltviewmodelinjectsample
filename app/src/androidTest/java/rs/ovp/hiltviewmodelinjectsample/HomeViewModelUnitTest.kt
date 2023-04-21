package rs.ovp.hiltviewmodelinjectsample

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import org.junit.Test
import rs.ovp.hiltviewmodelinjectsample.repository.HomeRepository
import rs.ovp.hiltviewmodelinjectsample.viewmodels.HomeViewModel

// THIS IS EXAMPLE HOW WE CAN UNIT TEST VIEW MODEL
class HomeViewModelUnitTest {

    @Test
    fun viewModelSampleUnitTest() {
        val repository = mockk<HomeRepository>()
        every { repository.getTextData() } returns flow { emit("Test") }

        //Given
        val viewModel = HomeViewModel(repository)

        //When
        viewModel.loadData()

        //Then
        verify { repository.getTextData() }
        assertEquals("Test", viewModel.state.value.helloMessage)
    }

}