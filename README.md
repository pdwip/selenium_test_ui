## Summary:

1. This is a sample framework has developed to address the UI task. This will open “bbc.com”. Then will navigate to the page and validate the navigation bar for the broken links. This will also check the date display on the page and validate the News page link. At the end search for “Houghton Mifflin Harcourt” and validate the search results. 
2. The framework is developed using Selenium, TestNG and Allure. 

## Details of the framework:
1. Selenium has used for the browser interactions and UI testing. 
2. TestNG is the test runner. 
3. Allure is for reporting purpose. Also it has unique feature as annotation format, i.e. “steps” to give BDD approach to the tests. The same will also display in the report what are all steps has been used in the test, in a simpler and much clear way. 
4. Maven has used as the build tool.
5. Language used Java.

## Pre conditions to compile:
1. The system needs to have Java 8 or higher versions.
2. The system needs to have maven install. 
3. The system needs to install allure to generate the report. 

## How to run?
1. The tests can be run and compile using TestNG on editor. The tests are developed using intalij Ide. The project has to be imported as a maven project by selecting the pom.xml. Once imported do write click on the test class UiTests.class  and run using TestNG runner. 
2. The tests can be run using maven command from the command line. Go to the project directory and run the command: mvn test -Dsurefire.suiteXmlFiles=suites/test_run_parallel.xml
3. The tests can be run from the TestNG.xml. There are 3 xml inside suite folder. It has xml to run the tests only on Chrome, FireFox and to run on Chrome and Firefox in parallel. By right click they can be run using TestNG.
4. On Mac or in Windows with shell script the tests can be run using the shell script testRunner.sh. It will generate the report once the tests are done. 
5. The tests can be run on Mac and Windows the chrome and firefox drives are in place in the resources for Mac and Windows. 

## Generate reports:
1. The reports will be generated in allure-results folder. They can be easily hosted on the default browser by the below steps:
   Power shell In windows go to the package directory and type below commands:
	allure generate --clean
	allure serve
2. Type the above commands on Mac terminal from the project directory. 

# Note: 
1. Steps are not generating on the Windows machine. Need to debug. 
2. A sample screen shot of the tests are attached here. 


