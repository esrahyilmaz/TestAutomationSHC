@sideAlley
Feature: Room Admin UI - Side Alley
  This feature is related to the Admin UI Side Alley of a Room Admin when the system has been offline
  and returned back online to synch the completed orders


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC47110 @amazonRegression
  Scenario: Admin UI - Side Alley- System returns message for status Adjudication, Inconclusive, Abandoned or Negative
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
    When I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I navigate to applicant UI screen using the alias "STL8" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant information retrieved from the Admin UI order
    And I click the get started button on the Get Started screen
    And I enter the booth number "8" into get started screen in the Applicant UI
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
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the drugscreen results
    And I wait for 7 seconds
    And I verify the photo is uploaded
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And I click on the menu and choose COC Conversion
    And I verify that I'm on the Side Alley Get Started Page
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    Then I can verify the message appears for enrollment completed


  @amazonSelfCollect @AdminUI @AdminUISideAlley @TC47108  @amazonRegression
  Scenario: Admin UI - Side Alley- System returns Candidates with status New, In progress, Re-take
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
    And I enter the Candidate ID Number "123453333888" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    When I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    Then I verify the auto-generated Admin UI candidate displays on the candidate results screen
    And I navigate to applicant UI screen using the alias "STLB" for orders created via Admin UI
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
    And the login page for Room Admin UI is showing in the browser
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I verify the auto-generated Admin UI candidate displays on the candidate results screen
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 60 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the drugscreen results
    And I wait for 7 seconds
    And I verify the photo is uploaded
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And I click on the location link for "STLB" in the Admin UI
    And I click the auto-generated candidate created via Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 3 seconds
    And I click the Retake Photo button on the Admin UI adjudication screen
    And I wait for 3 seconds
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I verify the auto-generated Admin UI candidate displays on the candidate results screen
    And I close the current browser


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC47114 @TC4929 @amazonRegression
  Scenario: Admin UI - Side Alley- System should return a message if candidate is not available
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    When I enter the last name "Grande" to lookup the candidate order in the Admin UI
    And I enter the month "01" day "01" year "2000" for date of birth to lookup the candidate order in the Admin UI
    And I enter the last four digits for social security number "1234" to lookup the candidate order in the Admin UI
    And I click on the get started button for Side Alley
    Then I verify the candidate not found page appears in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC35778 @TC35654 @amazonST
  Scenario: Admin UI - Admin should be able to continue with side Alley process if search finds any matching result
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I verify that I'm on the Side Alley Get Started Page
    And I enter auto-created candidate's information to lookup on the get Started screen
    When I click on the get started button for Side Alley
    Then I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify the Photo Rules Page appears in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC35772 @amazonST
  Scenario: Admin UI - If search result doesn't match - Side Alley Candidate Search Results
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I verify the Get Started page is displayed in the Admin UI
    And I enter the last name "Test" to lookup the candidate order in the Admin UI
    And I enter the month "12" day "01" year "1970" for date of birth to lookup the candidate order in the Admin UI
    And I enter the last four digits for social security number "7554" to lookup the candidate order in the Admin UI
    And I click on the get started button for Side Alley
    Then I verify the candidate not found page appears in the Admin UI
    And I verify the Create New Order button on the Candidate Not Found page displays in the Admin UI
    And I verify Try Another Id button displays in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC45649 @amazonST
  Scenario: Admin UI - Side Alley: No Location- navigate to Candidate Results on back button click
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
    And I enter the Candidate ID Number "123453657888" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And  I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I verify the Order Photo Rules Page appears in the Admin UI
    When I click the side Alley back button in the Admin UI
    Then I can verify the Candidate Results screen displays


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC45650 @amazonST
  Scenario: Admin UI - Side Alley: Assigned Location- navigate to Candidate Results on Back button click
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | Loc[gennum:3]   |
      | lastName      | Las[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify the Order Photo Rules Page appears in the Admin UI
    When I click the side Alley back button in the Admin UI
    Then I can verify the Candidate Results screen displays


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC39496 @amazonRegression
  Scenario: Admin UI - System should read the QR code and validate the QR code and display ERROR if QR code is duplicate
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I click on I'm ready to take the photo button
    And I upload a QR readable duplicate device picture
    When I click on I'm happy with my photo button in the Admin UI
    Then I verify that the error message is given for duplicate device


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC35658 @TC35673 @TC35674 @amazonRegression
  Scenario: Admin UI - Side Alley: Admin should be navigated to Order Submitted page after submitting the order
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I click on I'm ready to take the photo button
    And I upload the photo of my device in Side Alley
    And I click on I'm happy with my photo button in the Admin UI
    And I click on I'm ready to take the photo button COC
    And I upload the photo of my COC form in Side Alley
    And I click on I'm ready to take the photo button
    And I verify that I'm on the Side Alley Review Page
    And I click negative in Side Alley Review Page
    And I enter the consent signature for the Admin adjudication
    When I click submit button for the order in Side Alley Review Page
    Then I verify that I'm navigated to Order Submitted Page of the Side Alley


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC36222 @amazonST
  Scenario:Admin UI - Side Alley:Admin should be navigated to upload photo if camera permission is disabled - COC File Upload Photo
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify the Photo Rules Page appears in the Admin UI
    When I click on I'm ready to take the photo button
    Then I verify that I'm on the photo upload page


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC43900 @TC43914 @TC43915 @TC43923 @amazonST
  Scenario: Admin UI - Side Alley- Admin should navigate to Photo review page when Capture the live photo of the device
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I enter the Candidate ID Number "123453333888" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "281-236-1479" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "8181 Fannin St." in the first line of the address for the order
    And I enter "Apt. #132" in the second line of the address for the order
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I enter the zip code "77054" for the order
    And I click on the submit button for the order in the Admin UI
    And I click the Done button for the order in the Admin UI
    When I click on the menu and choose COC Conversion
    And I verify the Get Started page is displayed in the Admin UI
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click on Next button on Select Location page
    And I verify the Order Photo Rules Page appears in the Side Alley
    And I click on I'm ready to take the photo button
#    And I verify that I'm on the Review your photo page
    And I verify that Upload photo Button is available in Review your photo screen SA
    And I click on Enter Specimen ID Button in SA
    And I enter the sample ID "33316236" on the Enter ID screen in SA
    Then I verify that I am on COC photo rules page


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC43918 @TC43920 @amazonST
  Scenario: Admin UI - Side Alley- System should navigate to Photo review page when I Take/Upload photo of device and QR code is read
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I enter the Candidate ID Number "123453333888" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "281-236-1479" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "8181 Fannin St." in the first line of the address for the order
    And I enter "Apt. #132" in the second line of the address for the order
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I enter the zip code "77054" for the order
    And I click on the submit button for the order in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I click on the menu and choose COC Conversion
    And I verify the Get Started page is displayed in the Admin UI
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click on Next button on Select Location page
    And I verify the Order Photo Rules Page appears in the Side Alley
    And I click on I'm ready to take the photo button
    And I upload the photo of my device in Side Alley
    And I verify that I'm on the Review your photo page
    And I verify that I'm happy with my photo Button is available in Review your photo screen SA
    And I verify that Upload photo Button is available in Review your photo screen SA
    When I click on I'm happy with my photo button in the Admin UI
    Then I verify that I am on COC photo rules page


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC38362 @amazonRegression
  Scenario: Admin UI - Side Alley : Get Started page/fields validation
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I verify the Get Started page is displayed in the Admin UI
    When I click on the get started button for Side Alley
    Then I verify All fields are required to get started message appears on Side Alley Get Started screen
    And I enter the last name "John" to lookup the candidate order in the Admin UI
    And I enter the month "01" day "01" year "2023" for date of birth to lookup the candidate order in the Admin UI
    And I enter the last four digits for social security number "1133" to lookup the candidate order in the Admin UI
    And I click on the get started button for Side Alley
    And I verify Date of Birth not valid message appears on Side Alley Get Started screen
    And I enter the month "01" day "01" year "1980" for date of birth to lookup the candidate order in the Admin UI
    And I enter the last four digits for social security number "1a09" to lookup the candidate order in the Admin UI
    And I click on the get started button for Side Alley
    And I verify SSN error message appears on Side Alley Get Started screen
    And I enter the last four digits for social security number "1133" to lookup the candidate order in the Admin UI
    And I verify that Get Started button is clickable without an error
    And I click on the get started button for Side Alley


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC44136 @TC44127 @amazonST
  Scenario:Admin UI - Side Alley Flow Changes - With Initial Location
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I can verify that the offline order has a location assigned
    And I click the auto-generated candidate on the candidate results screen
    When I click the Next button for the offline order
    Then I verify the Photo Rules Page appears in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC44121 @TC44123 @44125 @44130 @TC44131 @TC44134 @amazonST
  Scenario: Admin UI - Side Alley Flow Changes - No Initial Location
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I enter the Candidate ID Number "123453333888" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I enter the phone number "281-236-1479" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "8181 Fannin St." in the first line of the address for the order
    And I enter "Apt. #132" in the second line of the address for the order
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I enter the zip code "77054" for the order
    And I click on the submit button for the order in the Admin UI
    And I click the Done button for the order in the Admin UI
    When I click on the menu and choose COC Conversion
    Then I verify the Get Started page is displayed in the Admin UI
    And I click the browser back button
    And I verify the Get Started page is displayed in the Admin UI
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the side Alley back button in the Admin UI
    And  I verify the Get Started page is displayed in the Admin UI
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify that I am on the Select Location Page for Offline Orders
    And I click the side Alley back button in the Admin UI
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click on Next button on Select Location page
    And I verify the Order Photo Rules Page appears in the Side Alley


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC35776 @TC31888 @amazonST
  Scenario:Admin UI - Side Alley: Admin needs to be navigated to Photo rules page after selecting matching candidate
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    When I click on the get started button for Side Alley
    Then I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify the Photo Rules Page appears in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC45657 @amazonST
  Scenario: Admin UI - Side Alley - Candidate Results page - System should display all matching candidates/orders
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    When I click on the get started button for Side Alley
    Then I can verify the Candidate Results screen displays
    And I can verify the Candidate Results page has Name, DOB, Last Digits of SSN and Location columns
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "123453657888" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And  I can verify the Candidate Results screen displays
    And I can verify the order has no location assigned in Side Alley Results
    And I can verify the Next and Back buttons are available on the Candidate Results page


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC38328 @amazonST
  Scenario:Admin UI - Admin should see picture of COC form and adjudication options on 'Review' page
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I click on I'm ready to take the photo button
    And I upload the photo of my device in Side Alley
    And I click on I'm happy with my photo button in the Admin UI
    And I click on I'm ready to take the photo button COC
    And I upload the photo of my COC form in Side Alley
    When I click on I'm happy with my photo button on COC review your photo page in the Admin UI
    Then I verify that I'm on the Side Alley Review Page
    And I click negative in Side Alley Review Page
    And I click invalid option on the Side alley Review Page
    And I click the Inconclusive option on the sideAlley Review Page
    And I select the strips in the Side Alley Review Page
    And I enter the consent signature for the Admin adjudication
    And I click submit button for the order in Side Alley Review Page
    And I verify that I'm navigated to Order Submitted Page of the Side Alley


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC36223 @amazonST
  Scenario:Admin UI -  Admin should be able to click on 'Submit' button after uploading COC photo - Side Alley - COC File Upload Photo
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I click on I'm ready to take the photo button
    And I upload the photo of my device in Side Alley
    And I click on I'm happy with my photo button in the Admin UI
    And I click on I'm ready to take the photo button COC
    When I upload the photo of my COC form in Side Alley
    Then I verify that I'm happy with my photo button is enabled in the Side Alley COC photo review page
    And I click on I'm happy with my photo button on COC review your photo page in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC44137 @amazonRegression
  Scenario: Admin UI - Side Alley - System should make the location selected first time as default location for next orders
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
    And I click on the menu and choose COC Conversion
    And I verify the Get Started page is displayed in the Admin UI
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify that I am on the Select Location Page for Offline Orders
    When I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I verify the Order Photo Rules Page appears in the Side Alley
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I choose the Order Package "OralTox"
    And I choose the Package Reason "Pre-employment"
    And I click the next button for the order in the Admin UI
    And I can verify the Location Information screen is displayed
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Buford" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Identification Information screen is displayed
    And I enter the Candidate ID Number "123453386800" on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I verify the Get Started page is displayed in the Admin UI
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify that I am on the Select Location Page for Offline Orders
    Then I verify the location is set by default to the previously selected Location " Amazon "


  # this is for live photo in admin UI. Will not work correctly until mobile support is added
  @amazonSelfCollect @adminUI @AdminUISideAlley @TC39490 @TC39495 @TC39494 @TC39489 @amazonRegression
  Scenario: Admin UI - Capture Live Photo
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    When I click the Next button for the offline order
    Then I verify the Order Photo Rules Page appears in the Side Alley
    And I click on I'm ready to take the photo button
    And I wait for 7 seconds
    And I click the Cancel button
    And I verify the Take Photo screen is available
    And I verify the photo shutter is green
    And I take the photo on the camera
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC39496 @amazonRegression
  Scenario: Admin UI - System should read the QR code and validate the QR code and display ERROR is QR code is invalid
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | firstName     | FName[gennum:3]   |
      | lastName      | LName[gennum:5]   |
      | deviceType    | oralTox         |
      | reasonForTest | PRE_EMPLOYMENT  |
      | wellnessId    | [gennum:9]      |
      | EACaseId      |[gennum:9]       |

    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose COC Conversion
    And I enter auto-created candidate's information to lookup on the get Started screen
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated candidate on the candidate results screen
    And I click the Next button for the offline order
    And I verify the Order Photo Rules Page appears in the Side Alley
    And I click on I'm ready to take the photo button
    And I wait for 5 seconds
    And I upload a bad photo for Side Alley in the Admin UI
    And I wait for 3 seconds
    And I verify the COC Review your Photo screen appears in the Admin UI
    And I click on Enter Specimen ID Button in SA
    And I verify the Sample ID screen appears for Side Alley in the Admin UI
    When I enter the sample ID "34007435" on the Enter ID screen in SA
    And I wait for 3 seconds
    And I click the Next button for the offline order
    And I wait for 1 seconds
    Then I can verify the invalid device message displays for Side Alley in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC42270 @TC42282 @TC42275 @TC42279 @TC42277 @TC42276 @TC42278 @TC42272 @TC42272 @TC42280 @TC42281 @amazonST
  Scenario:Admin UI - Side Alley: Refresh Page for Photo Rules
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
    And I enter the Candidate ID Number "123453444488" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the browser refresh button
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I click the browser refresh button
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I verify the Order Photo Rules Page appears in the Admin UI
    And I click the browser refresh button
    And I verify the Order Photo Rules Page appears in the Admin UI
    And I click on I'm ready to take the photo button
    And I verify that I'm on the photo upload page
    And I click the browser refresh button
    And I verify that I'm on the photo upload page
    And I upload the photo of my device in Side Alley
    And I verify the COC Review your Photo screen appears in the Admin UI
    And I click the browser refresh button
    And I verify the Order Photo Rules Page appears in the Admin UI
    And I click the button: "happy with my photo"
#    add rest of steps once menu item is available
    #this should be a separate scenario to execute with live camera
    And I verify the Take Photo screen is available
    And I click the browser refresh button
    And I verify the Order Photo Rules Page appears in the Admin UI
#    add rest of steps once menu item is available
    And I verify the Sample ID screen appears
    And I click the browser refresh button
    And I verify the Sample ID screen appears
    And I enter the sample ID "52009522" on the Enter ID screen
    And I click the next button for the order in the Admin UI
    And I verify the COC Photo Rules Screen is displayed in the Admin UI
    And I click the browser refresh button
    And I verify the COC Photo Rules Screen is displayed in the Admin UI
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available
    And I click the browser refresh button
    And I verify the Take Photo screen is available
    And I take the photo on the camera
    And I verify the Applicant Review your Photo screen appears
    And I click the browser refresh button
    And I verify the COC Photo Rules Screen is displayed in the Admin UI
#    add rest of steps once menu item is available
    And I click the button: "happy with my photo"
    And I verify the adjudication recommendation text "Which strips were inconclusive" appears on the page
    And I click the browser refresh button
    And I verify the adjudication recommendation text "Which strips were inconclusive" appears on the page
    And I click the Inconclusive option on the sideAlley recommendation screen
    And I select test strips '1,2' as inconclusive on the sideAlley recommendation screen
    And I enter a signature for the sideAlley recommendation results
    And I click the submit button for the sideAlley uploaded photo
    And I verify the sideAlley Order Submit Conformation and Upload Successful page displays
    And I click the browser refresh button
    And I verify the sideAlley Order Submit Conformation and Upload Successful page displays


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC91651 @amazonST
  Scenario: Admin UI- System should accept the 8 digits Sample ID for existing devices When System does NOT read the QR Code
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
    And I enter the Candidate ID Number "123453444488" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I wait for 2 seconds in AdminUI
    And I verify the Order Photo Rules Page appears in the Admin UI
    And I click on I'm ready to take the photo button
    And I wait for 2 seconds in AdminUI
    And I verify that I'm on the photo upload page
    And I wait for 2 seconds in AdminUI
    And I upload the photo of my device in Side Alley
    And I wait for 2 seconds in AdminUI
    When I click on I'm happy with my photo button in the Admin UI
    And I wait for 2 seconds in AdminUI
    Then I verify the COC Photo Rules Screen is displayed in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC91653 @amazonST
  Scenario: Admin UI- System should accept the new Sample ID (2 alpha + 9 digits) for new format When System does NOT read the QR Code
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
    And I enter the Candidate ID Number "123453444488" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I wait for 2 seconds in AdminUI
    And I verify the Order Photo Rules Page appears in the Admin UI
    And I click on I'm ready to take the photo button
    And I wait for 2 seconds in AdminUI
    And I verify that I'm on the photo upload page
    And I wait for 2 seconds in AdminUI
    And I upload the photo of my device with new QR code format in Side Alley
    And I wait for 2 seconds in AdminUI
    When I click on I'm happy with my photo button in the Admin UI
    And I wait for 2 seconds in AdminUI
    Then I verify the COC Photo Rules Screen is displayed in the Admin UI


  @amazonSelfCollect @adminUI @AdminUISideAlley @TC91676 @amazonST
  Scenario: Admin UI- System should show an error message  When we enter Invalid Sample ID
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
    And I enter the Candidate ID Number "123453444488" on the Identification Information Screen
    And I enter the auto-generated Admin UI candidate's information on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the Candidates information retrieved from the Admin UI order to lookup the candidates order
    And I click on the get started button for Side Alley
    And I can verify the Candidate Results screen displays
    And I click the auto-generated Admin UI candidate on the candidate results screen
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I wait for 2 seconds in AdminUI
    And I verify the Order Photo Rules Page appears in the Admin UI
    And I click on I'm ready to take the photo button
    And I wait for 2 seconds in AdminUI
    And I verify that I'm on the photo upload page
    And I wait for 2 seconds in AdminUI
    And I upload a bad photo for Side Alley in the Admin UI
    And I click on Enter Specimen ID Button in SA
    And I wait for 2 seconds in AdminUI
    And I enter the sample ID "AD333333333" on the first field on Side-Alley
    And I enter the sample ID "" on the second field on Side-Alley
    And I click the Next button for the offline order
    And I verify All fields are required to go next message appears on Side Alley Enter ID screen
    And I wait for 2 seconds in AdminUI
    And I enter the sample ID "AD33333333R" on the first field on Side-Alley
    And I verify that sample ID format error message appears on Side Alley Enter ID screen
    And I wait for 2 seconds in AdminUI
    And I enter the sample ID "AD333333333" on the first field on Side-Alley
    And I enter the sample ID "AD333333334" on the second field on Side-Alley
    And I verify that sample ID not matching error message appears on Side Alley Enter ID screen
    And I wait for 2 seconds in AdminUI
    When I enter the sample ID "AD333333333" on the first field on Side-Alley
    And I enter the sample ID "AD333333333" on the second field on Side-Alley
    And I click the Next button for the offline order
    And I wait for 2 seconds in AdminUI
    Then I verify the COC Photo Rules Screen is displayed in the Admin UI

    #Need rest of steps once side alley is wired up with backend. commenting out for now
  @amazonSelfCollect @adminUI @AdminUISideAlley @TC36936 @TC36937 @TC36871 @amazonST
  Scenario: Admin UI - Admin should be able to click on 'Submit' button once upload the photo - Side Alley File Upload Photo
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the drugscreen results
    And I verify the photo is uploaded
    And I click the submit button for the sideAlley uploaded photo
    And I verify the Sample ID screen appears
    And I enter the sample ID "11111118" on the Enter ID screen
    And I click the Next button


  ##Need rest of steps once side alley is wired up with backend. commenting out for now
  @amazonSelfCollect @adminUI @AdminUISideAlley @TC32313 @TC32311 @TC32312 @amazonST
  Scenario: Admin UI - Admin should be navigate to CoC photo review page once clicked on 'I'm ready to take the photo' button on CoC Photo Rules
    Then I verify the COC Photo Rules Screen is displayed in the Admin UI
    And I verify the COC Photo Rules text "Place the chain of custody form on the table" appears on the page
    And I verify the COC Photo Rules text "Make sure we can clearly see the" appears on the page
    And I verify the back button appears on the screen
    And I click the back button
    And I verify the COC Review your Photo screen appears in the Admin UI
    And I click the button: "happy with my photo"
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available


    # add adminUI tag back once offline orders menu is officially visible
  @amazonSelfCollect @adminUI @AdminUISideAlley @TC39496 @amazonST
  Scenario: Admin UI - System should read the QR code and validate the QR code and display ERROR is QR code is expired
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
    And I enter the Candidate ID Number "123453384000" on the Identification Information Screen
    And I enter First Name "Chucky" on the Identification Information Screen
    And I enter Last Name "Cheese3" on the Identification Information Screen
    And I enter Social Security Number "123-44-5022" on the Identification Information Screen
    And I enter Date of Birth  "01/01/1978" on the Identification Information Screen
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
    And I click on the menu and choose COC Conversion
    And I enter the last name "Cheese3" to lookup the candidate order in the Admin UI
    And I enter the month "01" day "01" year "1978" for date of birth to lookup the candidate order in the Admin UI
    And I enter the last four digits for social security number "5022" to lookup the candidate order in the Admin UI
    And I click the get started button on Admin UI
    And  I can verify the Candidate Results screen displays
    And I select the Candidate by last name "Cheese3" on the Candidate Results screen for the offline order
    And I click the Next button for the offline order
    And I set the Testing Location " Amazon " for the offline order to begin
    And I click the Next button for the offline order
    And I verify the COC Review your Photo screen appears in the Admin UI
    And I click the button: I'm ready to take a photo
    And I upload the photo of the drugscreen results
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    When I enter the sample ID "33307431" on the Enter ID screen
    And I click the Next button
    Then I can verify the expired device message displays
