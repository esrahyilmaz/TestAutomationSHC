Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC2723 @amazonST
  Scenario: Admin UI - Hide booth number for non pre-employment reason for test (OralTox)
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
    And I wait for 5 seconds
    And the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    Then validate candidate info
      | name                     | booth |
      | data.runtime.invite-name | no    |


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC26091 @TC26114 @TC26119 @amazonRegression
  Scenario: Admin UI Integration: System recommendation if there is discrepancy in the Adjudication
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
    And I wait for 3 seconds
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
    And I wait for 3 seconds
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
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the clear discrepancy photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 1 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds in AdminUI
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I click the inconclusive button for adjudication
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
    And I wait for 2 seconds in AdminUI
    And I verify the button: Switch to this is displayed
    And I wait for 2 seconds in AdminUI
    And I verify the button: Keep this is displayed
    And I verify all of the recommended six test strips are negative in the Admin UI
    And I click the button: Keep this
    And I wait for 3 seconds in AdminUI
    And I click on the Concluded Tests Tab in the Admin UI
    And I type in the current candidate to search for the completed test
    And I wait for 5 seconds in AdminUI
    And I can verify the current user card is listed in the results
    And I click on the current user's adjudicated card
    And I wait for 5 seconds in AdminUI
    And I verify the test strips image contains ONE selected positive test strip


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC26127 @amazonRegression
  Scenario: Admin UI Integration: if admin reject the system recommendation
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
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the clear discrepancy photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 5 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I click the inconclusive button for adjudication
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
    And I click the button: Switch to this
    And I wait for 3 seconds in AdminUI
    And I enter the consent signature for the Admin adjudication
    And I click certify and sign button for the adjudication
    And I click the confirm button on the adjudication message modal
    And I click on the Concluded Tests Tab in the Admin UI
    And I type in the current candidate to search for the completed test
    And I wait for 3 seconds in AdminUI
    And I can verify the current user card is listed in the results
    And I wait for 5 seconds
    And I click on the current user's adjudicated card
    And I wait for 5 seconds
    And I verify the test strips image contains ZERO selected positive test strip


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC59744 @amazonST
  Scenario Outline: Admin UI - System should be navigated to Admin Dashboard page if click on Application 'Back' button
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the clear button on the Admin UI
    And I wait for 3 seconds
    When I click Dashboard Button in the Admin UI
    And I wait for 3 seconds
    Then I verify that I am on the Admin UI Dashboard

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC59738 @amazonST
  Scenario Outline: Admin UI - Adjudicate as Inconclusive and Admin should see Salaried Leader Pop Up NOT the System recommendation
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 5 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    When I click the inconclusive button for adjudication
    Then I verify the Salaried Leader Pop-Up window appears on the screen

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |

  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC59734 @amazonST
  Scenario Outline: Admin UI - Adjudicate as Clear and next screen should be Signature Screen
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    When I click the clear button on the Admin UI
    And I wait for 3 seconds
    Then I verify that I am navigated to the Electronic Signature page for Admin UI Clear option

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC59739 @amazonST
  Scenario Outline: Admin UI - System does read the strips as Invalid - Adjudicate as Invalid and Admin should be navigated to Signature screen
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    When I click the Retest button on the Admin UI
    And I wait for 3 seconds
    Then I verify that I am navigated to the Electronic Signature page for Admin UI Retest option

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC59737 @amazonST
  Scenario Outline: Admin UI - System READS the strips as Negative - Adjudicate as Inconclusive and System should through a recommendation
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
    And I wait for 3 seconds
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
    And I upload the clear discrepancy photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 5 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 3 seconds
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I click the inconclusive button for adjudication
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

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC59446 @amazonST
  Scenario Outline: Admin UI-4EyesCheck: while adjudicating the result final test result page should appear on screen
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
    And I wait for 3 seconds
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 3 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "<username>" and "<password>"
    And I wait for 3 seconds
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 3 seconds
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
    And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    When I click on the Certify button on the Four Eyes Check Page in Admin UI
    Then I can verify that I am on the Final Test Result Selection page in the Admin UI

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |

  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC60222 @TC60220 @amazonST
  Scenario:Admin UI - Four Eyes Check Page - 'Back' button should be removed from Wireframe on Salary Leader confirmation page
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    When I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify that I am on the Four Eyes Check page in Admin UI
    And I wait for 3 seconds
    Then I verify that there is no back button on the Four Eyes Check page under the signature pad
    And I wait for 1 seconds
    And I verify that the Certify button on the Four Eyes Check page is disabled
    And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
    And I wait for 3 seconds
    And I verify that the Certify button on the Four Eyes Check page is disabled
    And I wait for 2 seconds
    And I enter a signature for the Four Eyes Check page
    And I wait for 3 seconds
    And I verify that the Certify button on the Four Eyes Check page is enabled


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC70023 @TC71074 @TC71073 @TC71030 @amazonST
  Scenario: Admin UI - Amazon Alias should be required while creating order as Non Pre-employment reasons
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 3 seconds in AdminUI
    And I choose the Package Reason "Random"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I select the Business Line "North American Fulfillment Center" on the Package Information Page
    And I wait for 3 seconds in AdminUI
    And I choose the Order Package "OralTox 6 Panel"
    When I click the next button for the order in the Admin UI
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I enter First Name "Alice" on the Identification Information Screen
    And I enter Last Name "Wonder" on the Identification Information Screen
    And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
    And I can verify the next button is disabled for the order in the Admin UI
    Then I enter Amazon Alias "AmazonAlias123"
    And I verify the error message for Alias is given in Identification Page of Admin UI
    And I enter Amazon Alias "AmazonAlias@"
    And I verify the error message for Alias is given in Identification Page of Admin UI
    And I enter Amazon Alias "AmazonAliasForNonPreOrderLong"
    And I verify the error message for Alias is given in Identification Page of Admin UI
    And I enter Amazon Alias "AmazonAliasForNonPreOrder"
    And I verify the next button is enabled for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed


  @amazonSelfCollect @adminUI @AdminUI-RandomNAFC1 @TC74107 @74117 @amazonST
  Scenario: Admin UI - Non Pre-employment Oraltox order - Adjudicate Inconclusive - System should ask for Tracking number after adjudication/certify page
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
    And I wait for 3 seconds
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
    And I enter the sample ID "QB000000620" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 5 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 6 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click on the candidate in the Admin UI
    And I click the Yes button on the Admin specimen id screen
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I click the inconclusive button for adjudication
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


