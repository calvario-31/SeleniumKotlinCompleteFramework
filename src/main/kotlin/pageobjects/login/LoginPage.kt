package pageobjects.login

import base.BasePage
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions.assertAll

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.function.Executable
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage(driver: WebDriver, timeOut: Long = 5) : BasePage(driver, timeOut) {
    private val usernameInput = By.id("user-name")
    private val passwordInput = By.id("password")
    private val loginButton = By.id("login-button")

    @Step("Waiting login page to load")
    override fun waitPageToLoad() {
        waitPage(usernameInput, this.javaClass.simpleName)
    }

    @Step("Verifying login page")
    override fun verifyPage() {
        assertAll( "login page",
            Executable { assertTrue(verifyIsDisplayed(usernameInput)) },
            Executable { assertTrue(verifyIsDisplayed(passwordInput)) },
            Executable { assertTrue(verifyIsDisplayed(loginButton)) }
        )
    }

    @Step("Filling login form")
    fun fillForm(username: String, password: String) {
        log.info("Entering username")
        typeText(usernameInput, username)

        log.info("Entering password")
        typeText(passwordInput, password)

        log.info("Clicking on login button")
        click(loginButton)
    }
}