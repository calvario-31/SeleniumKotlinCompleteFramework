package utilities

import org.openqa.selenium.WebDriver
import pageobjects.login.LoginPage

class CommonFlows(private val driver: WebDriver) {
    fun goToIndex() {
        val login = LoginPage(driver)
        login.goToIndex()
        login.waitPageToLoad()
    }
}