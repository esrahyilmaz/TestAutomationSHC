Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC2498-10 @amazonST
  Scenario Outline: After login, select a location
    Given a request for CreateOrder and POST to the api
      | json field    | new value       |
      | lastName      | AutoS[gennum:5] |
      | deviceType    | oralTox         |
      | reasonForTest | PRE             |
      | wellnessId    | [gennum:9]      |
      | EACaseId      | [gennum:9]      |

    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I enter booth number "7" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    When I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds in AdminUI
    Then validate the correct location is showing

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC2498-11 @amazonRegression
  Scenario Outline: After login, select a location, tests in progress dashboard
    Given a request for CreateOrder and POST to the api
      | json field    | new value      |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PRE            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
    And I navigate to Applicant UI for location "CLT4"
    And I click the speech play button on the start screen
    And I enter the Applicant information without booth information
    And I enter booth number "9" into Enter Booth Number Page in Applicant UI
    And I click the Next button
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    When I click on the location link for "CLT4" in the Admin UI
    And click on the tests in progress link
    And I wait for 2 seconds in AdminUI
    Then validate the tests in progress dashboard
    And validate candidate info

      | name                     | booth | step        |
      | data.runtime.invite-name | 9     | Review Info |

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC5104 @amazonRegression
  Scenario Outline: After login, select a location, ready to adjudicate dashboard
    Given a request for CreateOrder and POST to the api
      | json field    | new value    |
      | firstName     | A[gennum:5]  |
      | lastName      | AS[gennum:5] |
      | deviceType    | oralTox      |
      | reasonForTest | PRE          |
      | wellnessId    | [gennum:9]   |
      | EACaseId      | [gennum:9]   |

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
    And I wait for 5 seconds
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
    And I enter the sample ID "52006492" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 2 seconds in AdminUI
    When I click on the location link for "CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    Then validate the ready to adjudicate dashboard

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC5104-2 @amazonRegression
  Scenario Outline: Adjudicate, retake
    Given a request for CreateOrder and POST to the api
      | json field    | new value    |
      | firstName     | A[gennum:5]  |
      | lastName      | AS[gennum:5] |
      | deviceType    | oralTox      |
      | reasonForTest | PRE          |
      | wellnessId    | [gennum:9]   |
      | EACaseId      | [gennum:9]   |

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
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I click on the location link for "CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    When adjudicate with Re-take option
    Then validate candidate info
      | name             | step         |
      | Adjudicate Auto6 | Retake photo |

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC5104-3 @amazonRegression
  Scenario Outline: Adjudicate, clear
    Given a request for CreateOrder and POST to the api
      | json field    | new value    |
      | firstName     | A[gennum:5]  |
      | lastName      | AS[gennum:5] |
      | deviceType    | oralTox      |
      | reasonForTest | PRE          |
      | wellnessId    | [gennum:9]   |
      | EACaseId      | [gennum:9]   |

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
    And I wait for 2 seconds
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
    And user login with "<username>" and "<password>"
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Locations Landing page of the Admin UI
    And I click on the location link for "CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    When adjudicate with Clear option
    Then validate candidate info
      | name             | step     |
      | Adjudicate Auto3 | Clean up |

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC9312 @TC11087 @amazonRegression
  Scenario: Admin UI: Confirm Inconclusive Adjudication Message
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
    And I wait for 6 seconds
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And adjudicate with Inconclusive option
    Then I can verify message appears for inconclusive confirmation
    And I click the cancel button on the adjudication message modal
    And I wait for 2 seconds
    And I click sign and submit button for inconclusive adjudication
    And I can verify message appears for inconclusive confirmation
    And I click the confirm button on the adjudication message modal
    And I wait for 2 seconds
    And I verify the candidate card is displaying again in the Admin UI
    And I logout of the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC9313 @amazonRegression
  Scenario: Admin UI: Confirm Clear Adjudication Message
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
    And adjudicate with Clear option
    And I click certify and sign button for the adjudication
    Then I can verify the message appears for clear confirmation
    And I click the cancel button on the adjudication message modal
    And I wait for 2 seconds
    And I click certify and sign button for the adjudication
    And I can verify the message appears for clear confirmation
    And I click the confirm button on the adjudication message modal
    And I wait for 2 seconds
    And I verify the candidate card is displaying again in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC9315 @TC17023 @amazonRegression
  Scenario: Admin UI: Confirm Invalid Adjudication Message
    Given a request for CreateOrder and POST to the api
      | json field    | new value   |
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
    And I wait for 6 seconds
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And adjudicate with Retest option
    And I wait for 2 seconds
    Then I can verify the message appears for invalid confirmation
    And I click the cancel button on the adjudication message modal
    And I wait for 2 seconds
    And I click certify and sign button for the adjudication
    And I wait for 2 seconds
    And I can verify the message appears for invalid confirmation
    And I click the confirm button on the adjudication message modal
    And I wait for 2 seconds
    And I verify the candidate card is displaying again in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC9444 @TC9446 @TC9445 @amazonST
  Scenario: Admin UI: Displaying Completed Tests filter
    Given a request for CreateOrder and POST to the api
      | json field    | new value   |
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
    And I enter the sample ID "00000601" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And adjudicate with Clear option
    And I click certify and sign button for the adjudication
    And I click the confirm button on the adjudication message modal
    And I wait for 4 seconds
    And I click on the Completed Tests Tab in the Admin UI
    Then I verify the filter displays for the Completed Tests
    #UX changed, need to update these 2 steps to verify the card on the concluded tests dashboard
    #    And I can verify the current user card is listed in the "Past 24 Hours"
    #    And I wait for 2 seconds in AdminUI
    #    And I can verify the current user card is listed in the "Past 48 Hours"


  @amazonSelfCollect @AdminUI-Pre-Employment1 @adminUI @TC11571 @amazonST
  Scenario: Admin UI: Test Strips Display on Inconclusive Adjudication
    Given a request for CreateOrder and POST to the api
      | json field    | new value   |
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
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    When I click the inconclusive button for adjudication
    And I wait for 4 seconds
    Then I can verify the 6 test strips appear on the page


  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC9880 @TC12829 @amazonST
  Scenario: Admin UI - Completed Tests Tab: Additional Search by Date Range
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
    And I click on the Concluded Tests Tab in the Admin UI
    And I wait for 2 seconds
    When I set the start date range to -3 days prior current date for completed tests
    And I set the end date range to current day for completed tests
    And I wait for 5 seconds
    Then I can verify the current user card is listed in the results
    And I click on the current user's adjudicated card
    And I wait for 5 seconds
    And I can verify the adjudicated result card contains the image and signature
    And I click Dashboard Button in the Admin UI
    And I wait for 5 seconds
    # The scenario falis on the below step, Bug # 120013 is created on the board to fix the issue, should run again once it's resolved.
    And I can verify the current user card is listed in the results

  @amazonSelfCollect @adminUI @AdminUI-Pre-Employment1 @TC9631 @TC9884 @TC9844 @TC26092 @amazonST
  Scenario: Admin UI - Completed Tests Tab: Additional Type Search by Candidate
    Given a request for CreateOrder and POST to the api
      | json field    | new value   |
      | firstName     | A[gennum:5] |
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
    And I wait for 3 seconds
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I verify the Yes button exists on the admin specimen id screen
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
    And I can verify One tests returns count displays for results in Past Twenty-Four Hours
