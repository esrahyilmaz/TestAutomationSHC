Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC38943 @TC38949 @TC40581 @amazonRegression
  Scenario:Admin UI - Create Order: System should display a confirmation message after an order submitted, done Button navigates Placed Orders
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
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Pete" on the Identification Information Screen
    And I enter Social Security Number "123-44-5544" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "281-236-1479" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    And I click the browser back button
    And I can verify the Residence Information screen is displayed
    And I can verify the Country is present for the order in the Admin UI
    And I verify the address first line is present on the Residence Screen
    And I verify the address second line is present on the Residence Screen
    And I can verify the City is present for the order within the Admin UI
    And I can verify the State is present for the order in the Admin UI
    And I can verify Zip Code is present for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "8181 Fannin St." in the first line of the address for the order
    And I enter "Apt. #132" in the second line of the address for the order
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I enter the zip code "77054" for the order
    When I click on the submit button for the order in the Admin UI
    And I wait for 1 seconds in AdminUI
    Then I verify the Done button displays in the Admin UI
    And I click Done button on the Order Submit Confirmation page
    And I verify that I navigate to Placed Orders page


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC40582 @amazonST
  Scenario:Admin UI - Create Order: Create New Order button on the Order submit confirmation message navigates to Create New Order Widget
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
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Pete" on the Identification Information Screen
    And I enter Social Security Number "123-44-5544" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    And I click the browser back button
    And I can verify the Residence Information screen is displayed
    And I can verify the Country is present for the order in the Admin UI
    And I verify the address first line is present on the Residence Screen
    And I verify the address second line is present on the Residence Screen
    And I can verify the City is present for the order within the Admin UI
    And I can verify the State is present for the order in the Admin UI
    And I can verify Zip Code is present for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I wait for 2 seconds in AdminUI
    When I click Create New Order button on the Order Submit Confirmation page
    Then I verify that I navigate to Create New Order widget


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC38965 @TC38968 @amazonRegression
  Scenario: Admin UI - Placed Orders: All Placed orders needs to be displayed in chronological order
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | A[gennum:5]    |
      | lastName      | Zain[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
    And the login page for Room Admin UI is showing in the browser
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
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Pete" on the Identification Information Screen
    And I enter Social Security Number "123-44-5544" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    When I click on the menu and choose Manage Orders
    And I click ok on confirmation popup window in Admin UI
    Then I verify column headers in Placed Orders Page are Name, SSN, DOB, Created, Status,Location, Order Id, Package, One Strip
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    And I verify incomplete orders are listed with Incomplete Status
    And I verify chronological order exists for items in the Placed Order List in the Admin UI
    And I verify orders are sorted in descending order according to Created Column in Placed Orders List


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC45662 @amazonST
  Scenario:Admin UI - Placed Orders Updates: Confirmation Page updates
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
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Pete" on the Identification Information Screen
    And I enter Social Security Number "123-44-5544" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "281-236-1479" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "8181 Fannin St." in the first line of the address for the order
    And I enter "Apt. #132" in the second line of the address for the order
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I enter the zip code "77054" for the order
    When I click on the submit button for the order in the Admin UI
    And I wait for 2 seconds in AdminUI
    Then I verify the Done button displays in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC44143 @amazonST
  Scenario: Admin UI - Manage Orders: Filtering for Placed Orders View
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
    And I enter the Candidate ID Number "123453389011" on the Identification Information Screen
    And I enter First Name "Kendall" on the Identification Information Screen
    And I enter Last Name "Fireside" on the Identification Information Screen
    And I enter Social Security Number "123-48-5005" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2000" on the Identification Information Screen
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
    When I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    Then I verify the Done button displays in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I can verify the Placed Order screen is displayed
    And I filter by the name "Kendall Fireside" in the Placed Orders List in the Admin UI
    And I verify the candidate "Fireside, Kendall" is placed at the top of the Placed Orders list in the Admin UI
    And I clear the name filter of the Placed Orders List in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I filter by the last four social security number "5005" in the Placed Orders List in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I verify the candidate "Fireside, Kendall" is placed at the top of the Placed Orders list in the Admin UI
    And I clear the social security number filter of the Placed Orders List in the Admin UI
    And I filter by Status "New" in the Placed Orders List in the Admin UI
    And I verify the candidate "Fireside, Kendall" is placed at the top of the Placed Orders list in the Admin UI
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    And I set the start date range for month "September" and day "18" of the current year for Placed Orders
    And I wait for 2 seconds in AdminUI
    And I set the end date range to current day Placed Orders
    And I wait for 2 seconds in AdminUI
    And I verify the candidate "Fireside, Kendall" is placed at the top of the Placed Orders list in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC38353 @TC38359 @amazonST
  Scenario: Admin UI - Placed Orders: Ascending arrows sort the placed order columns in ascending order
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | B[gennum:5]     |
      | lastName      | AutoS[gennum:5] |
      | deviceType    | oralTox         |
      | reasonForTest | PRE             |
      | wellnessId    | [gennum:9]      |
      | EACaseId      | [gennum:9]      |
    And  a request for CreateOrder and POST to the api
      | json field    | new value   |
      | firstName     | A[gennum:5] |
      | lastName      | Z[gennum:5] |
      | deviceType    | oralTox     |
      | reasonForTest | PRE         |
      | wellnessId    | [gennum:9]  |
      | EACaseId      | [gennum:9]  |
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    When I click on the arrow next to SSN column in Placed Orders List
    Then I verify orders are sorted in ascending order according to SSN column in Placed Orders List
    And I click on the arrow next to SSN column in Placed Orders List
    And I verify orders are sorted in descending order according to SSN column in Placed Orders List
    And I click on the arrow next to Created column in Placed Orders List
    And I verify orders are sorted in ascending order according to Created Column in Placed Orders List
    And I click on the arrow next to Created column in Placed Orders List
    And I verify orders are sorted in descending order according to Created Column in Placed Orders List

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC31861 @amazonST
  Scenario: Admin UI - Create Order - Identification Form - SSN
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
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    When I enter Social Security Number "123-44-567" on the Identification Information Screen
    Then I can verify that Social Security Number error message appears
    And I enter Social Security Number "123-44-567899" on the Identification Information Screen
    And I can verify that Social Security Number error message appears
    And I enter Social Security Number "abc-44-5678" on the Identification Information Screen
    And I can verify that Social Security Number error message appears
    And I enter Social Security Number "123-44-5678" on the Identification Information Screen
    And I can verify social Security Number is valid

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC49735 @amazonST
  Scenario: Admin UI: When Room Monitor pulls up a Candidate's Card for adjudication, should be able to see the booth number on the card
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | ssn           | [gennum:4]     |

    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I enter booth number "99" into Enter Booth Number Page in Applicant UI
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
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    When I click on the location link for "CLT4" in the Admin UI
    And I wait for 4 seconds
    Then I verify the candidate card has booth number "99" in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC49694 @TC48788 @TC48792 @amazonRegression @bulkUpload
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
      | Errors | Candidate: Candidate ID | Candidate: First Name | Candidate: Last Name | Candidate: Date of Birth | Candidate: National ID Number | Candidate: Mobile Phone | Candidate: External Email | Candidate: Current Mailing Street | Candidate: Current Mailing City | Candidate: Current Mailing State/Province | Candidate: Current Mailing Zip/Postal Code |
      |        | CID061949000            | TH33                  | TH-01-1133           | 1/1/1980                 | 678-88-1133                   | 8045988977              | tonia.hines@fadv.com      | 123 W Main St                     | Buford                          | GA                                        | 30518                                      |
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


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC56923 @amazonRegression
  Scenario: Admin UI: In progress cards Ghost Card
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    When I click on the location link for "CLT4" in the Admin UI
    And I open a new browser window
    And the login page for Room Admin UI is showing in the browser
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 5 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "123456789000" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I wait for 3 seconds in AdminUI
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    And I switch to parent window
    Then I can verify the non active candidate card is not appearing on the Test In Progress Tab


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment4 @TC52539 @amazonRegression
  Scenario: Admin UI - Display location name (alias) on Placed Orders grid
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
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I wait for 5 seconds in AdminUI
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-0324" for the order in the Admin UI
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
    And I enter the Applicant information retrieved from the Admin UI order and  without booth number
    And I click the get started button on the Get Started screen
    And I wait for 2 seconds in AdminUI
    And I click on the menu and choose Manage Orders
    And I clear the order statuses filter of the Placed Orders List in the Admin UI
    And I filter by the name "name" in the Placed Orders List in the Admin UI
    When I filter the generated candidate in Placed Orders List
    Then I verify the location "CLT4" is assigned for the candidate in the Admin UI
