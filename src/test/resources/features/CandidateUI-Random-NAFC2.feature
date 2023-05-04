@oraltox @nonPre-Employment
Feature: OralTox Applicant UI (Non Pre-employment)


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC15899 @TC16610 @TC15870 @amazonST
  Scenario: Applicant UI - 'Indicator is not red' button
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
    And I wait for 3 seconds
    When I click the indicator is not red button
    Then I can verify the Sample Collection screen appears
    And I wait for 5 seconds
    And I click the indicator is not red button
    And I click the button: I see the Red Indicator
    And I wait for 21 seconds
    And I click the Get Help icon
    And I wait for 3 seconds
    And I verify the Request Help button exists on the Help Screen
    And I click the button: Found My Answer
    And I wait for 2 seconds
    And I verify the Insert Swab image appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @amazonst @TC18909 @amazonST
  Scenario: No Order Created without Social Security Number
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
    When I enter the Applicant information with no social security number and without booth information
    And I click the get started button on the Get Started screen
    Then I can verify the message appears for missing fields on the applicant UI welcome screen


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC52710 @amazonST
  Scenario: Candidate UI - Timer Configurations: Reason for test - Other reasons
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
    When I click the Next button
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80603AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    Then I verify the timer is greater than or equal to 17 seconds


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC52851 @amazonST
  Scenario: Candidate UI - Timer Configurations: Reason for test - Random
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
    When I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    Then I verify the timer is less than or equal to 10 seconds


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC49534 @amazonRegression
  Scenario: Applicant UI: Candidate with Random, Post Accident, or, Reasonable suspicion reasons should be able to see the provided consent
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
    Then I can verify the Applicant Review Information screen appears
    And I wait for 5 seconds
    And I click the Next button
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate's abandoned card in the Admin UI
    And I wait for 3 seconds
    And I click on Abandoned Process button
    And I verify the Abandon Reason Options are present
    And I select a reason for Abandoned Process
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    And I click the confirm button on the adjudication message modal
    And I click on the Concluded Tests Tab in the Admin UI
    And I wait for 2 seconds
    And I verify that the candidate card does not have booth number


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC52135 @TC51998 @amazonRegression
  Scenario: Admin UI: Admin should not see the booth number on the card belongs to an order with a non-preemployment reason
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
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 3 seconds
    And I click on the candidate's abandoned card in the Admin UI
    And I wait for 3 seconds
    And I click on Abandoned Process button
    And I verify the Abandon Reason Options are present
    And I select a reason for Abandoned Process
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    And I click the confirm button on the adjudication message modal
    And I click on the Concluded Tests Tab in the Admin UI
    And I wait for 2 seconds
    And I verify that the candidate card does not have booth number


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC71411 @TC71434 @TC71432 @TC82027 @amazonRegression
  Scenario: Applicant UI - Non Pre-employment Oraltox order - Order lookup page should require Alias
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I select the Business Line "North American Fulfillment Center" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package "OralTox 6 Panel"
    And I click the next button for the order in the Admin UI
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Wonder" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    And I enter Amazon Alias "AmazonAlias"
    And I click the next button for the order in the Admin UI
    And I wait for 1 seconds in AdminUI
    And I enter the phone number "678-546-3324" for the order in the Admin UI
    And I enter the email address "esra.yilmaz@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    When I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "Wonder", Birthday "01/01/2001", and alias ""
    And I click the get started button on the Get Started screen
    Then I verify All fields are required to get started message appears on the Get Started screen
    And I enter the Applicant Last Name "Wonder", Birthday "01/01/2001", and alias "alias123"
    And I click the get started button on the Get Started screen
    And I verify Please enter a valid Amazon alias message appears on the Get Started screen
    And I enter the Applicant Last Name "Wonder", Birthday "01/01/2001", and alias "amAzonALIAS"
    And I click the get started button on the Get Started screen
    And I can verify the Applicant Review Information screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC71428 @amazonST
  Scenario: Applicant UI - Non Pre-employment Oraltox order - Order lookup page, System should validate Amazon Alias with Client Reference2
    Given a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | RND            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | amazonAlias    |

    When I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    Then I enter Applicant information for non-preemployment order with Alias
    And I wait for 1 seconds
    And I can verify the Applicant Review Information screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC74076 @74106 @amazonST
  Scenario: EA - 1Step Xchange, ReasonForTest YES, Options for OralTox
    Given create a new case using Xchange 1Step
      | file                   |
      | 1stepOralToxRandom.xml |
    And I verify the order was created via One Step Xchange
    When I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "TOXLOCATIONAUTOSA", Birthday "12/12/1980", and alias "CLIENTREFALIAS"
    And I click the get started button on the Get Started screen
    Then I can verify the Applicant Review Information screen appears


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @amazonst @TC84223 @amazonRegression
  Scenario: Applicant UI-'Yes Decline' button on Confirmation pop up for Additional Disclosure Screen should take back to the Play screen
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
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    When I click on Decline button on Disclosure page for Applicant UI
    And I click on Yes, Decline button on the Confirmation Popup on Disclosure page for Applicant UI
    Then I verify that I'm on the Applicant UI Welcome screen


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC89070 @TC89073 @TC89074 @TC89075 @amazonST
  Scenario: Applicant UI-You should be navigated to FCRA Disclosures and Authentication screen when you click agree on Drug and Alcohol policy screen
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
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    And I can verify that a confirmation Popup appears on Disclosure page for Applicant UI
    And I click on No, Back button on the Confirmation Popup on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Decline button on Disclosure page for Applicant UI
    When I click on Yes, Decline button on the Confirmation Popup on Disclosure page for Applicant UI
    Then I verify that I'm on the Applicant UI Welcome screen


  @amazonSelfCollect @ApplicantUI @CandidateUI-Random-NAFC2 @TC89072 @amazonST
  Scenario: Applicant UI-You should be navigated to Disclosure screen when you click agree on FCRA Disclosures and Authentication screen
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
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I can verify that Decline button is available on Disclosure page for Applicant UI
    And I can verify that Agree button is available on Disclosure page for Applicant UI
    When I click on Agree button on Disclosure page for Applicant UI
    Then I verify that I am on the Additional Disclosures Screen in Applicant UI
