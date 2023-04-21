package rs.ovp.hiltviewmodelinjectsample

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    ExampleInstrumentedTest::class,
    HomeViewModelUnitTest::class,
    MainActivityMockViewModelTestComposable::class,
    MainActivityMockViewModelTestEspresso::class,
    ReplaceWholeModuleWithHiltTesting::class
)
class TestSuite