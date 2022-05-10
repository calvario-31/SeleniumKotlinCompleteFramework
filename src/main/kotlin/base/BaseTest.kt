package base

import io.qameta.allure.Attachment
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import utilities.CommonFlows
import utilities.DriverManager
import utilities.Logs
import utilities.listeners.SuiteListeners
import utilities.listeners.TestsListeners

@ExtendWith(TestsListeners::class, SuiteListeners::class)
abstract class BaseTest {
    private val log = Logs()
    lateinit var driver: WebDriver
    lateinit var commonFlows: CommonFlows

    private fun initDriver() {
        driver = DriverManager().buildLocalDriver()
        driver.manage().window().maximize()
        driver.manage().deleteAllCookies()
    }

    @BeforeEach
    fun setup() {
        log.debug("Init driver")
        initDriver()
        initPages()
        commonFlows = CommonFlows(driver)
        commonFlows.goToIndex()
    }

    @AfterEach
    fun teardown() {
        log.debug("Killing driver")
        driver.quit()
    }

    @Attachment(value = "Screenshot failure", type = "image/png")
    fun getScreenshot(): ByteArray {
        log.debug("Taking screenshot")
        return (driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
    }

    abstract fun initPages()
}