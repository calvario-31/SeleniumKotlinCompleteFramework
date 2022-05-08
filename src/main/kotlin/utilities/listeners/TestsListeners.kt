package utilities.listeners

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import utilities.Logs
import java.util.*

class TestsListeners : TestWatcher, BeforeTestExecutionCallback {
    private val log = Logs()

    override fun beforeTestExecution(context: ExtensionContext?) {
        if (context != null) {
            log.startTest(context.displayName)
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
        if (context != null) {
            log.endTest("FAILED")
        }
    }
}