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

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC20724 @amazonRegression
  Scenario: Applicant UI: Applicant Retrieval Using Social Security Number
    Given I navigate to Applicant UI for location "CLT4"
    When I click the speech play button on the start screen
    Then I can verify the social security number text field is present
    And I enter the Applicant information with the correct social security digits and without booth information
    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the Next button

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC20532 @amazonST
  Scenario: Applicant UI: Social Security Number required in Validation Message
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    When I enter the Applicant information with the incorrect social security digits "456-67-3333" and without booth information
    Then I can verify the error message appears for non-matching last name or birthday or social security number


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC18893 @amazonST
  Scenario: Message for Non-Matching Social Security Number
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    When I enter the Applicant information with the incorrect social security digits "456-27-3456" and without booth information
    Then I can verify the error message appears for non-matching last name or birthday or social security number


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC83779 @TC83783 @TC83791 @TC83792 @amazonST
  Scenario: Applicant UI - E- Signature Consent - The language should be updated
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    And I can verify that a confirmation Popup appears on Disclosure page for Applicant UI
    And I click on No, Back button on the Confirmation Popup on Disclosure page for Applicant UI
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    When I click on Yes, Decline button on the Confirmation Popup on Disclosure page for Applicant UI
    Then I verify that I'm on the Applicant UI Welcome screen

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC83782 @amazonST
  Scenario: Applicant UI - E- Signature Consent - You should see Drug & Alcohol policy screen after clicking on 'Agree' button
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC84438 @TC84442 @TC84440 @TC84449 @TC98745 @TC98746 @TC98747 @TC98748 @amazonST
  Scenario: Applicant UI- You should be navigated to Drug and Alcohol policy screen when you click Agree on Electronic Signature consent screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    And I can verify that a confirmation Popup appears on Disclosure page for Applicant UI
    And I click on No, Back button on the Confirmation Popup on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    When I click on Yes, Decline button on the Confirmation Popup on Disclosure page for Applicant UI
    Then I verify that I'm on the Applicant UI Welcome screen

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC84438 @TC84442 @TC84440 @TC84449 @amazonST
  Scenario: Applicant UI- You should be navigated to FCRA Disclosure and Authorization screen when you click Agree on Drug and Alcohol Policy screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    When I click on Agree button on Disclosure page for Applicant UI
    Then I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC89078 @TC89080 @TC89082 @TC84372 @amazonRegression
  Scenario: Applicant ui- click agree on Additional Disclosures screen takes to Acknowledgements and Authorization screen
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I can verify that Back button is available on Disclosure page for Applicant UI
    And I can verify that Next button is available on Disclosure page for Applicant UI
    And I can verify that Signature pad is available on Disclosure page for Applicant UI
    And I click the back button
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    When I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    Then I can verify the Grab test kit and open pouch screen appears

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC82072 @amazonRegression
  Scenario: Applicant UI - System reads the QR Code - System/App should accept the 2 alpha + 9 digits Sample ID for new devices
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
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    When I upload the photo of the device with new sample ID format
    And I click the button: "happy with my photo"
    Then I verify the screen appears: Please wait while we review your results


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC82079 @TC98728 @TC98722 @amazonRegression
  Scenario: Applicant UI - System does NOT read the QR Code - System/App should accept the 2 alpha + 9 digits Sample ID for new devices
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
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload a bad photo
    And I wait for 5 seconds
    And I verify the photo is uploaded
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I click the back button
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    When I enter the sample ID "52006492" on the first field on Enter ID screen
    And I enter the sample ID "52006491" on the second field on Enter ID screen
    And I click the Next button
    Then I can verify that entries do not match error message is given on Enter ID page

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA5 @TC91188 @amazonST
  Scenario: Applicant UI- When you click back button on Disclosure pages You should be navigated to previous page.
    Given I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information and booth number "7"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    When I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    Then I can verify that Disclosures Page Back Button is available in the Applicant UI
    And I click the disclosures back button in the Applicant UI
    And I wait for 2 seconds
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I can verify that Disclosures Page Back Button is available in the Applicant UI
    And I click the disclosures back button in the Applicant UI
    And I wait for 2 seconds
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I wait for 2 seconds
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I can verify that Disclosures Page Back Button is available in the Applicant UI
    And I click the disclosures back button in the Applicant UI
    And I wait for 2 seconds
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I can verify that Disclosures Page Back Button is available in the Applicant UI
    And I click the disclosures back button in the Applicant UI
    And I wait for 2 seconds
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
