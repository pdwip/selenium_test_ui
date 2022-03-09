#!/usr/bin/env bash

# remove old trace of report
rm -rf allure-results/*.json

# maven command to run the tests
mvn test -Dsurefire.suiteXmlFiles=suites/test_run_parallel.xml

# generate allure report
allure generate --clean

# serve report
allure serve