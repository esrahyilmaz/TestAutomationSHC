Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin

  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC17024 @amazonRegression
  Scenario: Admin UI- Ability to select a reason for invalid tests - select 'Other' as a reason for test
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I click the Retest button on the Admin UI
    And I select the reason for Invalid option "Other - enter details below"
    And I wait for 2 seconds
    Then I verify the invalid Reason Options are present
    And I verify the Sign and submit button is disabled
    And I select the reason for Invalid option "Other - enter details below"
    And I enter a comment "I didn't know what I was doing" for the invalid reason
    And I enter the consent signature for the Admin adjudication
    And I wait for 2 seconds
    And I click certify and sign button for the adjudication
    And I wait for 2 seconds
    And I can verify the message appears for invalid confirmation


  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC17028 @amazonRegression
  Scenario: Admin UI- Ability to select a reason for invalid tests - select a reason for an invalid test and click Back
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And I verify that I am navigated to the Review Package Before Opening screen\
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
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I click the Retest button on the Admin UI
    And I select the reason for Invalid option "Other - enter details below"
    And I wait for 2 seconds
    Then I verify the invalid Reason Options are present
    And I verify the Sign and submit button is disabled
    And I select the reason for Invalid option "Other - enter details below"
    And I enter a comment "I didn't know what I was doing" for the invalid reason
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    When I click the confirm button on the adjudication message modal
    And I wait for 2 seconds
    Then validate the tests in progress dashboard


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment2 @TC18849 @amazonRegression
  Scenario: Admin UI - Admin should be able to see both Inverted and regular images
    Given a request for CreateOrder and POST to the api
      | json field    | new value     |
      | firstName     | Inv[gennum:5] |
      | lastName      | Ao[gennum:5]  |
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      | [gennum:9]    |

    And I navigate to Applicant UI for location "CLT4"
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
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 5 seconds
    And I click on the candidate in the Admin UI
    And I wait for 4 seconds
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    When I enabled inverted image on the Admin UI
    Then I can verify the image was successfully inverted on the Admin UI


  @amazon30  @adminUI @AdminUI-Pre-Employment2 @TC20284 @amazonST
  Scenario: Admin UI: Admin should be able to see "Retest" option instead of "Invalid"
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    Then I verify the Retest option is present


  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC20218 @amazonST
  Scenario: Admin UI: Admin should be able to abandoned  card/order, add comment
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate's abandoned card in the Admin UI
    And I wait for 6 seconds
    And I verify the adjudicating screen appears
    And I click on Abandoned Process button
    And I verify the Abandon Reason Options are present
    And I select the reason for Abandoned Process option "Other - enter details below"
    And I enter comment "Test for TC20218" for Abandon reason
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    And I wait for 6 seconds
    Then I can verify the message appears for Abandoned Process confirmation

  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC20891 @TC20915 @amazonST
  Scenario: Admin UI: Admin should be able to validate the specimen ID which manually entered
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | M[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 2 seconds in AdminUI
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    Then I can verify the specimen ID "00000600" is present on the admin adjudication screen
    And I wait for 2 seconds in AdminUI
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds in AdminUI
    And I verify the adjudicating screen appears


  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC20916 @amazonST
  Scenario: Admin UI: If specimen ID does not matches, candidate should be directed to photo rules screen if Admin click on 'No' button
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    Then I can verify the specimen ID "00000600" is present on the admin adjudication screen
    And I verify the No button exists on the admin specimen id screen
    And I click the No button on the Admin specimen id screen
    And I wait for 2 seconds
    And I logout of the Admin UI
    And I wait for 5 seconds
    And I verify the ReTake Photo screen is available


  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC20898 @amazonRegression
  Scenario: Admin UI: If specimen ID matches, Admin should be able to continue with Adjudication
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000600" on the Enter ID screen
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 5 seconds
    Then I can verify the specimen ID "00000600" is present on the admin adjudication screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I verify the adjudicating screen appears
    And I logout of the Admin UI

  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC25568 @amazonST
  Scenario: Admin UI - Display last scanned location
    Given a request for CreateOrder and POST to the api
      | json field    | new value   |
      | firstName     | B[gennum:5] |
      | lastName      | A[gennum:5] |
      | deviceType    | oralTox     |
      | reasonForTest | PRE         |
      | wellnessId    | [gennum:9]  |
      | EACaseId      | [gennum:9]  |

    And I navigate to Applicant UI for location "CLT4"
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
    And I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 5 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And adjudicate with Clear option
    And I click certify and sign button for the adjudication
    And I click the confirm button on the adjudication message modal
    And I wait for 4 seconds
    And I click on the Completed Tests Tab in the Admin UI
    When I type in the current candidate to search for the completed test
    And I wait for 4 seconds
    Then I can verify the current user card is listed in the results
    And I click on the current user's adjudicated card
    And I wait for 5 seconds
    And I can verify the adjudicated result card contains the image and signature


  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC20253 @amazonST
  Scenario: Admin UI: When a card/order marked as "Abandoned Process", applicant flow should be redirected to clean up page.
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | A[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I navigate to Applicant UI for location "CLT4"
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
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate's abandoned card in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on Abandoned Process button
    And I verify the Abandon Reason Options are present
    And I wait for 1 seconds in AdminUI
    And I select a reason for Abandoned Process
    And I wait for 1 seconds in AdminUI
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    When I click the confirm button on the adjudication message modal
    And I wait for 2 seconds in AdminUI
    And I switch to another window
    And I wait for 2 seconds in AdminUI
    Then I verify the Clean your station screen appears

  @amazon30 @adminUI @AdminUI-Pre-Employment2 @TC20241 @amazonST
  Scenario: Admin UI:Admin selects Abandoned Process and card/order should be removed from Tests in Progress to Concluded tests
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | firstName     | A[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |

    And I wait for 3 seconds
    And I navigate to Applicant UI for location "CLT4"
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
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate's abandoned card in the Admin UI
    And I wait for 2 seconds
    And I click on Abandoned Process button
    And I verify the Abandon Reason Options are present
    And I select a reason for Abandoned Process
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    And I can verify the message appears for Abandoned Process confirmation
    And I click the confirm button on the adjudication message modal
    And I wait for 3 seconds
    And the card should be removed from Tests in progress dashboard
    And I wait for 3 seconds
    When I click on the Concluded Tests Tab in the Admin UI
    And I wait for 3 seconds
    Then the card should be displayed in concluded tests dashboard
