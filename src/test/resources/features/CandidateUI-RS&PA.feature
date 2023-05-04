@oraltox @nonPre-Employment
Feature: OralTox Applicant UI (Non Pre-employment)


  @amazonSelfCollect @ApplicantUI @CandidateUI-RS&PA @TC108637 @TC108638 @108640 @108641 @108642 @108643 @amazonST
  Scenario: Admin UI - You should be navigated to the Open Alcohol Pouch screen When you click on Cap is sealed tightly button
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason " Post Accident "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I select the Business Line "North American Customer Fulfillment" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package " OralTox 7 Panel + Alcohol "
    And I click the next button for the order in the Admin UI
    Then I verify Employee ID field is displayed in the Identification Information Screen
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I enter First Name "prathu" on the Identification Information Screen
    And I enter Last Name "neha1" on the Identification Information Screen
    And I enter Date of Birth  "01/01/1998" on the Identification Information Screen
    And I enter Amazon Alias "Alias"
    And I enter the Employee ID Number "123654789" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I wait for 2 seconds
    And I enter the phone number "281-236-1477" for the order in the Admin UI
    And I enter the email address "prathap.s@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I wait for 3 seconds
    And I can verify the Residence Information screen is displayed
    And I wait for 2 seconds
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I wait for 2 seconds
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "neha1", Birthday "01/01/1998", and alias "alias"
    And I click the get started button on the Get Started screen
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
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
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 60 seconds
    And I click the indicator is red button
    When I click the Cap is Sealed Tight button
    And I wait for 5 seconds
    Then I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    When I click the Next button
    Then I verify that I am on the Alcohol Wait Screen of the Applicant UI
    When I click the Next button
    Then I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    When I click the Next button
    Then I verify that I am on the Pick up OralTox device screen of the Applicant UI




