@oraleze
Feature: Oral-Eze Applicant UI Pre-employment

  Background: Generate Candidate data
    Given a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralEze       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
      | ssn           | [gennum:4]    |


  @amazon30 @TC2435 @TC2437 @applicantUI
  Scenario: OralEze Step 6 Seal the device and click back button
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "9" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    When I click the Next button
    Then I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Oval-Eze Seal device Screen appears
    And I click the back button
    And I verify the Oal-Eze Close the Cap Screen appears

#  @TC2390 @amazon30 @applicantUI
#  Scenario: OralEze Get Help Icon on welcome page
#    Given I navigate to the applicant welcome screen
#    And I enter the Applicant information without booth information
#    When I click the Get Help icon
#    And I wait for 5 seconds
#    Then I can verify the help content screen appears with content text "How do I contact someone for help?"
#    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
#    And I verify the Request Help button exists on the Help Screen
#    And I click the button: Found My Answer
#    And I click the get started button on the Get Started screen
#    And I can verify the Applicant Review Information screen appears


  @amazon30  @TC3665 @applicantUI
  Scenario: Applicant UI: OralEze - Sealed Device Picture of Donor's Initial Photo Rules
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "10" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    When I verify the Take Photo screen is available
    And I take the photo on the camera
    And I wait for 3 seconds
    And I click the button: "happy with my photo"
    Then I verify the donor initial's photo rules screen appears
    And I click the back button
    And I wait for 2 seconds
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available
    And I cancel the screen for taking a photo
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available


  @amazon30  @TC3435 @applicantUI
  Scenario: Applicant UI: OralEze - Sealed Device Picture of Donor's Initial
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "10" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    When I verify the Take Photo screen is available
    And I take the photo on the camera
    And I wait for 3 seconds
    And I click the button: "happy with my photo"
    Then I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available
    And I cancel the screen for taking a photo
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available
    And I take the photo on the camera
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results


  @amazon30  @TC3437 @applicantUIChromeOnly @amazonst
  Scenario: Applicant UI: OralEze - Upload Photo of Sealed Device Picture of Donor's Initial
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "1" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    When I upload the photo of the OralEze barcode label for shipping
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: "happy with my photo"
    Then I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 2 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results


  @amazon30  @TC3666 @applicantUIChromeOnly
  Scenario: Applicant UI: OralEze - Upload Sealed Device Picture of Donor's Initial Photo Rules
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "2" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    When I upload the photo of the OralEze barcode label for shipping
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: "happy with my photo"
    Then I verify the donor initial's photo rules screen appears
    And I click the back button
    And I wait for 5 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available


  @amazon30  @TC4348 @applicantUI
  Scenario: Applicant UI: OralEze - Sealed Device Picture Photo Rules text
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "2" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    When I click the Next button
    Then I verify the photo rules screen appears
    And I verify the photo rules Specimen ID text appears


