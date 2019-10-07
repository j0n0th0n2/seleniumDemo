Selenium Demo
=============

Statement of the Problem
=====================
Write a UI end to end user test class (language of your choice) that launches a web browser and navigates to the WebdriverIO website (http://webdriver.io). Click on the 'API' link in the top navigation bar and load their API documentation (http://webdriver.io/api.html_). Use their search functionality on this page to search their API for the text 'click'. Collect and return the link names in the left nav section that are returned as a result of the search. Have your test verify that the following 5 action results are returned (click, doubleClick, leftClick, middleClick, rightClick). If possible, use the Page Object model for element locators and helper functions.
As a second task create another set of test cases that would further test the functionality of this search widget.

_This problem statement is for the old version of the UI reflected in the [v4 website|http://v4.webdriver.io]_

Notes about this implementation
===============================
This project is to demonstrate the four main Object-Oriented Design principles.  
* <b>encapsulation</b> - of the WebDriver Interfaces
* <b>inheritance</b> - there are page object that extend the Page object 
* <b>polymorphism</b> - the WaitFor class has a mechanism with multiple subclasses that will alter the behavior of a single method
* <b>abstraction</b>  - again the abstract Page class is a place for common shared functionality

Other OOD principles, **Single Purpose** and **D.R.Y** _(don’t repeat yourself)_ principles, being used in this implementation. The use of these principles can be seen in the com.jsv.sal.Element class which addresses several behaviors imposed on test code by Selenium. It isolates the Selenium’s StaleElementReferenceException pattern to a single class.   It encapsulates the WebDriver which minimizes the maintenance if that interfaces changes.  It uses _encapsulation_ to improve the functionality of the Selenium interface and allows for the definition of static **compile-time** objects. The com.jsv.descriptors.* classes are a common location for defining the Locators into a single location.   


## Package Layout
**/src/main/com/jsv/descriptors** - contains the locators
**/src/main/com/jsv/pageObjects** - contains the business logic needed to manipulate the UI
**/src/main/com/jsv/sal**- Selenium Abstraction Layer for working around Selenium
**/src/test/com/jsv/ **- location of the tests

## Tools
* Apache Maven 3.6.1
* Java version: 1.8.0_211, vendor: Oracle Corporation,
* IntelliJ IDEA 2019.1.3 (Community Edition)
* Windows 10 10.0
* Chrome Version 77.0.3865.90 (Official Build) (64-bit)

Next Steps
===================
1. There is a problem with re-finding objects in lists.  If these Elements become stale, they cannot be refreshed correctly.  There is a solution for this which is about 2 days of work.
2. Introduce TestNG and real time reporting via their [Test Listener Interface|http://javadox.com/org.testng/testng/6.8/org/testng/ITestListener.html]
3. Introduce logging to the classes using log4j or slf4j
4. Introduce a reporting database for archiving of test results
5. Adding more tests
