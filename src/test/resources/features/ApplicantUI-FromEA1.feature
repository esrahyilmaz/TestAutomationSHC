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

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC411 @TC10460 @amazonRegression
  Scenario: Applicant Launches with NO Video
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    When I enter booth number "5" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    Then I can verify the Applicant Review Information screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC1065  @amazonST
  Scenario: Error Message for Non-Matching Candidate Data on the Welcome Screen using No Video
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Gurley", Birthday "05/01/1955", and SSN "5322"
    When I click the get started button on the Get Started screen
    Then I can verify the error message appears for non-matching last name or birthday or social security number


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC415 @amazonRegression
  Scenario: Drug Screen Consent with NO Video
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
    When I click on Agree button on Disclosure page for Applicant UI
    Then I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC414  @TC6401 @amazonST
  Scenario: Phone Number Verification Screen With NO Video
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "5"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I verify the address details on the Phone Number Screen
    And I click the update phone or email button on the Applicant Review Information screen
    And I click the Cancel button
    And I can verify the Applicant Review Information screen appears
    When I click the update phone or email button on the Applicant Review Information screen
    Then I can verify the phone number is editable
    And I can enter the new phone number "678-555-4411" on the Review your Information Screen
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

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC372 @amazonRegression
  Scenario: Grab a Test Kit and Open a Pouch Screen with NO Video
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
    When I click the Next button
    Then I verify the saliva image is present


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC6621 @amazonRegression
  Scenario: Applicant UI: OralTox Animation on Pool Saliva Screen
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
    When I click the Next button
    Then I verify the saliva image is present


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC373 @TC6661 @TC6660 @amazonRegression
  Scenario: Applicant UI: OralTox Timer on Collect The Sample Screen
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
    When I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    Then I verify the Insert Swab image appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @TC6627 @amazonRegression
  Scenario: Insert a Swab into the Device Screen with NO Video
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
    When I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    Then I can verify the swabbing results wait screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @amazonstDeviceNeeded @TC378 @amazonST
  Scenario: Photo Rules Screen with NO Video
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
    When I verify the saliva image is present
    And I click the Next button
    Then I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I can verify the swabbing results wait screen appears
    And I click the Next button
    And I click the I see the results button
    And I click on I'm ready to take photo button in Applicant UI
    And I wait for 6 seconds
    And I verify the Take Photo screen is available


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @amazonstDeviceNeeded @TC389 @amazonRegression
  Scenario: Take Photo Screen with NO Video
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
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    When I click the button: I'm ready to take a photo
    And I wait for 7 seconds
    Then I verify the Take Photo screen is available
    And I cancel the screen for taking a photo
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I take the photo on the camera
    And I verify the Applicant Review your Photo screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @amazonstDeviceNeeded @TC1158 @amazonRegression
  Scenario: ReTake Photo Screen with NO Video
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
    And I wait for 2 seconds
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    And I click the button: I'm ready to take a photo
    And I wait for 7 seconds
    And I verify the Take Photo screen is available
    And I cancel the screen for taking a photo
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    And I click the button: I'm ready to take a photo
    And I wait for 10 seconds
    When I take the photo on the camera
    And I verify the Applicant Review your Photo screen appears
    And I wait for 3 seconds
    Then I click the Retake Photo button
    And I verify the Take Photo screen is available


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA1 @amazonstDeviceNeeded @TC391 @amazonRegression
  Scenario: Check Your Photo Screen with NO Video
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
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    And I click the button: I'm ready to take a photo
    When I take the photo on the camera
    And I wait for 5 seconds
    Then I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