#  Background: Generate Candidate data
#    Given a request for CreateOrder and POST to the api
#      | json field    | new value     |
#      | lastName      | Auto[gennum:5]|
#      | deviceType    | oralEze       |
#      | reasonForTest | NON-PRE       |
#      | wellnessId    | [gennum:9]    |
#      | EACaseId      |[gennum:9]     |
#      | ssn           | [gennum:4]    |


  @TC1367 @amazon30 @applicantUI
  Scenario: OralEze - Open Pouch Screen with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    When I enter the consenting signature for the drug screen
    And I click the Next button
    Then I can verify the Oral-Eze Open Pouch screen appears
    And I click the back button
    And I can verify the Consenting Electronic Signature screen appears
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears


  @TC929 @amazon30 @applicantUI
  Scenario: OralEze - Collect a Sample Screen (Part 1) with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "8" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    When I click the back button
    Then I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears



  @TC1668 @amazon30 @applicantUI
  Scenario: OralEze -Collect a Sample Screen (Part 2) with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "6" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    When I click indicator is blue button
    Then I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the back button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I click the Next button
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears


  @TC930 @amazon30 @applicantUI
  Scenario: OralEze -Close the Cap Screen with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "9" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 3 seconds
    When I click the Next button
    Then I verify the Oal-Eze Close the Cap Screen appears
    And I click the back button
    And I wait for 2 seconds
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 3 seconds
    And I click the Next button
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available

  @amazon30 @TC932 @applicantUI
  Scenario: OralEze -Package Your Test Kit Screen with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "9" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    When I click the Next button
    Then I verify the Barcode Seal and Shipping screen is available
    And I click the back button
    And I wait for 2 seconds
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I click the Next button
    And I verify the photo rules screen appears


  @amazon30  @TC2566 @applicantUIChromeOnly
  Scenario: OralEze Barcode Label Information with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "9" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload a bad photo
    And I wait for 3 seconds
    When I click the button: Enter the specimen ID
    Then I verify the Barcode ID screen appears
    And I wait for 3 seconds
    And I click the back button
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I enter the barcode label ID "E1824390" on the barcode Information Screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify the photo rules screen appears


  @amazon30  @TC2032 @applicantUI
  Scenario: OralEze Barcode Label Retake Photo with NO Video
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I enter booth number "9" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available
    When I take the photo on the camera
    And I wait for 3 seconds
    Then I verify the Applicant Review your Photo screen appears
    And I click the Retake Photo button
    And I take the photo on the camera
    And I wait for 3 seconds
    And I verify the Applicant Review your Photo screen appears



  @TC1998 @amazon30 @applicantUI
  Scenario: OralEze Get Help Icon on Welcome Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I wait for 5 seconds
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I contact someone for help"
    And I can verify the help content screen appears with additional content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Get Started button exists on the Welcome Screen


  @TC1999 @amazon30 @applicantUI
  Scenario: OralEze Get Help Icon on Consent 1 and Consent 2 Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I can verify the Consenting Electronic Signature screen appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "digital signature"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the Consenting Electronic Signature screen appears



  @TC2002 @amazon30 @applicantUI
  Scenario: OralEze Get Help Icon on Open Pouch Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "likelihood of device and sample tampering"
    And I can verify the help content screen appears with additional content text "Oral-Eze is a simple and easy-to-use lab-based oral fluid collection"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the Oral-Eze Open Pouch screen appears


  @TC2003 @amazon30 @applicantUI
  Scenario: OralEze Get Help Icon on Pool Saliva and Collect Sample Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "When the indicator window on the handle turns blue"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears


  @TC1921 @amazon30 @applicantUI
  Scenario: OralEze Get Help Icon on Close Cap and Seal Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "Close the lid tightly"
    And I can verify the help content screen appears with additional content text "Hold the Oral-Eze tube upright"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Oal-Eze Close the Cap Screen appears


  @TC2390 @amazon30 @applicantUI
  Scenario: OralEze Get Help Icon on welcome page for Non Pre-employment
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I click the get started button on the Get Started screen
    And I can verify the Applicant Review Information screen appears


  @TC2734 @amazon30 @applicantUIChromeOnly
  Scenario: OralEze Get Help Icon on Enter Lot Specimen ID page
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload a bad photo
    And I wait for 3 seconds
    When I click the button: Enter the specimen ID
    Then I verify the Barcode ID screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "The Specimen ID is printed right next to the bar code"
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Barcode ID screen appears


  @amazon30  @TC2919 @applicantUI
  Scenario: OralEze Get Help Icon on 'Review Your Photo' Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Take Photo screen is available
    When I take the photo on the camera
    And I wait for 3 seconds
    Then I verify the Applicant Review your Photo screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer


  @amazon30  @TC2951 @applicantUI
  Scenario: OralEze Get Help Icon on 'Seal and Package your test kit for shipping' Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    When I click the Next button
    Then I verify the Barcode Seal and Shipping screen is available
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer


  @amazon30  @TC2953 @applicantUI
  Scenario: OralEze Get Help Icon on 'Photo Rules' Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    When I click the Next button
    Then I verify the photo rules screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer


  @amazon30  @TC2954 @applicantUIChromeOnly
  Scenario: OralEze Get Help Icon on 'Packaging Your Kit in the Envelope' Screen
    Given I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 5 seconds
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 2 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageSealedDevice.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    And a request json "AdjudicateSealedDevice.json" for Adjudicate Sealed api with invite uuid "data.runtime.invite-uuid" for result "sealed"
    And a response should return with status "200"
    And I wait for 4 seconds
    Then I verify the Package Your Test for Shipping screen is available
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Package Your Test for Shipping screen is available


  @amazon30  @TC2955 @applicantUIChromeOnly
  Scenario: OralEze Get Help Icon on 'Cleaning Your Station' Screen
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
    And I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 3 seconds
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 2 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageSealedDevice.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    And a request json "AdjudicateSealedDevice.json" for Adjudicate Sealed api with invite uuid "data.runtime.invite-uuid" for result "sealed"
    And a response should return with status "200"
    And I wait for 4 seconds
    And I verify the Barcode Seal and Shipping screen is available
    When I click the Next button
    Then I verify the Clean your station screen appears
    And I click the Get Help icon
    And I wait for 5 seconds
    And I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I verify the Clean your station screen appears

  @amazon30   @applicantUIChromeOnly @incoming
  Scenario: Admin UI: OralEze - Re-take the picture ( click on bar code) - notification should be send to applicant UI
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
    And I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 3 seconds
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 2 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageSealedDevice.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    When a request json "AdjudicateSealedDevice.json" for Adjudicate Sealed api with invite uuid "data.runtime.invite-uuid" for result "retakeFrontPhoto"
    And a response should return with status "200"
    And I wait for 4 seconds
    Then I verify the photo rules screen appears


  @amazon30   @applicantUIChromeOnly @incoming2
  Scenario: Admin UI: OralEze - Re-take the picture (Initials) - notification should be send to applicant UI
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
    And I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 3 seconds
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 2 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageSealedDevice.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    When a request json "AdjudicateSealedDevice.json" for Adjudicate Sealed api with invite uuid "data.runtime.invite-uuid" for result "retakeBackPhoto"
    And a response should return with status "200"
    And I wait for 4 seconds
    Then I verify the donor initial's photo rules screen appears


  @amazon30   @applicantUIChromeOnly @incoming3
  Scenario: Admin UI: OralTox - Re-take the picture ( both Bar code & Initials) - notification should be send to applicant UI
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
    And I navigate to the applicant welcome screen
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I click the get started button on the Get Started screen
    And I click the Next button
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I can verify the Oral-Eze Open Pouch screen appears
    And I click the Next button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part One appears
    And I click indicator is blue button
    And I verify the Oral-Eze Sample Collection Instructions Screen Part Two appears
    And I wait for 2 seconds
    And I click the Next button
    And I verify the Oal-Eze Close the Cap Screen appears
    And I click the Next button
    And I verify the Barcode Seal and Shipping screen is available
    And I click the Next button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 3 seconds
    And I click the button: "happy with my photo"
    And I verify the donor initial's photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I verify the Upload Photo screen is available
    And I upload the photo of the OralEze barcode label for shipping
    And I wait for 2 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageSealedDevice.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    When a request json "AdjudicateSealedDevice.json" for Adjudicate Sealed api with invite uuid "data.runtime.invite-uuid" for result "retakePhotos"
    And a response should return with status "200"
    And I wait for 4 seconds
    Then I verify the photo rules screen appears


  @amazon30 @applicantUI @TC9926
  Scenario: Applicant UI -OralEze: Audio on Each Screen
    Given I navigate to the applicant welcome screen
    When I click the speech play button on the start screen
    Then I verify the Get Started button exists on the Welcome Screen
    And I validate the mute icon is available again
    And I click to mute the audio on the screen
    And I click to unmute the the audio on the screen
    And I validate the mute icon is available again


  @roomAdminUI @TC2724
  Scenario: Admin UI - Hide booth number for non pre-employment reason for test (OralEze)
    Given a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralEze       |
      | reasonForTest | NON-PRE       |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
      | ssn           | [gennum:4]    |

    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter Applicant information for non-preemployment order with Alias
    And I wait for 5 seconds
    And the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    Then validate candidate info
      | name                     | booth |
      | data.runtime.invite-name | no    |

