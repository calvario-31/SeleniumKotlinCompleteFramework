package utilities.listeners

import base.BaseTest
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import utilities.Logs
import java.util.*

class TestsListeners : TestWatcher, BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private val log = Logs()

    override fun beforeTestExecution(context: ExtensionContext?) {
        if (context != null) {
            log.startTest(context.displayName)
        }
    }

    override fun afterTestExecution(context: ExtensionContext?) {
        if (context != null && context.executionException.isPresent) { //test failed -> screenshot
            takeScreenshot(context)
        }
    }

    override fun testDisabled(context: ExtensionContext?, reason: Optional<String>?) {
        if (context != null) {
            log.endTest("SKIPPED")
        }
    }

    override fun testSuccessful(context: ExtensionContext?) {
        if (context != null) {
            log.endTest("PASSED")
        }
    }

    override fun testAborted(context: ExtensionContext?, cause: Throwable?) {
        if (context != null) {
            log.endTest("ABORTED")
        }
    }

    override fun testFailed(context: ExtensionContext?, cause: Throwable?) {
        if (context != null) { //we cant take screenshot here since the driver is already killed
            log.endTest("FAILED")
        }
    }

    private fun takeScreenshot(context: ExtensionContext) {
        val testInstance = context.requiredTestInstance
        log.debug(testInstance.javaClass.simpleName)

        (testInstance as BaseTest).getScreenshot()
    }
}