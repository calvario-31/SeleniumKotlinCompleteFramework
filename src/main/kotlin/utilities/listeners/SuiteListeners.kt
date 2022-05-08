package utilities.listeners

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import utilities.Logs

class SuiteListeners: BeforeAllCallback, AfterAllCallback {
    private val log = Logs()

    override fun beforeAll(context: ExtensionContext?) {
        if (context != null) {
            log.startSuite(context.displayName)
        }
    }

    override fun afterAll(context: ExtensionContext?) {
        log.info("Suite finished")
    }
}