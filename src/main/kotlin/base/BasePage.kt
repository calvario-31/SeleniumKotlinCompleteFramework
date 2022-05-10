package base

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utilities.Logs
import java.time.Duration

abstract class BasePage(private val driver: WebDriver, timeOut: Long = 5) {
    private val mainUrl = "https://www.saucedemo.com/"
    private val wait = WebDriverWait(driver, Duration.ofSeconds(timeOut))
    protected val log = Logs()

    private fun findElement(locator: By): WebElement {
        return driver.findElement(locator)
    }

    protected fun click(locator: By) {
        return findElement(locator).click()
    }

    protected fun typeText(locator: By, text: String) {
        return findElement(locator).sendKeys(text)
    }

    protected fun waitForVisibility(locator: By) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
    }

    protected fun verifyIsDisplayed(locator: By): Boolean {
        return driver.findElement(locator).isDisplayed
    }

    protected fun waitPage(locator: By, text: String) {
        log.info("Waiting $text to load")
        waitForVisibility(locator)
        log.info("Page loaded successfully")
    }

    fun goToIndex() {
        log.debug("Going to $mainUrl")
        driver.get(mainUrl)
    }

    abstract fun waitPageToLoad()
    abstract fun verifyPage()
}