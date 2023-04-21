package rs.ovp.hiltviewmodelinjectsample

import android.os.SystemClock
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.runner.RunWith
import rs.ovp.hiltviewmodelinjectsample.activities.MainActivity
import rs.ovp.hiltviewmodelinjectsample.states.HomeState
import rs.ovp.hiltviewmodelinjectsample.viewmodels.HomeViewModel

//This is Example Test where we mock main view model using espresso testing framework
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityMockViewModelTestEspresso {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    // This is if we are using standard xml & espresso to test our activity
    @get:Rule(order = 1)
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @BindValue
    @JvmField
    val viewModel = mockk<HomeViewModel>(relaxed = true) {
        every { state } returns MutableStateFlow(HomeState("Hello from compose test"))
    }

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun test_HomeActivityEspresso() {
        // We can't access composable objects through espresso so unfourtenatly this can only be done inside the xml applications
//        onView(withText("Hello from compose test"))
        SystemClock.sleep(5000)
    }
}