@oraltox @nonPre-Employment
Feature: OralTox Applicant UI (Non Pre-employment)


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC4 @TC84364 @TC84371 @TC84370 @amazonRegression
  Scenario: Applicant UI-Click Next on Acknowledgement and Authorization page should navigate to NC Disclosure screen
    Given a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | RND            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | amazonAlias    |

    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter Applicant information for non-preemployment order with Alias
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
    When I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    Then I can verify that NC Disclosure Screen appears on the Applicant UI
    And I enter the consenting signature for NC Disclosure screen
    And I wait for 1 seconds
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC4 @TC82082 @amazonRegression
  Scenario: Applicant UI - System does NOT read the QR Code - System/App should throw error if the Specimen ID field left blank
    Given a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | RND            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | amazonAlias    |

    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter Applicant information for non-preemployment order with Alias
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
    And I can verify that NC Disclosure Screen appears on the Applicant UI
    And I enter the consenting signature for NC Disclosure screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 60 seconds
    And I click the indicator is red button
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
    When I enter the sample ID "AD333333333" on the first field on Enter ID screen
    And I enter the sample ID "" on the second field on Enter ID screen
    And I click the Next button
    Then I can verify that all fields required error message is given on Enter ID page


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC4 @TC82083 @amazonRegression
  Scenario: Applicant UI - System does NOT read the QR Code - System/App should throw error if the entered Specimen ID is invalid format
    Given a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | RND            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | amazonAlias    |

    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter Applicant information for non-preemployment order with Alias
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
    And I can verify that NC Disclosure Screen appears on the Applicant UI
    And I enter the consenting signature for NC Disclosure screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 60 seconds
    And I click the indicator is red button
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
    When I enter the sample ID "5200649A" on the first field on Enter ID screen
    And I enter the sample ID "5200649A" on the second field on Enter ID screen
    And I click the Next button
    Then I can verify that format not correct error message is given on Enter ID page on Enter ID page


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC4 @T134289 @amazonRegression
  Scenario: Applicant UI - System should save the changes if the checkbox for EmailResultToDonor is selected
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I select the Business Line "North American Fulfillment Center" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package "OralTox 6 Panel"
    And I click the next button for the order in the Admin UI
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I enter First Name "Mike" on the Identification Information Screen
    And I enter Last Name "Curry" on the Identification Information Screen
    And I enter Date of Birth  "01/01/1990" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Amazon Alias "AmazonAlias"
    And I click the next button for the order in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "rohullah.nasimi@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Curry", Birthday "01/01/1990", and alias "amAzonALIAS"
    And I click the get started button on the Get Started screen
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I verify that the Email Checkbox is available on the Additional Disclosure page
    When I click the Email-Checkbox on Additional Disclosure page in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I click the back button
    And I wait for 2 seconds
    And I verify that the Email-Checkbox is selected on Additional Disclosure page
    And I click the Email-Checkbox on Additional Disclosure page in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I click the back button
    And I wait for 2 seconds
    Then I verify that the Email-Checkbox is Not selected on Additional Disclosure page







