package utilities

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Logs {
    private val log: Logger = LogManager.getLogger("AUTOMATION")

    private fun printSeparator() {
        log.info("------------------------------------------------------------------------------------------")
    }

    private fun printNewLine() {
        log.info("")
    }

    fun startTest(testName: String) {
        printSeparator()
        log.info("Test: $testName")
        printSeparator()
    }

    fun endTest(status: String?) {
        printSeparator()
        log.info(status)
        printSeparator()
        printNewLine()
        printNewLine()
    }

    fun startSuite(suiteName: String) {
        printNewLine()
        printSeparator()
        printSeparator()
        log.info("Beginning: $suiteName")
        printSeparator()
        printSeparator()
        printNewLine()
    }

    fun info(message: String?) {
        log.info(message)
    }

    fun warn(message: String?) {
        log.warn(message)
    }

    fun error(message: String?) {
        log.error(message)
    }

    fun debug(message: String?) {
        log.debug(message)
    }
}