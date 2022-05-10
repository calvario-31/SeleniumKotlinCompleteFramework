# SELENIUM KOTLIN FRAMEWORK

Selenium kotlin using Junit5

To run with command line:

```sh
./gradlew clean test -DsuiteName=${suiteName} -Pbrowser=${browserName}
```
where suiteName = Smoke or Regression

Example:

```sh
./gradlew clean test -DsuiteName=Smoke -Pbrowser=EDGE
```

Current browsers: EDGE, CHROME
If browser parameter is not passed it will run on CHROME

URL:

```
https://www.saucedemo.com/
```