#  @oraleze
#  Feature: Oral-Eze Batch Upload

  @TC3321 @amazon30 @eaBatchOrder @amazonEAst
  Scenario: EA: OralEze Batch Upload with 'Select Reason For Test'  Required Message
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the set environment
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraleze Drug Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      |Last Name          |First Name|DOB (MM/DD/YYYY)|SSN (###-##-####)|Phone Number [(###)###-####]|Email Address       |Address1 (123 Main Street) |City        |State |Zip  |
      |AutomationCandidate|Batch     |1/1/1980        |334-35-0909      |(357)557-4509               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |30519|
    And I provide data on Batch Processing page
      | field                | value               |
      | custom package       | Oraleze Drug Screen |
      | use download location|      default        |
      | upload name          | upload [gennum:4]   |
    And I click on Process Batch button
    And I cleanup existing files in the downloads folder
    And I click the Download Rejects button for batch
    And I wait for 10 seconds
    Then  I verify the Header "Reason For Test" is present in the Excel Type xls spreadsheet
    And I verify the required message appears for the missing Reason For Test field or value
    And I cleanup existing files in the downloads folder


  @TC3324 @amazon30 @eaBatchOrder @amazonEAst
  Scenario: EA: OralEze Batch Upload with 'Select Reason For Test' = PRE_EMPLOYMENT
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the set environment
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraleze Drug Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      |Last Name              |First Name|DOB (MM/DD/YYYY)|SSN (###-##-####)|Phone Number [(###)###-####]|Email Address       |Address1 (123 Main Street) |City        |State |Zip  |Reason For Test|
      |EzeAutomationCandidate |Batch     |1/1/1980        |334-35-0909      |(357)557-4509               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |30519|PRE_EMPLOYMENT |
      |EzeAutomationCandidate2|Batch     |1/1/1980        |334-35-0910      |(357)557-4508               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |30519|PRE_EMPLOYMENT |
    And I provide data on Batch Processing page
      | field                | value               |
      | custom package       | Oraleze Drug Screen |
      | use download location|      default        |
      | upload name          | upload [gennum:4]   |
    And I click on Process Batch button
    Then I verify "Submitted:2" batch orders created successfully
    And I cleanup existing files in the downloads folder


  @amazon30 @eaBatchOrder @amazonEAst @TC13911
  Scenario: EA: OralEze Batch Upload with Zip Required Message
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the set environment
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraleze Drug Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      |Last Name              |First Name|DOB (MM/DD/YYYY)|SSN (###-##-####)|Phone Number [(###)###-####]|Email Address       |Address1 (123 Main Street) |City        |State |Reason For Test|
      |ToxZipRequired         |Batch     |1/1/1980        |334-35-0808      |(357)557-4509               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |PRE_EMPLOYMENT |
    And I provide data on Batch Processing page
      | field                | value               |
      | custom package       | Oraleze Drug Screen |
      | use download location|      default        |
      | upload name          | upload [gennum:4]   |
    And I click on Process Batch button
    And I cleanup existing files in the downloads folder
    And I click the Download Rejects button for batch
    And I wait for 10 seconds
    Then  I verify the Header "Zip" is present in the Excel Type xls spreadsheet
    And I verify the required message appears for the missing Zip Code field or value
    And I cleanup existing files in the downloads folder

