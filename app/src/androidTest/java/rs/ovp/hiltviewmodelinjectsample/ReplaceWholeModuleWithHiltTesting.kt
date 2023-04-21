package rs.ovp.hiltviewmodelinjectsample

import android.os.SystemClock
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import rs.ovp.hiltviewmodelinjectsample.activities.MainActivity
import rs.ovp.hiltviewmodelinjectsample.repository.HomeRepository
import rs.ovp.hiltviewmodelinjectsample.repository.RepositoryModule

//This is Example Test where we are going to replace hole hilt module and use another
@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
@RunWith(AndroidJUnit4::class)
class ReplaceWholeModuleWithHiltTesting {

    @BindValue
    @JvmField
    val homeRepository: HomeRepository = MockedHomeRepository()

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    // This is if we are using standard xml & espresso to test our activity
    @get:Rule(order = 1)
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

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