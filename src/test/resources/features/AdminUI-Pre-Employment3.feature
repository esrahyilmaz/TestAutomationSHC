Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31478 @TC31492 @TC31484 @TC35672 @81578 @amazonST
  Scenario: Admin UI - Residence Form: Entering Address Information
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
    When I click the next button for the order in the Admin UI
    Then I can verify the Residence Information screen is displayed
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
    And I verify the Order completed message in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31490 @amazonST
  Scenario: Admin UI - Residence Form: Previous Button
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
    And I enter the Candidate ID Number "123456779011" on the Identification Information Screen
    And I enter First Name "Burt" on the Identification Information Screen
    And I enter Last Name "Bees" on the Identification Information Screen
    And I enter Social Security Number "403-44-5544" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed
    When I can click the previous button for the order in the Admin UI
    Then I can verify the Contact Information screen is displayed
    And I verify the phone number "(678) 546-3324" is retained on the Contact Info Screen for the order in the Admin UI
    And I verify the email address "tonia.hines@fadv.com" is retained on the Contact Info Screen for the order in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31485 @TC31480 @TC31461 @TC31487 @amazonST
  Scenario: Admin UI - Contact Information Form: Next button navigates to the Residence Form
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
    And I enter the Candidate ID Number "123455379011" on the Identification Information Screen
    And I enter First Name "Kurt" on the Identification Information Screen
    And I enter Last Name "Cees" on the Identification Information Screen
    And I enter Social Security Number "403-45-5544" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2002" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter the phone number "678-552-3324" for the order in the Admin UI
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the browser back button
    And I can verify the Contact Information screen is displayed
    When I click the next button for the order in the Admin UI
    Then I can verify the Residence Information screen is displayed


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31486 @amazonST
  Scenario: Admin UI - Contact Information Form: Previous Button
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
    And I enter the Candidate ID Number "123456779211" on the Identification Information Screen
    And I enter First Name "Kay" on the Identification Information Screen
    And I enter Last Name "Teez" on the Identification Information Screen
    And I enter Social Security Number "403-33-5544" on the Identification Information Screen
    And I enter Date of Birth  "05/02/1970" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    When I can click the previous button for the order in the Admin UI
    Then I verify the Candidate Id Number "123456779211" is retained on the identification screen
    And I verify the first name "Kay" is retained on the identification screen
    And I verify the last name "Teez" is retained on the identification screen
    And I verify the date of birth "05/02/1970" is retained on the identification screen


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31481 @amazonRegression
  Scenario: Admin UI - Contact Information Form: Invalid Format
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I enter the Candidate ID Number "123456778211" on the Identification Information Screen
    And I enter First Name "Matt" on the Identification Information Screen
    And I enter Last Name "Zee" on the Identification Information Screen
    And I enter Social Security Number "403-33-5546" on the Identification Information Screen
    And I enter Date of Birth  "05/02/1970" on the Identification Information Screen
    When I click the next button for the order in the Admin UI
    Then I can verify the Contact Information screen is displayed
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter the phone number "(678)546-#f" for the order in the Admin UI
    And I can verify the next button is disabled for the order in the Admin UI
    And I can verify the invalid phone number message displays for the order in the Admin UI
    And I enter the email address "tonia.hinesfadvcom" for the order in the Admin UI
    And I can verify the invalid email address message displays for the order in the Admin UI
    And I can verify the next button is disabled for the order in the Admin UI
    And I re-enter the phone number "678-546-3324" for the order in the Admin UI
    And I re-enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Residence Information screen is displayed

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31859 @amazonRegression
  Scenario: Admin UI - Identification Form: Candidate ID Invalid Format
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I click the next button for the order in the Admin UI
    When I enter the Candidate ID Number "1" on the Identification Information Screen
    Then I verify the invalid CID message appear under the CID field
    And I enter the Candidate ID Number "123456789124" on the Identification Information Screen
    And I enter First Name "Anna" on the Identification Information Screen
    And I enter Last Name "Johns" on the Identification Information Screen
    And I enter Social Security Number "123-44-5678" on the Identification Information Screen
    And I enter Date of Birth  "01012001" on the Identification Information Screen
    And I can verify the next button is enabled for the order in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31858 @amazonRegression
  Scenario: Admin UI - Identification Form: Disable "Next" button
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    When I click the next button for the order in the Admin UI
    Then I can verify the next button is disabled for the order in the Admin UI
    And I enter the Candidate ID Number "123456789000" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter First Name "Alma" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Last Name "Pims" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Social Security Number "123-44-5678" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I verify the next button is enabled for the order in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC31868 @amazonST
  Scenario: Admin UI - Identification Form: DOB Format
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    When I click the next button for the order in the Admin UI
    Then I can verify the next button is disabled for the order in the Admin UI
    And I enter the Candidate ID Number "123456789000" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter First Name "Alma" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Last Name "Pims" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Social Security Number "123-44-5678" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I verify the next button is enabled for the order in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC38812 @amazonST
  Scenario: AdminUI - Create Order: Redirect Completed Order to First Steps of New Order
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
    When I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    When I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    Then I verify the Done button displays in the Admin UI
    And I verify the Create New Order button displays in the Admin UI
    And I click the Create New Order button on the submitted Order Page of the Admin UI
    And I can verify the Location Information screen is displayed


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC38818 @amazonST
  Scenario: AdminUI - Create Order: Navigation to Placed orders page by clicking Done button
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
    And I enter First Name "Stacey" on the Identification Information Screen
    And I enter Last Name "Letters" on the Identification Information Screen
    And I enter Social Security Number "123-48-5144" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2002" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I wait for 1 seconds in AdminUI
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
    And I wait for 3 seconds in AdminUI
    And I verify the candidate "Letters, Stacey, 5144" is placed at the top of the Placed Orders list in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment3 @TC41308 @amazonRegression
  Scenario Outline: Admin UI - Upload Photo: Submit Image Step State for Applicant's Card
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | A[gennum:5]     |
      | lastName      | AutoS[gennum:5] |
      | deviceType    | oralTox         |
      | reasonForTest | PRE             |
      | wellnessId    | [gennum:9]      |
      | EACaseId      | [gennum:9]      |

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
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    When I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I click on the location link for "CLT4" in the Admin UI
    Then validate candidate info
      | name                     | step             |
      | data.runtime.invite-name | Processing Image |


    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |

