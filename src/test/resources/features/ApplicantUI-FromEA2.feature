@oraltox
Feature: OralTox Applicant UI Pre-employment

  Background: Generate Candidate data
    Given a request for CreateOrder and POST to the api
      | json field    | new value     |
      | firstName     | B[gennum:5]   |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
      | ssn           | [gennum:4]    |

  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @TC846 @amazonRegression
  Scenario: Sample Information with NO Video
    Given I navigate to Applicant UI for location "CLT4"
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
    And I upload a bad photo
    And I wait for 7 seconds
    And I verify the Applicant Review your Uploaded Photo screen appears
    When I click the button: Enter the specimen ID
    Then I verify the Sample ID screen appears
    And I wait for 3 seconds
    And I click the back button
    And I verify the Applicant Review your Uploaded Photo screen appears
    And I click the button: Enter the specimen ID
    And I enter the sample ID "00000600" on the Enter ID screen
    And I wait for 2 seconds
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results

#    ONlY test with chrome browser
  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC835 @TC98715 @amazonST
  Scenario: Upload Photo Screen for Unreadable QR Code with NO Video
    Given I navigate to Applicant UI for location "CLT4"
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
    And I can verify the swabbing results wait screen appears
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    When I click the button: I'm ready to take a photo
    And I wait for 5 seconds
    Then I verify the Upload Photo screen is available
    And I upload the photo of the drugscreen results
    And I verify the photo is uploaded


    #    ONlY test with chrome browser
  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC2010 @amazonRegression
  Scenario: Upload an image (smaller than 4MB) of test device, Applicant UI should show a non-resized review image
    Given I navigate to Applicant UI for location "CLT4"
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
    And I can verify the swabbing results wait screen appears
    And I click the Next button
    And I click the I see the results button
    And I verify the photo rules screen appears
    And I wait for 5 seconds
    When I click the button: I'm ready to take a photo
    Then I verify the Upload Photo screen is available
    And I upload a drug screening photo for image checking
    And I verify the photo is uploaded
    And I wait for 5 seconds
    And I verify the photo size width 1080 height 1920

        #    ONlY test with chrome browser
  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC2010 @TC2006 @amazonRegression
  Scenario: Upload an image (smaller than 4MB) of test device and coc bar code
    Given I navigate to Applicant UI for location "CLT4"
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
    When I click the button: I'm ready to take a photo
    Then I verify the Upload Photo screen is available
    And I upload a drug screening photo for image checking
    And I wait for 3 seconds
    And I verify the photo is uploaded
    And I verify the photo size width 1080 height 1920


        #    ONlY test with chrome browser
  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC2011 @TC2007 @amazonST
  Scenario: Upload an image (larger than 4MB) of test device and coc bar code
    Given I navigate to Applicant UI for location "CLT4"
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
    When I click the button: I'm ready to take a photo
    Then I verify the Upload Photo screen is available
    And I upload the big photo of the drugscreen results
    And I wait for 5 seconds
    And I verify the photo is uploaded
    And I verify the photo size width 1058 height 1411


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC2013 @amazonST
  Scenario: Upload an image (smaller than 4MB) of test device and Admin UI shows a non resized image
    Given I navigate to Applicant UI for location "CLT4"
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
    And I verify the Upload Photo screen is available
    And I upload a drug screening photo for image checking
    And I wait for 10 seconds
    And I verify the photo is uploaded
    And I verify the photo size width 1080 height 1920
    And I wait for 5 seconds
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I wait for 15 seconds
    And I verify the screen appears: Please wait while we review your results
    And I wait for 5 seconds
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 2 seconds in AdminUI
    And I click on the location link for "TEST" in the Admin UI
    And I wait for 2 seconds
    And I click on the candidate in the Admin UI
    And I wait for 8 seconds
    Then I verify the photo size width 1080 height 1920 on the adjudication screen


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC2009 @TC98727 @amazonST
  Scenario: Upload an image (larger than 4MB) of test device and Admin UI shows a resized image
    Given I navigate to Applicant UI for location "CLT4"
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
    And I verify the Upload Photo screen is available
    And I upload the big photo of the drugscreen results
    And I wait for 7 seconds
    And I verify the photo is uploaded
    And I verify the photo size width 1058 height 1411
    And I wait for 5 seconds
    And I click the button: Enter the specimen ID
    And I verify the Sample ID screen appears
    And I enter the sample ID "33316236" on the Enter ID screen
    And I click the Next button
    And I verify the screen appears: Please wait while we review your results
    When the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "TEST" in the Admin UI
    And I click on the candidate in the Admin UI
    Then I verify the photo size width 1058 height 1411 on the adjudication screen


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @applicantUIChromeOnly @TC932 @amazonST
  Scenario: Package Your Test Kit Screen with NO Video
    Given I navigate to Applicant UI for location "CLT4"
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
    And I wait for 7 seconds
    And I verify the Take Photo screen is available
    And I verify the photo shutter is green
    And I take the photo on the camera
    And I wait for 15 seconds
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api with invite uuid
    And a POST call is sent to the api
    And I wait for 18 seconds
    And a request json "Adjudicate.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "negative"
    When a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 6 seconds
    Then I verify the Clean your station screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2  @amazonstDeviceNeeded @TC933 @TC15897 @amazonST
  Scenario: Clean Your Station Screen with NO Video (Clear)
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
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
    And I wait for 7 seconds
    And I verify the Take Photo screen is available
    And I verify the photo shutter is green
    And I take the photo on the camera
    And I wait for 15 seconds
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And a request json "Adjudicate.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "negative"
    When a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 16 seconds
    Then I verify the Clean your station screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @amazonstDeviceNeeded @TC7851 @amazonST
  Scenario: Applicant UI: Clean Your Station Screen (Inconclusive)
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
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
    And I wait for 10 seconds
    And I take the photo on the camera
    And I wait for 10 seconds
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 16 seconds
    When a request json "AdjudicateInconclusive.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 2 seconds
    Then I verify the Clean your station screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @amazonstDeviceNeeded @TC491 @amazonRegression
  Scenario: Re-take Test with NO Video (Invalid)
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
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
    And I wait for 10 seconds
    And I take the photo on the camera
    And I wait for 10 seconds
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 15 seconds
    And a request json "Adjudicate.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "invalid"
    When a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 15 seconds
    Then I verify retake Test screen appears
    And I click the Next button
    And I can verify the Grab test kit and open pouch screen appears


  @amazonSelfCollect @ApplicantUI @ApplicantUI-FromEA2 @amazonstDeviceNeeded @TC1139 @amazonRegression
  Scenario: Re-take Photo with NO Video (Retake Photo)
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass" and close browser
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
    And I wait for 10 seconds
    And I take the photo on the camera
    And I wait for 10 seconds
    And I verify the Applicant Review your Photo screen appears
    And I click the button: "happy with my photo"
    And I verify the screen appears: Please wait while we review your results
    And I wait for 16 seconds
    And a request json "Adjudicate.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "retakePicture"
    When a POST call is sent to the api
    And a response should return with status "200"
    And I wait for 4 seconds
    And I verify the photo rules screen appears