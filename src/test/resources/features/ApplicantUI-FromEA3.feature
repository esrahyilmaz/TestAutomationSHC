@oraltox
Feature: OralTox Applicant UI Pre-employment

  Background: Generate Candidate data
    Given a request for CreateOrder and POST to the api
      | json field    | new value     |
      | firstName     | B[gennum:5]   |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
      | ssn           | [gennum:4]    |

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @applicantUIChromeOnly @TC1454 @TC8922 @amazonST
  Scenario: Thank You Screen - Resume from Last with NO Video
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 10 seconds
    And I upload the photo of the drugscreen results
    And I wait for 10 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000601" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And a request json "AdjudicateInconclusiveCOC.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 4 seconds
    And I verify the Clean your station screen appears
    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    When I enter the Applicant information and re-launch
    Then I can verify the message appears for candidates that have already taken the test


#    This scenario uses a qrcode that is overlapped and is included to ensure overlapped codes work
  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @applicantUIChromeOnly @TC1082a @TC13181 @amazonST
  Scenario: Take Photo Screen after Inconclusive Adjudication with NO Video - QR/Bar Code (Upload)
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload a bad photo
    And I wait for 2 seconds
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I wait for 15 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And a request json "AdjudicateInconclusiveCOC.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 15 seconds
    And I verify the Clean your station screen appears
    And I navigate to applicant UI screen using the alias
    And I click the speech play button on the start screen
    When I enter the Applicant information and re-launch
    Then I can verify the message appears for candidates that have already taken the test


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC2001 @amazonST
  Scenario:OralTox Get Help Icon on Open Pouch Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "This testing process allows your employer to oversee testing while donors collect their own"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the Grab test kit and open pouch screen appears

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @applicantUIChromeOnly @TC2004 @amazonRegression
  Scenario:OralTox Get Help Icon on Pool Saliva and Collect Sample Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "This testing process allows your employer to oversee testing while donors collect their own"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the saliva image is present


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC1918 @amazonST
  Scenario: OralTox Get Help Icon on Collect a Sample Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 22 seconds
    When I click the Get Help icon
    Then I can verify the help content screen appears with content text "The swab indicator will turn red"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the Sample Collection screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC2843 @amazonRegression
  Scenario: OralTox Get Help Icon on Indicator Wait Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I can verify the swabbing results wait screen appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the swabbing results wait screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC2333 @amazonRegression
  Scenario: OralTox Get Help Icon on Insert Swab Help
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I activate the test?"
    And I can verify the help content screen appears with content text "With the OralTox test device positioned upright on a FLAT SURFACE"
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC2335 @amazonRegression
  Scenario: OralTox Get Help Icon on Photo Rules Help
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I can verify the swabbing results wait screen appears
    And I click the Next button
    When I click the I see the results button
    Then I verify the photo rules screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "What if I don’t see the test results and QR Code clearly?"
    And I can verify the help content screen appears with content text "Ensure the OralTox test is placed on a flat surface and remain there for the duration of the test"
    And I can verify the help content screen appears with content text "If one or more of the test strips do not have lines beginning to form, you may then gently tap the OralTox"
    And I can verify the help content screen appears with content text "If you still do not see the results and QR code clearly after a few minutes"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the photo rules screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @applicantUIChromeOnly @TC2338 @amazonRegression
  Scenario: OralTox Get Help Icon on Enter Sample ID page Help
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload a bad photo
    And I wait for 7 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "Where can I find the Sample ID?"
    And I can verify the help content screen appears with content text "The Sample ID is printed right below the QR code on your OralTox device."
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Sample ID screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC2752 @amazonRegression
  Scenario: OralTox Get Help Icon on Welcome Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer



  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @TC1920 @amazonRegression
  Scenario: OralTox Get Help Icon on Edit Phone Number Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "5"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the update phone or email button on the Applicant Review Information screen
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the Applicant Review Information screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA3 @amazonstDeviceNeeded @TC2998 @amazonRegression
  Scenario: OralTox Get Help Icon on 'Review Your Photo Review' Screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 10 seconds
    When I take the photo on the camera
    And I wait for 7 seconds
    Then I verify the Applicant Review your Photo screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Applicant Review your Photo screen appears