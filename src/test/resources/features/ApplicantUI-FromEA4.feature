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

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @amazonstDeviceNeeded @TC2926 @amazonST
  Scenario: OralTox Get Help Icon on Tetris Screen
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
    And I take the photo on the camera
    And I wait for 7 seconds
    When I click the button: "happy with my photo"
    Then I verify the screen appears: Please wait while we review your results
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I wait for 2 seconds
    And I click the button: Found My Answer
    And I verify the screen appears: Please wait while we review your results

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @amazonstDeviceNeeded @TC3059 @amazonRegression
  Scenario: OralTox Get Help Icon on 'Clean Your Station' Screen
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
    And I wait for 7 seconds
    And I click the button: I'm ready to take a photo
    And I wait for 10 seconds
    And I take the photo on the camera
    And I wait for 10 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 16 seconds
    When a request json "AdjudicateInconclusive.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 4 seconds
    Then I verify the Clean your station screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Clean your station screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC5559A @amazonRegression
  Scenario: Applicant UI - OralTox Insert Swab Form - Rename Next button
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
    When I can verify the Sample Collection screen appears
    And I click the indicator is red button
    Then I certify that the button is present with value "The cap is sealed tightly"


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @applicantUIChromeOnly @TC5639 @amazonST
  Scenario: Applicant UI - OralTox - Remove seal device instructions
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
    And I can verify the swabbing results wait screen appears
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    And I click the button: I'm ready to take a photo
    And I upload the photo of the device photo
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    When a request json "AdjudicateInconclusive.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 16 seconds
    Then I verify the Clean your station screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC20700 @amazonST
  Scenario: Applicant UI - PBT User: Read QRCode and Barcode with Pass Indicators and Message
    Given I launch the PBT user qrcode and barcode reader
    And click the start scan button on the PBT barcode reader
    When I wait for 15 seconds to allow the barcode and qrcode reader to scan
    Then I can verify the qr code "33357861F21030162022-03-17OT-80701" is successfully read from the PBT scan
    And I can verify the barcode "QXRX" is successfully read from the PBT scan


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC25339 @amazonST
  Scenario: SortingUI: Logging Results when QR Code is not Read/Invalid
    Given I launch the Sorting UI user qrcode and barcode reader
    And click the start scan button on the Sorting UI qrcode reader
    And I wait for 2 seconds
    When I wait for 5 seconds to allow the barcode and qrcode reader to scan
    Then I can verify the sorting UI qr code result is "Inconclusive"
    And I can verify the sorting UI qr code result message is "Inconclusive"


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @amazonstDeviceNeeded @TC41302 @amazonST
  Scenario: Admin UI - Live Camera: Submit Image Step State for Applicant's Card
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
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 7 seconds
    And I verify the Take Photo screen is available
    And I verify the photo shutter is green
    And I take the photo on the camera
    And I wait for 15 seconds
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    When I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "TEST" in the Admin UI
    And I click on the candidate in the Admin UI
    Then validate candidate info
      | name                     | step    |
      | data.runtime.invite-name | Processing Image |

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC49495 @amazonRegression
  Scenario: Applicant UI: Candidate with pre-employment reason should be able to see the default consent before navigating to next step
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    When I click the Next button
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
    Then I can verify that the consent form is default for pre-employment reason for test

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC49733 @TC49728 @amazonRegression
  Scenario: Applicant UI: Candidate should get an error message in respond to an invalid input to Booth Number field at the Get Started Page
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I enter booth number "0" into Enter Booth Number Page in Applicant UI
    When I click the Next button
    Then I verify that booth number validation error message is given in the Applicant UI Enter Booth Number Page
    And I clear the booth number field in the Applicant UI Enter Booth Number Page
    And I enter booth number "100" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I verify that booth number validation error message is given in the Applicant UI Enter Booth Number Page
    And I clear the booth number field in the Applicant UI Enter Booth Number Page
    And I enter a random booth number 1 through 99 into get started screen in the Applicant
    And I click the Next button
    And I can verify that no error message is thrown for booth number field in Applicant UI

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @applicantUIChromeOnly @TC52130 @TC52154 @amazonRegression
  Scenario: Applicant UI: For pre-Employment reason for test, Applicant should be prompted to enter the  booth number
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | ssn           | [gennum:4]     |

    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    When I enter the Applicant information without booth information
    Then I verify that the Applicant is navigated to Enter Booth Number Page
    And I enter booth number "25" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I close the current browser
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "TEST" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate's abandoned card in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on Abandoned Process button
    And I select a reason for Abandoned Process
    And I enter consent signature for Abandoned Process in the Admin UI
    And I click sign and submit button in the Admin UI
    And I click the confirm button on the adjudication message modal
    And I wait for 2 seconds in AdminUI
    And I click on the Concluded Tests Tab in the Admin UI
    And I wait for 2 seconds in AdminUI
    And the card should be displayed in concluded tests dashboard
    And I verify the candidate card has booth number "25" in the Admin UI

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC55054 @amazonRegression
  Scenario: Applicant UI: Orders created from a specific account, must only be activated in that account
    Given I navigate to applicant UI screen using the alias "CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    When I enter the Applicant information without booth information
    Then I can verify the error message appears for non-matching last name or birthday or social security number
    And I navigate to applicant UI screen using the alias "AMZ1" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I can verify the error message appears for non-matching last name or birthday or social security number
    And I navigate to applicant UI screen using the alias "TEST" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I verify that the Applicant is navigated to Enter Booth Number Page

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA4 @TC67253 @TC67256 @TC67264 @TC67267 @99218 @99215 @99217 @amazonST
  Scenario: Applicant UI - If Applicant brings any changes to Email and click 'Next' button, system should verify that the Email address
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "5"
    When I click the Next button
    And I can verify the Applicant Review Information screen appears
    Then I verify the text "Make sure we have your phone number and email address correct." in the Review your Information Page
    And I click the update phone or email button on the Applicant Review Information screen
    And I click the Cancel button
    And I can verify the Applicant Review Information screen appears
    And I click the update phone or email button on the Applicant Review Information screen
    And I can verify the phone number is editable
    And I can enter the new phone number "678-555-41" on the Review your Information Screen
    And I click the Next button
    And I can verify the error message for Phone Number edit is given in the Review your Information Screen
    And I can enter the new phone number "678-555-4411" on the Review your Information Screen
    And I can verify the email is editable
    And I can enter the new email "esra.yilmaz.com" on the Review your Information Screen
    And I click the Next button
    And I can verify the error message for Email edit is given in the Review your Information Screen
    And I can enter the new email "esra.yilmaz@fadv.com" on the Review your Information Screen
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI