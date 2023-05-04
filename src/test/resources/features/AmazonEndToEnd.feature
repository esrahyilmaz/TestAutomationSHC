Feature: Amazon End To End Tests
  This feature file contains all End to End functionality tests for the Amazon Project.

  @amazonSelfCollect @AmazonEndToEnd @TC47167 @TC47168
  Scenario: Admin UI - Manage Orders: Filter Placed Orders Statuses
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
    And I navigate to applicant UI screen using the alias "CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information retrieved from the Admin UI order
    And I click the get started button on the Get Started screen
    And I enter the booth number "5" into get started screen in the Applicant UI
    And I click the Next button
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
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
    And I wait for 60 seconds
    When I navigate to the EA application and login to the set environment
    And I search by auto-generated candidate created in Admin UI for the order in EA
    Then I verify the order existence and retrieve the order id for the candidate
    And I logout of EA
    And I click on the menu and choose Manage Orders
    And I can verify all statuses exist in the Placed Orders List in the Admin UI
    And I filter by Status "In Progress" in the Placed Orders List in the Admin UI
    And I verify the generated candidate is placed at the top of the Placed Orders list in the Admin UI
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    And I verify chronological order exists for items in the Placed Order List in the Admin UI
    And I filter by Order Id retrieved from the EA order
    And I verify the generated candidate is placed at the top of the Placed Orders list in the Admin UI


  @amazonSelfCollect @AmazonEndToEnd @TC53058
  Scenario:Admin UI - Create Order: Orders need to be able to created with all US Territories phone numbers
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I enter the Candidate ID Number "123456789000" on the Identification Information Screen
    And I enter First Name "Alma" on the Identification Information Screen
    And I enter Last Name "Pims" on the Identification Information Screen
    And I enter Social Security Number "123-44-5678" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    When I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I wait for 1 seconds in AdminUI
    Then I provide data on the phone number field in the Admin UI Contact Information Page and verify that the numbers are valid
      | 670-234-8950 | 684-633-1222 | 855-953-4819 | 808-954-4818 | 671-344-9232 | 787-379-7455 | 340-998-2404 | 855-910-3277 |
      | 203-236-0847 | 207-236-1444 | 617-263-5514 | 603-236-6655 | 640-255-3624 | 212-366-5487 | 401-255-3642 | 215-225-6332 |
      | 802-555-6645 | 217-556-5445 | 219-556-5444 | 319-556-5443 | 316-556-5443 | 231-556-5243 | 218-346-5243 | 314-346-7343 |
      | 308-391-7343 | 701-371-7343 | 216-391-7243 | 605-324-7343 | 262-391-7123 | 205-236-1229 | 479-236-1479 | 302-215-1479 |
      | 239-246-1479 | 239-246-1479 | 229-236-1419 | 270-236-1469 | 225-212-1479 | 240-236-1229 | 228-214-1479 | 252-236-1477 |
      | 405-211-1479 | 803-236-1449 | 423-236-1259 | 281-236-1479 | 276-222-1479 | 276-266-1479 | 907-236-1477 | 479-233-1477 |
      | 209-236-1487 | 661-361-4797 | 303-236-1457 | 808-236-1497 | 208-277-1477 | 406-236-1227 | 702-236-1487 | 505-236-1227 |
      | 503-236-1227 | 435-236-1337 | 564-236-1977 | 307-236-1411 | 670-234-8950 | 808-954-4818 | 205-236-1229 | 804-593-8855 |

  @amazonSelfCollect @AmazonEndToEnd @TC108201 @TC108202 @TC108205 @TC108206 @TC108207 @TC108208 @TC108209
  Scenario:Admin should be navigated to the drug Final Test Result selection page When you click Certify
    Given a request for CreateOrder and POST to the api for reasonForTest PAC and REC  Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PAC            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | alias          |

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
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I wait for 2 seconds
    And I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    And I click the Next button
    And I verify that I am on the Alcohol Wait Screen of the Applicant UI
    And I wait for 10 seconds
    And I click the Next button
    And I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    And I wait for 36 seconds
    And I click the Next button
    And I verify that I am on the Pick up OralTox device screen of the Applicant UI
    And I click the I see the results button
    And I wait for 1 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 1 seconds
    And I upload the photo of the drugscreen results
    And I wait for 1 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33721502" on the Enter ID screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 5 seconds in AdminUI
    And I click the inconclusive button for adjudication
    And I verify that I am in the Alcohol Adjudication Page of the Admin UI
    And I click the alcohol result box "40" on the Admin UI
    And I click the next button for the Alcohol Flow in the Admin UI
    And I wait for 2 seconds
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify that I am on the Four Eyes Check page in Admin UI
    And I enter Salaried Leader Name "John Dillard" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    When I click the Sign and Submit button in the Four eyes Check Page
    And I wait for 4 seconds in AdminUI
    Then I can verify that I am on the Final Test Result Selection page in the Admin UI
    And I click the inconclusive button for adjudication
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Final Test Result Selection - Alcohol page of the Admin UI
    And I click the alcohol result box "80" on the Admin UI
    And I click the next button for the Alcohol Flow in the Admin UI
    And I verify that I am on the Certify Test Results page of the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that Seven Drug Strips are enabled for selection on the Certify Test Results Page
    And I wait for 2 seconds in AdminUI
    And I verify that Alcohol checkboxes are disabled on the Certify Test Results Page
    And I select test strips "1,2,4" as inconclusive on the Certify Test Results Page
    And I wait for 1 seconds in AdminUI
    And I enter a signature for the Certify Test Results page of the Admin UI
    And I wait for 2 seconds in AdminUI
    And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
    And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
    And I click sign and submit button for inconclusive adjudication
    And I wait for 1 seconds in AdminUI
    And I click the confirm button on the adjudication message modal
    And I wait for 2 seconds in AdminUI
    And I click on the Concluded Tests Tab in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that Alcohol Checkboxes are showing "80" in the Concluded Tests Tab


  @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @Air @TC127810
  Scenario: EA Order Entry for AIR
    Given I navigate to the EA application and login to the set environment for AIR RANDOM
    When I click on New Order link
    And I provide data on Order tab
      | field          | value           |
      | cid            | 12354           |
      | alias          | test            |
      | custom package | Oraltox 7 Panel |
    And I click on Next button
    And I provide data on Subject tab
      | field                   | value                |
      | first name (given name) | TEST                 |
      | last name               | AUTO[gennum:5]       |
      | phone number            | 4042229999           |
      | email address           | esra.yilmaz@fadv.com |
      | birth day               | 01                   |
      | birth month             | February             |
      | birth year              | 2000                 |
      | address 1               | 3111 main street     |
      | city                    | Duluth               |
      | state                   | GEORGIA              |
      | zip                     | 30096                |
      | have ssn                | yes                  |
      | social security number  | 124-12-[gennum:4]    |
    And I click on Additional Searches tab
    And I wait for 17 seconds in EA
    And I select the reason for test as "RANDOM" for EA Order
    And I click on Review Order tab
    And I click on Submit Order button
    And I wait for 20 seconds in EA
    And I verify the order created successfully
    And I logout of EA
    And I wait for 60 seconds
    And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATST" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Candidate information retrieved from the EA UI
    And I wait for 5 seconds
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I wait for 2 seconds
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I wait for 2 seconds
    And I verify the saliva image is present
    And I click the Next button
    And I wait for 2 seconds
    And I can verify the Sample Collection screen appears
    And I wait for 2 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I wait for 60 seconds
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
    And I wait for 2 seconds
    And I verify the Sample ID screen appears
    And I enter the sample ID "QA000000720" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "POSTEMP-FATST" in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click the auto-generated candidate created via EA UI
    And I wait for 5 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds in AdminUI
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
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


  @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @Air @skipAdj
  Scenario: EA Order Entry for AIR skipAdjudication flow
    Given I navigate to the EA application and login to the set environment for AIR RANDOM SkipAdjudication
    When I click on New Order link
    And I provide data on Order tab
      | field          | value           |
      | cid            | 12354           |
      | alias          | test            |
      | custom package | Oraltox 7 Panel |
    And I click on Next button
    And I provide data on Subject tab
      | field                   | value                |
      | first name (given name) | TEST                 |
      | last name               | AUTO[gennum:5]       |
      | phone number            | 4042229999           |
      | email address           | esra.yilmaz@fadv.com |
      | birth day               | 01                   |
      | birth month             | February             |
      | birth year              | 2000                 |
      | address 1               | 3111 main street     |
      | city                    | Duluth               |
      | state                   | GEORGIA              |
      | zip                     | 30096                |
      | have ssn                | yes                  |
      | social security number  | 124-12-[gennum:4]    |
    And I click on Additional Searches tab
    And I wait for 17 seconds in EA
    And I select the reason for test as "RANDOM" for EA Order
    And I click on Review Order tab
    And I click on Submit Order button
    And I wait for 20 seconds in EA
    And I verify the order created successfully
    And I logout of EA
    And I wait for 60 seconds
    And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATTT" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Candidate information retrieved from the EA UI
    And I wait for 5 seconds
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I wait for 2 seconds
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80101AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I wait for 2 seconds
    And I verify the saliva image is present
    And I click the Next button
    And I wait for 2 seconds
    And I can verify the Sample Collection screen appears
    And I wait for 2 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I wait for 60 seconds
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
    And I wait for 2 seconds
    And I verify the Sample ID screen appears
    And I enter the sample ID "QD000000161" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "POSTEMP-FATTT" in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click the auto-generated candidate created via EA UI
    And I wait for 5 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds in AdminUI
    And I verify the page title is showing as Validating for Modified Adjudication page
    And I click Valid Button in the Modified Adjudication Page of the Admin UI
    And I verify that I am navigated to Sign and Submit Page in the Admin UI
    And I enter the consent signature for the Admin adjudication
    And I verify the Sign and Submit button is disabled in Admin UI
    When I select the carrier "FedEx" in the Tracking Information page of the Admin UI
    And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
    And I click certify button for the adjudication in the Modified Adjudication Page
    Then I verify the confirm button is displayed on the Modified Adjudication Confirmation modal
    And I click the confirm button on the adjudication message modal