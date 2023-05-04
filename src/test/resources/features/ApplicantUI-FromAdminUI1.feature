@oraltox
Feature: OralTox Applicant UI Pre-employment

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromAdminUI1 @TC68968 @amazonst
  Scenario: Applicant UI - Application should remove white space on Last Name field and proceed
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "123456789011" on the Identification Information Screen
    And I enter First Name "Hami" on the Identification Information Screen
    And I enter Last Name "Tami" on the Identification Information Screen
    And I enter Social Security Number "156-44-1133" on the Identification Information Screen
    And I enter Date of Birth  "01/01/1980" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    When I verify the Order completed message in the Admin UI
    And I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name with a Space at the beginning " Tami ", Birthday "01/01/1980", and SSN "1133"
    And I click the get started button on the Get Started screen
    And I enter booth number "30" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    Then I can verify the Applicant Review Information screen appears

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromAdminUI1 @TC84218 @TC84220 @TC84222 @TC84226 @amazonst
  Scenario: Applicant UI-Next Button on FCRA or CA Disclosure Pages should navigate to Additional Disclosure Screen
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "123453386799" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
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
    And I navigate to applicant UI screen using the alias "LGB3" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information retrieved from the Admin UI order
    And I click the get started button on the Get Started screen
    And I enter the booth number "5" into get started screen in the Applicant UI
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    When I verify that I am on CA Disclosure Screen of the Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    Then I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    And I can verify that a confirmation Popup appears on Disclosure page for Applicant UI
    And I click on No, Back button on the Confirmation Popup on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromAdminUI1 @TC83926 @TC83928 @TC83929 @amazonst
  Scenario: Applicant UI-'Next' and 'Back' buttons should be available on CA Disclosure Page
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "123453386799" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
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
    And I navigate to applicant UI screen using the alias "LGB3" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information retrieved from the Admin UI order
    And I click the get started button on the Get Started screen
    And I enter the booth number "5" into get started screen in the Applicant UI
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    When I click on Agree button on Disclosure page for Applicant UI
    Then I verify that I am on CA Disclosure Screen of the Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    And I click on No, Back button on the Confirmation Popup on Disclosure page for Applicant UI
    And I verify that I am on CA Disclosure Screen of the Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromAdminUI1 @TC143624 @TC143634 @TC143635 @TC143421 @TC143540 @TC143547 @amazonRegression
  Scenario: Applicant UI- Require Donor to Enter Ref Code in Drug Testing Workflow
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "1234533867AA" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "804-258-4782" for the order in the Admin UI
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
    And I navigate to applicant UI screen using the alias "CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information retrieved from the Admin UI order
    And I click the get started button on the Get Started screen
    And I enter the booth number "5" into get started screen in the Applicant UI
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
    And I can verify the next button is disabled in the Applicant UI
    And I can verify all REF Codes exist in the Drop-down List in the Applicant UI
    And I select the REF Code "REF: 80101AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify that incorrect test kit for this testing reason error message appears
    And I click the close button on the error message popup
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify that incorrect test kit for this testing reason error message appears
    And I click the close button on the error message popup
    When I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I wait for 5 seconds
    And I click the Next button
    Then I can verify the Grab test kit and open pouch screen appears




