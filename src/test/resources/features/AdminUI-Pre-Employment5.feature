Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC49694 @TC48788 @TC48792 @amazonRegression
  Scenario: Admin UI - Bulk Upload Search- retrieve and display matching results while searching order
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    When I click the Manage Orders Tab "Bulk Orders"
    Then I verify Bulk Orders page displays in the Admin UI
    And I click on the bulk upload button in the Admin UI
    And I select a package "OralTox" for the bulk upload in the Admin UI
    And I select a Reason for Test "Pre-employment" for the bulk upload in the Admin UI
    And I wait for 1 seconds
    And I insert the data into the blank batch spreadsheet for the bulk upload in the Admin UI
      | Candidate: Candidate ID | Candidate: First Name | Candidate: Last Name | Candidate: Date of Birth | Candidate: National ID Number | Candidate: Mobile Phone | Candidate: External Email | Candidate: Current Mailing Street | Candidate: Current Mailing City | Candidate: Current Mailing State/Province | Candidate: Current Mailing Zip/Postal Code |
      | CID061949000            | TH33                  | TH-01-1133           | 1/1/1980                 | 678-88-1133                   | 8045988977              | tonia.hines@fadv.com      | 123 W Main St                     | Buford                          | GA                                        | 30518                                      |
    And I click the submit button on the bulk upload screen in the Admin UI
    And I verify the batch upload completed Successfully for the Admin UI
    And I verify chronological order exists for items in the Bulk Order List in the Admin UI
    And I filter by the package name "OralTox" in the Bulk Orders List in the Admin UI
    And I verify the Batch File "AutoBulkUploadFile" is placed at the top of the Bulk Orders list in the Admin UI
    And I filter by the Bulk Upload Status "Completed Successfully" in the Bulk Orders List in the Admin UI
    And I verify the Batch File "AutoBulkUploadFile" is in the Bulk Orders list of the Admin UI
    And I verify that only "Completed Successfully" status appear in the Bulk Orders list of the Admin UI
    And I set the start date range for month "November" and day "14" of the current year for Bulk Upload Orders
    And I set the end data range to current day for Bulk Upload Orders in the Admin UI
    And I verify the Batch File "AutoBulkUploadFile" is in the Bulk Orders list of the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC55072 @TC48766 @TC48782 @amazonRegression
  Scenario: Admin UI - Bulk Orders:  Bulk Upload Status filter
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    When I click the Manage Orders Tab "Bulk Orders"
    Then I verify Bulk Orders page displays in the Admin UI
    And I verify the bulk upload button displays in the Admin UI
    And I click on the bulk upload button in the Admin UI
    And I verify the Bulk Spreadsheet Upload Screen appears in the Admin UI
    And I select a package "OralTox" for the bulk upload in the Admin UI
    And I select a Reason for Test "Pre-employment" for the bulk upload in the Admin UI
    And I add a blank batch spreadsheet to use for bulk upload in the Admin UI
    And I click the submit button on the bulk upload screen in the Admin UI
    And I filter by the Bulk Upload Status "Completed With Errors" in the Bulk Orders List in the Admin UI
    And I verify the Batch File "KeepBlankBulkUploadFile" is in the Bulk Orders list of the Admin UI
    And I verify that only "Completed With Errors" status appear in the Bulk Orders list of the Admin UI
    And I verify the Bulk Upload Status should be "Processing, Completed With Errors, Completed" in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC48784 @TC48790 @TC48786 @amazonST
  Scenario: Admin UI - Bulk Orders: select package, reason for test and upload the file on Bulk Orders Submissions page
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    When I click the Manage Orders Tab "Bulk Orders"
    Then I verify Bulk Orders page displays in the Admin UI
    And I verify the bulk upload button displays in the Admin UI
    And I click on the bulk upload button in the Admin UI
    And I verify the Bulk Spreadsheet Upload Screen appears in the Admin UI
    And I verify the Bulk Spreadsheet Upload package selection dropdown in the Admin UI displays text: Choose a Package
    And I verify the submit button on the bulk upload screen is disabled in the Admin UI
    And I select a package "OralTox" for the bulk upload in the Admin UI
    And I verify the Bulk Spreadsheet Upload reason selection dropdown in the Admin UI displays text: Choose a Reason For Test
    And I select a Reason for Test "Pre-employment" for the bulk upload in the Admin UI
    And I use an invalid file format for bulk upload in the Admin UI
    And I verify the unsupported file format error message appears on the Bulk Spreadsheet Upload screen in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC56094 @TC56095 @amazonST
  Scenario: Admin UI - Bulk Orders - System should display number of orders with successfully processed and failed
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Bulk Orders"
    And I verify Bulk Orders page displays in the Admin UI
    And I click on the bulk upload button in the Admin UI
    And I select a package "OralTox" for the bulk upload in the Admin UI
    And I select a Reason for Test "Pre-employment" for the bulk upload in the Admin UI
    And I insert the data into the blank batch spreadsheet for the bulk upload in the Admin UI
      | Candidate: Candidate ID | Candidate: First Name | Candidate: Last Name | Candidate: Date of Birth | Candidate: National ID Number | Candidate: Mobile Phone | Candidate: External Email | Candidate: Current Mailing Street | Candidate: Current Mailing City | Candidate: Current Mailing State/Province | Candidate: Current Mailing Zip/Postal Code |
      | CID061948900            | TH89                  | TH-01-1189           | 1/1/1980                 | 678-88-1189                   | 8045988977              | tonia.hines@fadv.com      | 123 W Main St                     | Buford                          | GA                                        | 30518                                      |
    And I click the submit button on the bulk upload screen in the Admin UI
    And I wait for 5 seconds
    When I click the detail icon for the batch upload file "AutoBulkUploadFile" in the Admin UI
    Then I verify the Bulk Upload Item Details Screen appears in the Admin UI
    And I verify the Bulk Upload Item Details Error Orders Status is "None"
    And I click the back button on the Bulk Upload Item Details screen of the Admin UI
    And I verify Bulk Orders page displays in the Admin UI
    And I click on the bulk upload button in the Admin UI
    And I select a package "OralTox" for the bulk upload in the Admin UI
    And I select a Reason for Test "Pre-employment" for the bulk upload in the Admin UI
    And I add a blank batch spreadsheet to use for bulk upload in the Admin UI
    And I click the submit button on the bulk upload screen in the Admin UI
    And I wait for 5 seconds
    And I verify Bulk Orders page displays in the Admin UI
    And I click the detail icon for the batch upload file "KeepBlankBulkUploadFile" in the Admin UI
    And I verify the Bulk Upload Item Details Screen appears in the Admin UI
    And I verify the Bulk Upload Item Details Error Orders Status is "Get Error File"
    And I verify the Bulk Upload Item Details Error Orders Summary is "1 / 1" in the Admin UI
    And I verify the Bulk Upload Item Order Details is "0 / 1" in the Admin UI
    And I click the back button on the Bulk Upload Item Details screen of the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC64123 @TC64155 @TC64156 @TC64158 @TC64159 @amazonRegression
  Scenario: AdminUI-Final Test Result Selection Page: 'view example' button for inconclusive, retest, clear
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | Pre            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | ssn           | [gennum:4]     |

    And I navigate to the applicant welcome screen
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
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "TEST" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify that I am on the Four Eyes Check page in Admin UI
    And I click the inconclusive button for adjudication
    And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
    And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    When I click on the Certify button on the Four Eyes Check Page in Admin UI
    And I can verify that I am on the Final Test Result Selection page in the Admin UI
    And I wait for 2 seconds
    Then I verify that the view example button is enabled for Clear Option in Admin UI
    And I click the view example button for Clear Option in Admin UI
    And I wait for 15 seconds
    And I verify that the Clear pictures example page is shown in Admin UI
    And I wait for 2 seconds
    And I click the close button on the picture example page in the Admin UI
    And I wait for 2 seconds
    And I verify that the view example button is enabled for Inconclusive Option in Admin UI
    And I click the view example button for Inconclusive Option in Admin UI
    And I wait for 10 seconds
    And I verify that the Inconclusive pictures example page is shown in Admin UI
    And I click the close button on the picture example page in the Admin UI
    And I verify that the view example button is enabled for Retest Option in Admin UI
    And I click the view example button for Retest Option in Admin UI
    And I wait for 10 seconds
    And I verify that the Retest pictures example page is shown in Admin UI
    And I wait for 2 seconds
    And I click the close button on the picture example page in the Admin UI
    And I wait for 2 seconds
    And I can verify the Retest picture example page is closed in Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC63855 @TC63853 @TC63856 @TC63858 @amazonRegression
  Scenario: AdminUI-4 Eyes Check Page: 'view example' button for inconclusive, retest, clear
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | Pre            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | ssn           | [gennum:4]     |

    And I navigate to the applicant welcome screen
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
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "TEST" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    When I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify that I am on the Four Eyes Check page in Admin UI
    And I wait for 2 seconds
    Then I verify that the view example button is enabled for Clear Option in Admin UI
    And I click the view example button for Clear Option in Admin UI
    And I wait for 15 seconds
    And I verify that the Clear pictures example page is shown in Admin UI
    And I wait for 2 seconds
    And I click the close button on the picture example page in the Admin UI
    And I wait for 2 seconds
    And I verify that the view example button is enabled for Inconclusive Option in Admin UI
    And I click the view example button for Inconclusive Option in Admin UI
    And I wait for 10 seconds
    And I verify that the Inconclusive pictures example page is shown in Admin UI
    And I click the close button on the picture example page in the Admin UI
    And I verify that the view example button is enabled for Retest Option in Admin UI
    And I click the view example button for Retest Option in Admin UI
    And I wait for 10 seconds
    And I verify that the Retest pictures example page is shown in Admin UI
    And I wait for 2 seconds
    And I click the close button on the picture example page in the Admin UI
    And I wait for 2 seconds
    And I can verify the Retest picture example page is closed in Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC56096 @amazonRegression
  Scenario: Admin UI - Bulk Orders - System should download error sheet on Order details view
    Given I cleanup existing files in the downloads folder
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Bulk Orders"
    And I verify Bulk Orders page displays in the Admin UI
    And I click on the bulk upload button in the Admin UI
    And I select a package "OralTox" for the bulk upload in the Admin UI
    And I select a Reason for Test "Pre-employment" for the bulk upload in the Admin UI
    And I add a blank batch spreadsheet to use for bulk upload in the Admin UI
    And I click the submit button on the bulk upload screen in the Admin UI
    And I wait for 5 seconds
    And I verify Bulk Orders page displays in the Admin UI
    And I click the detail icon for the batch upload file "KeepBlankBulkUploadFile" in the Admin UI
    And I verify the Bulk Upload Item Details Screen appears in the Admin UI
    And I verify the Bulk Upload Item Details Error Orders Status is "Get Error File"
    When I click on the Bulk Upload Item Details Get Error File link in the Admin UI
    And I wait for 10 seconds
    Then I verify the required message appears for the missing or invalid social security number field or value


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC55203 @amazonRegression
  Scenario:Admin UI - Login successfully after removing the trailing whitespace in the order created from Admin UI
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
    And I enter the Candidate ID Number "123453333844" on the Identification Information Screen
    And I enter First Name "  Kendall  " on the Identification Information Screen
    And I enter Last Name "       Fireside       " on the Identification Information Screen
    And I enter Social Security Number "123-48-5004" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "281-236-1477" for the order in the Admin UI
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
    And I navigate to applicant UI screen using the alias "STL8" for orders created via Admin UI
    And I click the speech play button on the start screen
    When I enter the Applicant Last Name "Fireside", Birthday "01/01/2001", and SSN "5004"
    And I click the get started button on the Get Started screen
    Then I verify that the Applicant is navigated to Enter Booth Number Page

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC64028 @TC64029 @TC64030 @TC64031 @TC64032 @amazonRegression
  Scenario: AdminUI- Adjudication Page: 'view example' button for inconclusive, retest, clear
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | A[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | ssn           | [gennum:4]     |

    And I navigate to the applicant welcome screen
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
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "TEST" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    When I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I verify the adjudicating screen appears
    And I wait for 2 seconds
    Then I verify that the view example button is enabled for Clear Option in Admin UI
    And I click the view example button for Clear Option in Admin UI
    And I wait for 15 seconds
    And I verify that the Clear pictures example page is shown in Admin UI
    And I wait for 2 seconds
    And I click the close button on the picture example page in the Admin UI
    And I wait for 2 seconds
    And I verify that the view example button is enabled for Inconclusive Option in Admin UI
    And I click the view example button for Inconclusive Option in Admin UI
    And I wait for 10 seconds
    And I verify that the Inconclusive pictures example page is shown in Admin UI
    And I click the close button on the picture example page in the Admin UI
    And I verify that the view example button is enabled for Retest Option in Admin UI
    And I click the view example button for Retest Option in Admin UI
    And I wait for 10 seconds
    And I verify that the Retest pictures example page is shown in Admin UI
    And I wait for 2 seconds
    And I click the close button on the picture example page in the Admin UI
    And I wait for 2 seconds
    And I can verify the Retest picture example page is closed in Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment5 @TC69871 @amazonST
  Scenario: Admin UI - Placed Orders: After Adjudicating 'Retest', Orders are not found in the Placed Orders Grid
    Given a request for CreateOrder and POST to the api
      | json field    | new value  |
      | firstName     | Mike       |
      | lastName      | Tompson    |
      | deviceType    | oralTox    |
      | reasonForTest | PRE        |
      | wellnessId    | [gennum:9] |
      | EACaseId      | [gennum:9] |
    And I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Tompson", Birthday "01/01/2000", and SSN "0156"
    And I click the get started button on the Get Started screen
    And I enter booth number "7" into Enter Booth Number Page in Applicant UI
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
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds
    And I click on the location link for "TEST" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the Retest button on the Admin UI
    And I select the reason for Invalid option "Other - enter details below"
    And I enter a comment "Test" for the invalid reason
    And I enter the consent signature for the Admin adjudication
    And I click certify and submit button for the adjudication
    And I click the confirm button on the adjudication message modal
    And I wait for 3 seconds
    And I click on the menu and choose Manage Orders
    And I wait for 2 seconds
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    And I filter by the name "Mike Tompson" in the Placed Orders List in the Admin UI
    And I wait for 2 seconds
    And I verify that the status of the order is invalid
    And I verify retake Test screen appears
    And I click the Next button
    And I click on the menu and choose Manage Orders
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    When I filter by the name "Mike Tompson" in the Placed Orders List in the Admin UI
    And I wait for 2 seconds
    Then I verify that the status of the order is in progress

