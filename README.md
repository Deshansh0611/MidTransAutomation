Demo MidTrans Automation:
The motive of this project is to automate the UI test cases of MidTrans website. Java is used as programming language and Selenium as the library to interact with web browser.

Getting Started:
The idea behind developing such framework is to keep test cases simple. Builder, Singleton and Factory design patterns have been used.
Reason behind using builder is to reduce the lines of code when creating more test cases.
Factory has been used as we wish to store object of each web page so that it can be used in future. For example, we will know what was the price of pillow on home page and we can compare the this price on Checkout page and verify that consistency is maintained.
Singleton is used so that we can restrict user to have single objects.

Prerequisites:
You should have Java and Maven installed in your machine. Maven should be able to take care of rest of the dependencies.

Running the tests:
1. Make sure you have met the prerequisites.
2. Go to the root directory. 
3. There is a .bat file named testRunner. Run this file and tests should start running.
4. Go to midTransAutomation\target\surefire-reports to view the results
5. In case, you wish to view the logs, these are saved in TestLogs.txt file.

Built With:
Maven is used as Dependency Management tool.

Versioning:
1.9

Additional remarks:
1. I have used Property file to store test data as per the current requirement. Depending on the requirement, other alternatives can also be used. For example, if our objective is to have Data driven development, we could use Data provider to run same tests with multiple set of data.
2. I have used Interfaces to store locators and few constants. Page factory could also have been used. I prefer Interfaces due to the simplicity.
3. Wherever possible and required, singleton objects have been created. For example, driver object is singleton.
4. I have not used any external library for reporting due to time constants. I have used the default reporting which testng offers. Though, I have made some tweaks in it to make it look even better. For example, screenshot of the failed tests is captured in the screenshot folder.
5. For viewing the reports, go the following directory:
midTransAutomation\target\surefire-reports
View the emailable-report.html
6. I have willingly removed Geckodriver binary as project size was going beyond 15MB due to this and this being office laptop, I am not authorized to send this big of a file. If you wish to run these tests in Firefox, you can download the binary file from the below address:
https://github.com/mozilla/geckodriver/releases
Even if you do not download geckodriver, test cases will run just fine in Chrome.
7. I have used latest verion of Chrome to run these tests. Version 75 to be precise. Please make sure latest chrome is installed to run these tests just to avoid compatibility issues.

Author
Deshansh Sahu