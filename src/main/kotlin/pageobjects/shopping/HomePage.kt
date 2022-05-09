package pageobjects.shopping

import base.BasePage
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class HomePage(driver: WebDriver, timeOut: Long = 5) : BasePage(driver, timeOut) {
    private val inventoryContainer = By.id("inventory_container")
    private val appLogo = By.className("app_logo")

    @Step("Waiting home page to load")
    override fun waitPageToLoad() {
        waitPage(inventoryContainer, this.javaClass.simpleName)
    }

    @Step("Verifying home page")
    override fun verifyPage() {
        Assertions.assertAll("login page",
            { Assertions.assertTrue(verifyIsDisplayed(inventoryContainer)) },
            { Assertions.assertTrue(verifyIsDisplayed(appLogo)) }
        )
    }
}