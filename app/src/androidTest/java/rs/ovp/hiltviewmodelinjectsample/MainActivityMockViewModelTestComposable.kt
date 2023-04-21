package rs.ovp.hiltviewmodelinjectsample

import android.os.SystemClock
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
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
import rs.ovp.hiltviewmodelinjectsample.ui.home.HomeScreen
import rs.ovp.hiltviewmodelinjectsample.ui.theme.AppTheme
import rs.ovp.hiltviewmodelinjectsample.viewmodels.HomeViewModel

//This is Example Test where we mock home view model using composable framework (Even easier)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityMockViewModelTestComposable {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    // This is if we are using standard xml & espresso to test our activity
    @get:Rule(order = 1)
    var activityRule = createComposeRule()

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
    fun test_HomeActivityComposable() {
        activityRule.setContent {
            AppTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
        activityRule.onNodeWithText("Hello from compose test").assertIsDisplayed()
    }
}