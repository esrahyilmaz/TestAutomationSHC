Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin

  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC81574 @TC81575 @TC81576 @amazonRegression
  Scenario: Admin UI - Create New Order - Candidate ID Number should be replaced with Employee ID Number
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
    Then I verify Employee ID field is displayed in the Identification Information Screen
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Wonder" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I enter Amazon Alias "AmazonAlias"
    And I enter the Employee ID Number "0" on the Identification Information Screen
    And I verify Employee ID Error message is given in the Admin UI
    And I enter the Employee ID Number "123654789101mk" on the Identification Information Screen
    And I verify Employee ID Error message is given in the Admin UI
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I verify the next button is enabled for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC74109 @amazonRegression
  Scenario: Admin UI - Tracking information page should not be displayed for Random Order, after Clear Adjudication
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
    And I wait for 1 seconds
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
    And I enter the sample ID "52006492" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the clear button on the Admin UI
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    When I click the confirm button on the adjudication message modal
    Then I verify that Tracking Information Page was not displayed in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC74110 @amazonRegression
  Scenario: Admin UI - Tracking information page should not be displayed for Random Order, after Retest Adjudication
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
    And I wait for 1 seconds
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
    And I enter the sample ID "52006492" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the Retest button on the Admin UI
    And I select the reason for Invalid option "Other - enter details below"
    And I enter a comment "Test" for the invalid reason
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    When I click the confirm button on the adjudication message modal
    Then I verify that Tracking Information Page was not displayed in the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC105676 @TC105675 @amazonRegression
  Scenario: Admin UI - You should be navigated back to Dashboard When you click on Dashboard
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
    And I wait for 1 seconds
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
    And I enter the sample ID "52006493" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 6 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    When I click on the candidate in the Admin UI
    And I wait for 1 seconds in AdminUI
    Then I verify Dashboard Button is displayed in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I click Dashboard Button in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I verify that I am on the Admin UI Dashboard
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify Dashboard Button is displayed in the Admin UI
    And I click the inconclusive button for adjudication
    And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
    And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    And I click on the Certify button on the Four Eyes Check Page in Admin UI
    And I click the inconclusive button for adjudication
    And I enter a signature in the last Adjudication page of the Admin UI
    And I select the Inconclusive strips for the order in Admin UI
    And I verify the Sign and Submit button is disabled in Admin UI
    And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
    And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
    And I click sign and submit button for inconclusive adjudication
    And I click the confirm button on the adjudication message modal


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC106063 @TC106283 @amazonRegression
  Scenario: Admin UI - Package Information page -North American Customer Fulfillment should be renamed to North American Fulfillment Center
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    When I click the next button for the order in the Admin UI
    Then I select the Business Line "North American Fulfillment Center" on the Package Information Page


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC115635 @TC115636 @TC115637 @TC115639 @amazonST
  Scenario:Admin UI - Support Tools FA Superuser - Should be able to search order by first and last name
    Given a request json "adminUIOrderRND.json" for Admin CreateOrder api
    And update the json request
      | json path    | new value   |
      | .lastName    | Silva |
      | .dateOfBirth | 01/01/2001  |
      | .candidateId | [gennum:12] |
      | wellnessId   | [gennum:9]  |
      | .EACaseId    | [gennum:9]  |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatchRND_S.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Silva", Birthday "01/01/1980", and alias "alias"
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
    And I can verify that NC Disclosure Screen appears on the Applicant UI
    And I enter the consenting signature for NC Disclosure screen
    And I wait for 1 seconds
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
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds
    And I click on the menu and choose Support Tools
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Support Tools page of the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify Search by Name and Search by Device ID search boxes are displayed in the Support Tools Page of the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify column headers in Support Tools Page are Name, Last Update, Device ID, Wellness ID, Status,Step
    And I wait for 3 seconds in AdminUI
    And I enter "abc" into the Search by Name search box of Support Tools Page in Admin UI
    And I wait for 6 seconds in AdminUI
    And I can verify that system display zero result found
    When I enter "Silva" into the Search by Name field on Support Tools Page in Admin UI
    And I wait for 6 seconds in AdminUI
    Then I can verify that the search results are showing for "Silva" candidate on the Support Tools in the Admin UI
    And I wait for 6 seconds in AdminUI
    And I enter "00000600" into the Search by Device ID field on Support Tools Page in Admin UI
    And I wait for 6 seconds in AdminUI
    And I can verify that the search results are showing for "00000600" Device ID on the Support Tools in the Admin UI
    And I wait for 5 seconds in AdminUI


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC116067 @amazonST
  Scenario: Support tool-You should be able to update and save the Wellness ID of the order When you navigate to the Order details page
    Given a request json "adminUIOrderRND.json" for Admin CreateOrder api
    And update the json request
      | json path    | new value   |
      | .lastName    | Silva |
      | .dateOfBirth | 01/01/2001  |
      | .candidateId | [gennum:12] |
      | wellnessId   | [gennum:9]  |
      | .EACaseId    | [gennum:9]  |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatchRND_S.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds in AdminUI
    And I click on the menu and choose Support Tools
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Support Tools page of the Admin UI
    And I wait for 2 seconds in AdminUI
    And I enter "Silva" into the Search by Name field on Support Tools Page in Admin UI
    And I wait for 6 seconds in AdminUI
    And I can verify that the search results are showing for "Silva" candidate on the Support Tools in the Admin UI
    And I click on the name field of results on the Support Tools
    And I wait for 5 seconds in AdminUI
    When I enter "12345123" for Wellness Advantage ID in Support Tool in Admin UI
    And I click on the Save Changes button on the Support Tool
    And I wait for 2 seconds in AdminUI
    Then I verify the Changes Saved Successfully message appears on the Support Tools


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC2 @TC116063 @TC116075 @TC116068 @TC116076 @amazonST @amazonRegression
  Scenario:Admin UI - Support Tool - View/Edit Order Details
    Given a request json "adminUIOrderRND.json" for Admin CreateOrder api
    And update the json request
      | json path    | new value   |
      | .lastName    | Silva |
      | .dateOfBirth | 01/01/2001  |
      | .candidateId | [gennum:12] |
      | wellnessId   | [gennum:9]  |
      | .EACaseId    | [gennum:9]  |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatchRND_S.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Silva", Birthday "01/01/1980", and alias "alias"
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
    And I can verify that NC Disclosure Screen appears on the Applicant UI
    And I enter the consenting signature for NC Disclosure screen
    And I wait for 1 seconds
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
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
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the menu and choose Support Tools
    And I wait for 3 seconds in AdminUI
    And I enter "Silva" into the Search by Name field on Support Tools Page in Admin UI
    And I wait for 6 seconds in AdminUI
    And I can verify that the search results are showing for "Silva" candidate on the Support Tools in the Admin UI
    And I click on the name field of results on the Support Tools
    And I wait for 5 seconds in AdminUI
    And I can verify that I can see the candidate name "Silva" on the Support Tool in Admin UI
    And I wait for 5 seconds in AdminUI
    And I verify that I can see last Updated on the Support Tool in Admin UI
    And I wait for 1 seconds in AdminUI
    And I verify that I can see Device ID on the Support Tool in Admin UI
    And I wait for 1 seconds in AdminUI
    And I verify that I can see Current Status on the Support Tool in Admin UI
    And I wait for 1 seconds in AdminUI
    And I verify that I can see Current Step on the Support Tool in Admin UI
    And I wait for 1 seconds in AdminUI
    And I verify that I can see Current Step Drop-down on the Support Tool in Admin UI
    And I wait for 2 seconds in AdminUI
    And I choose the Current Step "RETAKE PHOTO" on the Search results page on the Support Tool
    And I wait for 2 seconds in AdminUI
    And I click on the Save Changes button on the Support Tool
    And I wait for 2 seconds in AdminUI
    And I verify the Changes Saved Successfully message appears on the Support Tools
    And I wait for 2 seconds in AdminUI
    When I can verify that I can see the candidate "Silva" on the JSON on the results page of Support Tool in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click the Back to Results button on the Support Tools in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I enter "Silva" into the Search by Name field on Support Tools Page in Admin UI
    And I wait for 5 seconds in AdminUI
    Then I verify that the Current Step is RETAKE PHOTO on the candidate search results page on Support Tool in Admin UI
    
