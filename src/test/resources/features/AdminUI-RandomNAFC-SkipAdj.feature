Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC-SkipAdj @TC89107 @TC86871 @TC86876 @TC96263 @TC91277 @TC91283 @TC91281 @amazonRegression
  Scenario: Admin UI - Modified Adjudication Page should have Valid, Retest and Abandoned Process Options
    Given a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Non-Adjudicate  Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | RND            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | amazonAlias    |

    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-STL8" for orders created via Admin UI
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
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80101AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I wait for 3 seconds
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
    And I wait for 10 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000100" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds
    And I click on the location link for "RDM-STL8" in the Admin UI
    And I click on the candidate in the Admin UI
    When I click the Yes button on the Admin specimen id screen
    Then I can verify "Valid" and "Retest" buttons are enabled on the Modified Adjudication Page
    And I can verify "Abandoned Process" button is disabled on the Modified Adjudication Page
    And I verify that the view examples button is enabled for Valid Option in Admin UI
    And I verify that the view examples button is enabled for Retest Option in Admin UI
    And I click Valid Button in the Modified Adjudication Page of the Admin UI
    And I verify that I am navigated to Sign and Submit Page in the Admin UI
    And I enter the consent signature for the Admin adjudication
    And I verify the Sign and Submit button is disabled in Admin UI
    And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
    And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
    And I click certify button for the adjudication in the Modified Adjudication Page
    And I verify the confirm button is displayed on the Modified Adjudication Confirmation modal
    And I click the confirm button on the adjudication message modal

  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC-SkipAdj @TC91282 @TC91278 @amazonRegression
  Scenario: Admin UI - Retest option navigates to Retest reason selection page for Non-Adjudication Flow
    Given a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Non-Adjudicate  Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | RND            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | amazonAlias    |

    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-STL8" for orders created via Admin UI
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
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80101AZ" from the Drop-down list in Applicant UI
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
    And I wait for 10 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "QC000000120" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds
    And I click on the location link for "RDM-STL8" in the Admin UI
    And I click on the candidate in the Admin UI
    When I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds in AdminUI
    And I click Retest button in the Modified Adjudication Page of Admin UI
    Then I verify that I am on the Select Reason Page of Modified Adjudication Flow
    And I verify the page title is showing as Validating for Modified Adjudication page
    And I select the reason for Invalid option "Other - enter details below"
    And I enter a comment "Test Comment" for the invalid reason
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    And I verify the confirm button is displayed on the Modified Adjudication Confirmation modal
    And I click the confirm button on the adjudication message modal


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC-SkipAdj @TC133754 @amazonST
  Scenario: Admin UI - There should be an answer of Yes under one strip column when you use one strip device
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Sugarland" for the order
    And I choose the state "New York" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I select the Business Line "North American Fulfillment Center" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package "OralTox 1 Panel"
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Employee ID Number "456555" on the Identification Information Screen
    And I enter First Name "Test" on the Identification Information Screen
    And I enter Last Name "Manju3" on the Identification Information Screen
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
    And I wait for 2 seconds in AdminUI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I wait for 2 seconds in AdminUI
    And I click on the submit button for the order in the Admin UI
    And I wait for 2 seconds
    And I verify the Order completed message in the Admin UI
    When I click the Done button for the order in the Admin UI
    And I wait for 4 seconds in AdminUI
    And I can verify the Placed Order screen is displayed
    And I verify column headers in Placed Orders Page are Name, SSN, DOB, Created, Status,Location, Order Id, Package, One Strip
    And I verify the candidate "Manju3, Test" is placed at the top of the Placed Orders list in the Admin UI
    Then I verify the one strip column is showing "Yes" for candidate "Manju3, Test" in the Admin UI Placed Order Page
