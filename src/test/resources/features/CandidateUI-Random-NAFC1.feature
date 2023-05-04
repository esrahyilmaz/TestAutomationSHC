@oraltox @nonPre-Employment
Feature: OralTox Applicant UI (Non Pre-employment)

  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC1060 @amazonST
  Scenario: OralTox Hide Booth Number for NonPre-Employment Candidate
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
    And I wait for 1 seconds
    And I can verify the booth field is not showing
    Then I can verify the Applicant Review Information screen appears

  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC2386 @amazonRegression
  Scenario: OralTox Get Help Icon on welcome page for Non Pre-employment
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
    And I wait for 1 seconds
    When I click the Get Help icon
    And I wait for 5 seconds
    Then I can verify the help content screen appears with content text "How do I contact someone for help?"
    And I can verify the help content screen appears with content text "Select the “Request Help” button on your screen and wait for the drug test collector to provide assistance."
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I can verify the Applicant Review Information screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC6656 @TC6659 @TC6658 @amazonRegression
  Scenario: Applicant UI: OralTox Navigation for "I Do Not See the Results" Button on the Wait for Results Screen
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
    And I wait for 60 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    When I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I don't see any results button
    And I can verify the swabbing results wait screen appears
    And I click the I don't see any results button
    Then I verify the Request Help button exists on the Help Screen
    And I click the button: I see the Results Help button


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC6655 @TC6653 @amazonST
  Scenario: Applicant UI: OralTox Navigation for "I See the Results" Button on the Wait for Results Screen
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
    And I wait for 60 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    When I click the Cap is Sealed Tight button
    And I click the Next button
    Then I can verify the swabbing results wait screen appears
    And I click the I see the results button
    And I verify the photo rules screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC6657 @amazonST
  Scenario: Applicant UI: OralTox  (2nd Iteration) Navigation for "I See the Results" Button on the Wait for Results Screen
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
    And I wait for 60 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    When I click the I don't see any results button
    And I can verify the swabbing results wait screen appears
    And I click the I see the results button
    Then I verify the photo rules screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC8928 @amazonst @TC11232 @amazonST
  Scenario: Applicant UI: OralTox -Invalid Range for Specimen/Lot Information for QR Code
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
    And I wait for 60 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload a bad photo
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I wait for 2 seconds
    When I enter the sample ID "34007435" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 20 seconds
    Then I can verify the invalid device message displays
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I enter the help comment "Applicant had invalid device" information only
    And I wait for 2 seconds
    And I Click the Restart Test checkbox on the Admin help
    And I click the Done button on the Admin help
    And I logout of the Admin UI
    And I wait for 10 seconds
    And I verify retake Test screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @amazonst @TC11246 @amazonRegression
  Scenario: Applicant UI - OralTox: Expired Device Item Redirects to Re-take Test
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
    And I wait for 5 seconds
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
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    When I enter the sample ID "00000611" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    Then I can verify the expired device message displays
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 2 seconds
    And I click on the candidate in the Admin UI
    And I wait for 6 seconds
    And I enter the help comment "Applicant had expired device" information only
    And I Click the Restart Test checkbox on the Admin help
    And I click the Done button on the Admin help
    And I logout of the Admin UI
    And I wait for 10 seconds
    And I verify retake Test screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @amazonst @TC11245 @amazonST
  Scenario: Applicant UI - OralTox: Duplicate Device Item Redirects to Re-take Test
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
    And I wait for 60 seconds
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
    When I enter the sample ID "60000000" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    Then I can verify the duplicate device message displays
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 2 seconds
    And I enter the help comment "Applicant had duplicate device" information only
    And I Click the Restart Test checkbox on the Admin help
    And I click the Done button on the Admin help
    And I logout of the Admin UI
    And I wait for 10 seconds
    And I verify retake Test screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @amazonst @TC9166 @amazonST
  Scenario: Applicant UI - Sample ID UI Validation
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
    And I wait for 60 seconds
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
    When I enter the sample ID "340074359" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    Then I can verify that I see the message displays for maximum characters allowed
    And I correctly enter the sample ID "123" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I can verify that I see the message displays for maximum characters allowed


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @amazonstDeviceNeeded @TC16944 @TC9929 @amazonRegression
  Scenario: Applicant UI -OralTox: Audio on Each Screen
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
    And I validate the audio is present on the "Collect Saliva" screen
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I validate the audio is present on the "Swabbing Results" screen
    And I wait for 65 seconds
    And I validate the audio is present on the "Indicator is Red Screen" screen
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I validate the audio is present on the "Insert Swab into Device" screen
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I can verify the swabbing results wait screen appears
    And I validate the audio is present on the "Swabbing Results Wait" screen
    And I can verify the swabbing results wait screen appears
    And I validate the audio is present on the "2nd Swabbing Results Wait" screen
    And I click the I don't see any results button
    And I can verify the swabbing results wait screen appears
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I validate the audio is present on the "Photo Rules" screen
    And I wait for 7 seconds
    And I click the button: I'm ready to take a photo
    And I wait for 10 seconds
    And I take the photo on the camera
    And I wait for 10 seconds
    And I verify the Applicant Review your Photo screen appears
    And I validate the audio is present on the "Applicant Review Your Photo" screen
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 16 seconds
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    And I wait for 16 seconds
    And a request json "Adjudicate.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "negative"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 3 seconds
    And I verify the Clean your station screen appears
    And I validate the audio is present on the "Clean Your Station" screen


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @amazonst @TC10364 @amazonRegression
  Scenario: Applicant UI OralTox - mute/un-mute the audio button should be available in each step
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
    And I wait for 1 seconds
    Then I validate the audio is present on the "Consent Signature" screen
    And I click to unmute the the audio on the screen
    And I validate the mute icon is available again


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC1 @TC13180 @amazonRegression
  Scenario: Applicant UI - OralTox: Manual Entry for Specimen ID that is in an Overlapping Start/Stop Range for Device Item
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
    And I wait for 7 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I can verify the swabbing results wait screen appears
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    When I enter the sample ID "52006492" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    And a request json "AdjudicateInconclusive.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 16 seconds
    Then I verify the Clean your station screen appears
