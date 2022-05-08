package login

import base.BaseTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import pageobjects.login.LoginPage
import pageobjects.shopping.HomePage
import utilities.tags.Smoke

class LoginTest : BaseTest() {
    lateinit var loginPage: LoginPage
    lateinit var homePage: HomePage

    @Test @Smoke @DisplayName("validCredentialsTest")
    fun validCredentialsTest() {
        loginPage.fillForm("standard_user", "secret_sauce")
        homePage.waitPageToLoad()
        homePage.verifyPage()
    }

    override fun initPages() {
        loginPage = LoginPage(driver)
        homePage = HomePage(driver)
    }
}