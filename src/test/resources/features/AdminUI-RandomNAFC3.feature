Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC3 @TC133756 @amazonST
  Scenario: Admin UI- There should be an answer of No under one strip column when you don't use one strip device (6 panel)
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Sugarland" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I select the Business Line "North American Fulfillment Center" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package "OralTox 6 Panel"
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Employee ID Number "456555" on the Identification Information Screen
    And I enter First Name "Test" on the Identification Information Screen
    And I enter Last Name "Rama3" on the Identification Information Screen
    And I enter Amazon Alias "SampleAlias"
    And I enter Date of Birth  "01/01/1980" on the Identification Information Screen
    And I verify the next button is enabled for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "804-393-1485" for the order in the Admin UI
    And I enter the email address "prathap.s@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I can verify the Residence Information screen is displayed
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I wait for 2 seconds
    And I verify the Order completed message in the Admin UI
    When I click the Done button for the order in the Admin UI
    And I wait for 4 seconds in AdminUI
    And I can verify the Placed Order screen is displayed
    And I verify column headers in Placed Orders Page are Name, SSN, DOB, Created, Status,Location, Order Id, Package, One Strip
    And I verify the candidate "Rama3, Test" is placed at the top of the Placed Orders list in the Admin UI
    Then I verify the one strip column is showing "No" for candidate "Rama3, Test" in the Admin UI Placed Order Page


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC3 @TC144332 @TC144334 @TC144331 @amazonRegression
  Scenario: Admin UI - Combine Tracking Information Screen with Adjudication/Validation Screen
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
    And I wait for 3 seconds
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
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 5 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I click the inconclusive button for adjudication
    And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
    And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    And I click on the Certify button on the Four Eyes Check Page in Admin UI
    And I click the inconclusive button for adjudication
    And I enter a signature in the last Adjudication page of the Admin UI
    When I select the Inconclusive strips for the order in Admin UI
    And I verify the Sign and Submit button is disabled in Admin UI
    And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
    And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
    Then I click sign and submit button for inconclusive adjudication
    And I click the confirm button on the adjudication message modal




