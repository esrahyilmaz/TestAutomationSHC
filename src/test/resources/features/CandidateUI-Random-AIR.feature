@oraltox @nonPre-Employment
Feature: OralTox Applicant UI (Non Pre-employment)


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-AIR @TC123832 @TC123833 @TC123834 @amazonRegression
  Scenario: Applicant UI - Random Air (NY, MD, OR) - Collection App Flow
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Henrico" for the order
    And I choose the state "New York" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I select the Business Line "AIR (Non-Regulated)" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package "OralTox 1 Panel"
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Employee ID Number "987654" on the Identification Information Screen
    And I enter First Name "Paki" on the Identification Information Screen
    And I enter Last Name "Parker" on the Identification Information Screen
    And I enter Amazon Alias "Sample"
    And I enter Date of Birth  "01/01/1980" on the Identification Information Screen
    And I verify the next button is enabled for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "804-393-1485" for the order in the Admin UI
    And I enter the email address "rohullah.nasimi@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATTT" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Parker", Birthday "01/01/1980", and alias "Sample"
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
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80101AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 5 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 3 seconds
    And I upload a readable photo of the 6 panel 6 strip device
    And I click the button: "happy with my photo"
    And I wait for 3 seconds
    And I can verify that this device is not valid for your location error message appears
    And I click the Cancel Request button on the device message
    And I upload a readable photo of the 7 panel 7 strip device
    And I click the button: "happy with my photo"
    And I wait for 5 seconds
    And I can verify that this device is not valid for your location error message appears
    And I wait for 3 seconds
    And I click the Cancel Request button on the device message
    When I upload a readable photo of the 7 panel 1 strip device
    And I click the button: "happy with my photo"
    And I wait for 5 seconds
    Then I verify the screen appears: Please wait while we review your results


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-AIR @TC105800 @TC105801 @amazonRegression
  Scenario: Random Air - Collection App Flow - System should throw an error message that the device is invalid for the location
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Richmond" for the order
    And I choose the state "Virginia" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I select the Business Line "AIR (Non-Regulated)" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package "OralTox 7 Panel"
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Employee ID Number "456555" on the Identification Information Screen
    And I enter First Name "Bob" on the Identification Information Screen
    And I enter Last Name "Palma" on the Identification Information Screen
    And I enter Amazon Alias "SampleAlias"
    And I enter Date of Birth  "01/01/1980" on the Identification Information Screen
    And I verify the next button is enabled for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "804-393-1485" for the order in the Admin UI
    And I enter the email address "rohullah.nasimi@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATST" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Palma", Birthday "01/01/1980", and alias "SampleAlias"
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
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 5 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 3 seconds
    And I upload a readable photo of the 6 panel 1 strip device
    And I click the button: "happy with my photo"
    And I wait for 3 seconds
    And I can verify that this device is not valid for your location error message appears
    And I click the Cancel Request button on the device message
    When I upload a readable photo of the 6 panel 6 strip device
    And I click the button: "happy with my photo"
    And I wait for 3 seconds
    Then I can verify that this device does not have the correct number of panels error message appears
    And I click the Cancel Request button on the device message
    And I upload a readable photo of the 7 panel 7 strip device
    And I click the button: "happy with my photo"
    And I wait for 5 seconds
    And I verify the screen appears: Please wait while we review your results




