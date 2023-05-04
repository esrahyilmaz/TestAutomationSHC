Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @TC107047 @TC107048 @TC107046 @TC107058 @TC107053 @TC107053 @TC107060 @TC107062 @TC107050 @amazonRegression
  Scenario:Admin UI - You should be navigated to the Alcohol adj. screen When you adjudicate the drug + alcohol order as Inconclusive for drug
    Given a request for CreateOrder and POST to the api for reasonForTest PAC and REC Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PAC            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | alias          |

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
    And I wait for 2 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I wait for 2 seconds
    And I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    And I click the Next button
    And I verify that I am on the Alcohol Wait Screen of the Applicant UI
    And I wait for 10 seconds
    And I click the Next button
    And I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    And I wait for 20 seconds
    And I click the Next button
    And I verify that I am on the Pick up OralTox device screen of the Applicant UI
    And I click the I see the results button
    And I wait for 1 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 1 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000700" on the Enter ID screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 5 seconds in AdminUI
    When I click the inconclusive button for adjudication
    Then I verify that I am in the Alcohol Adjudication Page of the Admin UI
    And I click the alcohol result box "300" on the Admin UI
    And I click the next button for the Alcohol Flow in the Admin UI
    And I wait for 2 seconds
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify that I am on the Four Eyes Check page in Admin UI
    And I verify that I am able to select Clear, Inconclusive or Retest for Drug results in the Four Eyes Check Page
    And I verify that I am able to select any of the Alcohol checkboxes and the language changes accordingly in the Four Eyes Check Page
    And I verify that the Sign and Submit button is disabled in the Four eyes Check Page
    And I enter Salaried Leader Name "John Dillard" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    And I click the Sign and Submit button in the Four eyes Check Page
    And I can verify that I am on the Final Test Result Selection page in the Admin UI


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @TC104149 @TC104150 @TC104161 @amazonRegression
  Scenario:Admin UI - Next button should be disabled When no square is selected
    Given a request for CreateOrder and POST to the api for reasonForTest PAC and REC Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PAC            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | alias          |

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
    And I wait for 2 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I wait for 2 seconds
    And I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    And I click the Next button
    And I verify that I am on the Alcohol Wait Screen of the Applicant UI
    And I wait for 10 seconds
    And I click the Next button
    And I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    And I wait for 36 seconds
    And I click the Next button
    And I verify that I am on the Pick up OralTox device screen of the Applicant UI
    And I click the I see the results button
    And I wait for 1 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 1 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000700" on the Enter ID screen
    And I wait for 2 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 3 seconds in AdminUI
    When I click the clear button on the Admin UI
    And I verify that I am in the Alcohol Adjudication Page of the Admin UI
    Then I verify that the Next button is disabled on the Alcohol Adjudication Page of the Admin UI
    And I click the alcohol result box "40" on the Admin UI
    And I click the alcohol result box "0.0" on the Admin UI
    And I wait for 1 seconds in AdminUI
    And I click the next button for the Alcohol Flow in the Admin UI
    And I verify that I am on the Certify Clear Test Results page for Drug and Alcohol Test of Admin UI


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @TC103642 @TC103659 @TC103900 @TC103648 @103660 @TC107046 @TC106601 @TC106602 @TC106603 @amazonRegression
  Scenario:You should be navigated to the adjudication screen with options Clear, Retest and Abandoned When you Click on the Green card
    Given a request for CreateOrder and POST to the api for reasonForTest PAC and REC Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | PAC           |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | alias   |

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
    And I wait for 2 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I wait for 2 seconds
    And I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    And I click the Next button
    And I verify that I am on the Alcohol Wait Screen of the Applicant UI
    And I wait for 10 seconds
    And I click the Next button
    And I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    And I wait for 36 seconds
    And I click the Next button
    And I verify that I am on the Pick up OralTox device screen of the Applicant UI
    And I click the I see the results button
    And I wait for 1 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 1 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000700" on the Enter ID screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    When I click the Yes button on the Admin specimen id screen
    And I wait for 5 seconds in AdminUI
    Then I verify the Adjudication Page displays with Clear,Inconclusive, Retest and Abandoned Options in the Admin UI
    And I click the clear button on the Admin UI
    And I verify that I am in the Alcohol Adjudication Page of the Admin UI
    And I click the alcohol result box "300" on the Admin UI
    And I click the alcohol result box "0.0" on the Admin UI
    And I click Dashboard Button in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Admin UI Dashboard
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds in AdminUI
    And I click the clear button on the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click the alcohol result box "0.0" on the Admin UI
    And I wait for 1 seconds in AdminUI
    And I click the next button for the Alcohol Flow in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Certify Clear Test Results page for Drug and Alcohol Test of Admin UI
    And I verify that the Certify Clear Test Results page has the device picture and the Alcohol selection boxes
    And I enter a signature for the Certify Test Results page of the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click sign and submit button for inconclusive adjudication
    And I wait for 1 seconds in AdminUI
    And I verify Confirm and Cancel buttons are displayed on the confirmation popup window
    And I click the cancel button on the adjudication message modal
    And I click Dashboard Button in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that I am on the Admin UI Dashboard


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @TC106920 @TC106921 @TC106919 @amazonST
  Scenario:Admin UI-The card should be set to 'Start Over' if you click on 'Retest' option on Final Test Result selection page
    Given a request for CreateOrder and POST to the api for reasonForTest PAC and REC Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | REC            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | alias          |

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
    And I wait for 2 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I click the indicator is red button
    And I wait for 3 seconds
    And I click the Cap is Sealed Tight button
    And I wait for 5 seconds
    And I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    And I click the Next button
    And I verify that I am on the Alcohol Wait Screen of the Applicant UI
    And I wait for 10 seconds
    And I click the Next button
    And I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    And I wait for 36 seconds
    And I click the Next button
    And I verify that I am on the Pick up OralTox device screen of the Applicant UI
    And I click the I see the results button
    And I wait for 1 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 1 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000700" on the Enter ID screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 3 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 5 seconds in AdminUI
    And I click the inconclusive button for adjudication
    And I wait for 2 seconds in AdminUI
    And I verify that I am in the Alcohol Adjudication Page of the Admin UI
    And I click the alcohol result box "40" on the Admin UI
    And I click the next button for the Alcohol Flow in the Admin UI
    And I wait for 2 seconds
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I verify that I am on the Four Eyes Check page in Admin UI
    And I enter Salaried Leader Name "John Dillard" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    When I click the Sign and Submit button in the Four eyes Check Page
    And I wait for 5 seconds in AdminUI
    Then I can verify that I am on the Final Test Result Selection page in the Admin UI
    And I verify that Final Test Result Selection Page displays the Four Eyes Check Result in the Admin UI
    And I click the Retest button on the Admin UI
    And I select the reason for Invalid option "Other - enter details below"
    And I enter a comment "Test" for the invalid reason
    And I enter the consent signature for retest option in the Admin UI
    And I click sign and submit button in the Admin UI
    And I click the confirm button on the adjudication message modal
    And validate candidate info
      | name                     | step          |
      | data.runtime.invite-name | Starting Over |
    And I wait for 2 seconds in AdminUI
    And I switch to another window
    And I wait for 5 seconds
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I wait for 1 seconds
    And I click the Next button
    And I wait for 40 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I wait for 40 seconds
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @TC108637 @TC108638 @108640 @108641 @108642 @108643 @amazonST
  Scenario: Admin UI - You should be navigated to the Open Alcohol Pouch screen When you click on Cap is sealed tightly button
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason " Post Accident "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I select the Business Line "North American Customer Fulfillment" on the Package Information Page
    And I wait for 1 seconds in AdminUI
    And I choose the Order Package " OralTox 7 Panel + Alcohol "
    And I click the next button for the order in the Admin UI
    Then I verify Employee ID field is displayed in the Identification Information Screen
    And I enter the Employee ID Number "123654789101" on the Identification Information Screen
    And I enter First Name "prathu" on the Identification Information Screen
    And I enter Last Name "neha1" on the Identification Information Screen
    And I enter Date of Birth  "01/01/1998" on the Identification Information Screen
    And I enter Amazon Alias "Alias"
    And I enter the Employee ID Number "123654789" on the Identification Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Contact Information screen is displayed
    And I wait for 2 seconds
    And I enter the phone number "281-236-1477" for the order in the Admin UI
    And I enter the email address "prathap.s@fadv.com" for the order in the Admin UI
    And I click the next button for the order in the Admin UI
    And I wait for 3 seconds
    And I can verify the Residence Information screen is displayed
    And I wait for 2 seconds
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter "123 main st" in the first line of the address for the order
    And I enter "suite 23" in the second line of the address for the order
    And I enter the city "Dallas" for the order
    And I choose the state "Georgia" on the Location Information Screen
    And I enter the zip code "30132" for the order
    And I click on the submit button for the order in the Admin UI
    And I wait for 2 seconds
    And I verify the Order completed message in the Admin UI
    And I click the Done button for the order in the Admin UI
    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "neha1", Birthday "01/01/1998", and alias "alias"
    And I click the get started button on the Get Started screen
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
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
    And I wait for 2 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I verify the saliva image is present
    And I click the Next button
    And I can verify the Sample Collection screen appears
    And I wait for 40 seconds
    And I click the indicator is red button
    When I click the Cap is Sealed Tight button
    And I wait for 5 seconds
    Then I verify that I am on the Open the Alcohol Pouch Screen of the Applicant UI
    When I click the Next button
    Then I verify that I am on the Alcohol Wait Screen of the Applicant UI
    When I click the Next button
    Then I verify that I am on the Place the strip on the napkin screen
    And I click the Next button
    When I click the Next button
    Then I verify that I am on the Pick up OralTox device screen of the Applicant UI


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @amazonRegression
  Scenario: Admin UI - Location Information page - Reasonable cause should be renamed to Reasonable Suspicion
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    When I click the Manage Orders Tab "Create New Order"
    And I wait for 2 seconds in AdminUI
    Then I choose the Package Reason "Reasonable Suspicion"
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed


  @amazonSelfCollect @adminUI @AdminUI-RS&PA @TC106841 @TC106844 @TC106845 @TC106847 @TC106848 @TC106849 @TC106850 @amazonST
  Scenario: Admin UI - You should be navigated to the Clear Certification page when you Adjudicate the 7-panel drug testing order as Clear
    Given a request for CreateOrder and POST to the api for reasonForTest RND and businessLine Air Orders
      | json field    | new value      |
      | firstName     | B[gennum:5]    |
      | lastName      | Auto[gennum:5] |
      | deviceType    | oralTox        |
      | reasonForTest | REC            |
      | wellnessId    | [gennum:9]     |
      | EACaseId      | [gennum:9]     |
      | alias         | alias          |

    And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATST" for orders created via Admin UI
    And I click the speech play button on the start screen
    And I enter Applicant information for non-preemployment order with Alias
    And I can verify the Applicant Review Information screen appears
    And I click the Next button
    And I wait for 2 seconds
    And I can verify the E-signature Consent screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I can verify that Drug and Alcohol policy screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I can verify that FCRA Disclosure and Authorization screen appears on Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I verify that I am on the Additional Disclosures Screen in Applicant UI
    And I click on Agree button on Disclosure page for Applicant UI
    And I wait for 2 seconds
    And I verify that I am navigated to the Acknowledgements & Authorization for Drug Test screen
    And I enter the consenting signature for the drug screen
    And I click the Next button
    And I wait for 2 seconds
    And I verify that I am navigated to the Review Package Before Opening screen
    And I select the REF Code "REF: 80701AZ" from the Drop-down list in Applicant UI
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears
    And I click the Next button
    And I wait for 2 seconds
    And I verify the saliva image is present
    And I click the Next button
    And I wait for 2 seconds
    And I can verify the Sample Collection screen appears
    And I wait for 2 seconds
    And I click the indicator is red button
    And I verify the Insert Swab image appears
    And I click the Cap is Sealed Tight button
    And I wait for 40 seconds
    And I click the Next button
    And I click the I see the results button
    And I wait for 10 seconds
    And I verify the photo rules screen appears
    And I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    And I upload the photo of the drugscreen results
    And I wait for 3 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I wait for 2 seconds
    And I verify the Sample ID screen appears
    And I enter the sample ID "00000708" on the Enter ID screen
    And I wait for 3 seconds
    And I click the Next button
    And I wait for 2 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 2 seconds
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 5 seconds in AdminUI
    And I click on the location link for "POSTEMP-FATST" in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I wait for 2 seconds in AdminUI
    And I click the clear button on the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that I am navigated to the Electronic Signature page for Admin UI Clear option
    And I click Dashboard Button in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click the Yes button on the Admin specimen id screen
    And I click the inconclusive button for adjudication
    And I verify the Salaried Leader Pop-Up window appears on the screen
    And I click the Proceed Button on the Salaried Leader Pop-up window
    And I click the inconclusive button for adjudication
    And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
    And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
    And I enter a signature for the Four Eyes Check page
    And I click on the Certify button on the Four Eyes Check Page in Admin UI
    And I click the clear button on the Admin UI
    And I wait for 2 seconds in AdminUI
    And I verify that I am navigated to the Electronic Signature page for Admin UI Clear option
    And I click Dashboard Button in the Admin UI
    And I wait for 5 seconds in AdminUI
    And I click on the candidate in the Admin UI
    And I wait for 5 seconds in AdminUI
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


