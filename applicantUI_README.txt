To Run live camera tests (most tests are live camera tests and should be default):
1. manually enable camera permissions when executing tests from local machines
2. execute from command prompt(NOT POWERSHELL): mvn verify -Dcucumber.options="--tags @applicantUI" -Dbrowser="Chrome_Nexus"
Note: Other browser option for the live camera test is: -Dbrowser="Chrome_iPhone" 

To Run file upload camera test for OralTox and OralEze
1. mvn verify -Dcucumber.options="--tags @applicantUIChromeOnly" -Dbrowser="Chrome"

Tag Information
End to End test tag: @end2End
OralTox test only tag is: @oraltox
OralEze test only tag is: @oraleze
Smoke test only tag is: @amazonst
Smoke test where Mobile Device usage is required tag: @amazonstDeviceNeeded
Use this tag for Chrome Browser Only testing. If no browser tag is specified then chrome is used by default: @applicantUIChromeOnly

Parameter(s):
dryRun: used to determine whether to run the tests locally or via remote Webdriver on the test server
    - value to use: true (will execute tests locally) or false (will execute tests remotely)


To Run Regression Suite on local machine, execute the following from the command prompt (NOT POWERSHELL):
1. Run oralTox live camera regression:
    mvn verify -Dcucumber.options="--tags @applicantUI --tags @oraltox" -Dbrowser="Chrome_iPhone" -DdryRun=true
2. Run oralTox photo upload regression
    mvn verify -Dcucumber.options="--tags @applicantUIChromeOnly --tags @oraltox" -Dbrowser="Chrome" -DdryRun=true
3. Run oralEze live camera regression:
    mvn verify -Dcucumber.options="--tags @applicantUI --tags @oraleze" -Dbrowser="Chrome_iPhone" -DdryRun=true
4. Run oralEze photo upload regression
    mvn verify -Dcucumber.options="--tags @applicantUIChromeOnly --tags @oraleze" -Dbrowser="Chrome" -DdryRun=true
5. Run api regression:
    mvn verify -Dcucumber.options="--tags @backendApi" -Dbrowser="Chrome" -DdryRun=true

