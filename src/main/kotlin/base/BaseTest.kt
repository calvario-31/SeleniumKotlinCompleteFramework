package base

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.WebDriver
import utilities.CommonFlows
import utilities.DriverManager
import utilities.listeners.SuiteListeners
import utilities.listeners.TestsListeners

@ExtendWith(TestsListeners::class, SuiteListeners::class)
abstract class BaseTest {
    lateinit var driver: WebDriver
    lateinit var commonFlows: CommonFlows

    private fun initDriver() {
        driver = DriverManager().buildLocalDriver()
        driver.manage().window().maximize()
        driver.manage().deleteAllCookies()
    }

    @BeforeEach
    fun setup() {
        initDriver()
        initPages()
        commonFlows = CommonFlows(driver)
        commonFlows.goToIndex()
    }

    @AfterEach
    fun teardown() {
        driver.quit()
    }

    abstract fun initPages()
}