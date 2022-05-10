package utilities

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver

class DriverManager {
    private val log = Logs()
    private val browser = System.getProperty("browser")

    fun buildLocalDriver(): WebDriver {
        return when(browser) {
            "CHROME" -> {
                log.debug("Creating chrome browser")
                WebDriverManager.chromedriver().setup()
                ChromeDriver()
            }
            "EDGE" -> {
                log.debug("Creating edge browser")
                WebDriverManager.edgedriver().setup()
                EdgeDriver()
            } else -> {
                log.debug("Invalid browser, creating chrome driver")
                WebDriverManager.chromedriver().setup()
                return ChromeDriver()
            }
        }
    }
}