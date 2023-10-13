@Sanity
  Feature:Login Using Self Healing Code
    @Sanity_01
    Scenario:Admin UI Login
      Given the login page for Room Admin UI is showing in the browser
      And Set Page
        | AdminUILoginPage |
      And user login with "data.admin.login.user" and "data.admin.login.pass"

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @usfcPreEmp @sanity
    Scenario: EA Order Entry for USFC Pre-Employment Flow
      Given I navigate to the EA application and login to the set environment
      And Set Page
        | EAPage |
      And I click on New Order link
      And I provide data on Order tab
        | field          | value               |
        | cid            | 12354               |
        | custom package | Oraltox Drug Screen |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And I wait for 6 seconds
      And Set Page
        | ApplicantPage |
      And I navigate to the Applicant UI screen using the alias "TEST"
      And I click the speech play button on the start screen
      And I enter the Applicant information retrieved from EA UI and set booth number to "99"
      And I click the Next button
      And I wait for 5 seconds
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
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "00000600" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "TEST" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I click the inconclusive button for adjudication
      And I enter a signature in the last Adjudication page of the Admin UI
      When I select the Inconclusive strips for the order in Admin UI
      Then I click sign and submit button for inconclusive adjudication
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @usfcSkpAdj @sanity
    Scenario: EA Order Entry for USFC Random Skip Adjudication Flow
      Given I navigate to the EA application and login to the environment for USFC Random SkipAdjudication Flow
      And Set Page
        | EAPage |
      And I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 6 Panel |
      And I click on Next button
      And I verify that I am on Subject tab
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "RANDOM" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And I wait for 6 seconds
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-FATTT" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
      And I wait for 5 seconds
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
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80101AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "00000100" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "RDM-FATTT" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I verify the page title is showing as Validating for Modified Adjudication page
      And I click Valid Button in the Modified Adjudication Page of the Admin UI
      And I verify that I am navigated to Sign and Submit Page in the Admin UI
      And I enter the consent signature for the Admin adjudication
      And I verify the Sign and Submit button is disabled in Admin UI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      When I click certify button for the adjudication in the Modified Adjudication Page
      Then I verify the confirm button is displayed on the Modified Adjudication Confirmation modal
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @usfcRnd @sanity
    Scenario: EA Order Entry for USFC Random
      Given I navigate to the EA application and login to the environment for random test account
      And Set Page
        | EAPage |
      When I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 6 Panel |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "RANDOM" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And I wait for 6 seconds
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-FATST" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
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
      And I wait for 5 seconds
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80603AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I verify the saliva image is present
      And I click the Next button
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "00000600" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 6 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 6 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "RDM-FATST" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I click the inconclusive button for adjudication
      And I verify the Salaried Leader Pop-Up window appears on the screen
      And I click the Proceed Button on the Salaried Leader Pop-up window
      And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
      And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
      And I enter a signature for the Four Eyes Check page
      And I click on the Certify button on the Four Eyes Check Page in Admin UI
      And I click the inconclusive button for adjudication
      And I enter a signature in the last Adjudication page of the Admin UI
      And I select the Inconclusive strips for the order in Admin UI
      And I verify the Sign and Submit button is disabled in Admin UI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      Then I click sign and submit button for inconclusive adjudication
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @usfcDrgAlc @sanity
    Scenario: EA Order Entry for USFC Drug+Alcohol Flow
      Given I navigate to the EA application and login to the environment for random test account
      And Set Page
        | EAPage |
      When I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 7 Panel + Alcohol |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "POST_ACCIDENT" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And I wait for 6 seconds
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-FATST" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
      And I wait for 5 seconds
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
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80701AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
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
      And I wait for 330 seconds
      And I click the Next button
      And I verify that I am on the Pick up OralTox device screen of the Applicant UI
      And I click the I see the results button
      And I wait for 1 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "00000700" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "RDM-FATST" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I select the Number of Strips for Alcohol "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 3 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 5 seconds in AdminUI
      And I click the inconclusive button for adjudication
      And I verify that I am in the Alcohol Adjudication Page of the Admin UI
      And I click the alcohol result box "40" on the Admin UI
      And I click the next button for the Alcohol Flow in the Admin UI
      And I wait for 2 seconds
      And I verify the Salaried Leader Pop-Up window appears on the screen
      And I click the Proceed Button on the Salaried Leader Pop-up window
      And I verify that I am on the Four Eyes Check page in Admin UI
      And I enter Salaried Leader Name "John Dillard" on the Four Eyes Check page in the Admin UI
      And I enter a signature for the Four Eyes Check page
      And I click the Sign and Submit button in the Four eyes Check Page
      And I wait for 4 seconds in AdminUI
      And I can verify that I am on the Final Test Result Selection page in the Admin UI
      And I click the inconclusive button for adjudication
      And I wait for 2 seconds in AdminUI
      And I verify that I am on the Final Test Result Selection - Alcohol page of the Admin UI
      And I click the alcohol result box "80" on the Admin UI
      And I click the next button for the Alcohol Flow in the Admin UI
      And I verify that I am on the Certify Test Results page of the Admin UI
      And I wait for 2 seconds in AdminUI
      And I verify that Seven Drug Strips are enabled for selection on the Certify Test Results Page
      And I wait for 2 seconds in AdminUI
      And I verify that Alcohol checkboxes are disabled on the Certify Test Results Page
      And I select test strips "1,2,4" as inconclusive on the Certify Test Results Page
      And I wait for 1 seconds in AdminUI
      And I enter a signature for the Certify Test Results page of the Admin UI
      And I wait for 2 seconds in AdminUI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      Then I click sign and submit button for inconclusive adjudication
      And I wait for 1 seconds in AdminUI
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @air @TC127810 @sanity
    Scenario: EA Order Entry for AIR
      Given I navigate to the EA application and login to the set environment for AIR RANDOM
      And Set Page
        | EAPage |
      When I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 7 Panel |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "RANDOM" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And I wait for 6 seconds
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATST" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
      And I wait for 5 seconds
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
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80701AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I wait for 420 seconds
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "QA000000720" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "POSTEMP-FATST" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I click the inconclusive button for adjudication
      And I verify the Salaried Leader Pop-Up window appears on the screen
      And I click the Proceed Button on the Salaried Leader Pop-up window
      And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
      And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
      And I enter a signature for the Four Eyes Check page
      And I click on the Certify button on the Four Eyes Check Page in Admin UI
      And I click the inconclusive button for adjudication
      And I enter a signature in the last Adjudication page of the Admin UI
      And I select the Inconclusive strips for the order in Admin UI
      And I verify the Sign and Submit button is disabled in Admin UI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      Then I click sign and submit button for inconclusive adjudication
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @airSkipAdj @sanity
    Scenario: EA Order Entry for AIR skipAdjudication flow
      Given I navigate to the EA application and login to the set environment for AIR RANDOM SkipAdjudication
      And Set Page
        | EAPage |
      When I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 7 Panel |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "RANDOM" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-FATTT" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
      And I wait for 5 seconds
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
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80101AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I wait for 420 seconds
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "QD000000161" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "POSTEMP-FATTT" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I verify the page title is showing as Validating for Modified Adjudication page
      And I click Valid Button in the Modified Adjudication Page of the Admin UI
      And I verify that I am navigated to Sign and Submit Page in the Admin UI
      And I enter the consent signature for the Admin adjudication
      And I verify the Sign and Submit button is disabled in Admin UI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      And I click certify button for the adjudication in the Modified Adjudication Page
      Then I verify the confirm button is displayed on the Modified Adjudication Confirmation modal
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @ussc @sanity
    Scenario: EA Order Entry for USSC Random flow
      Given I navigate to the EA application and login to the environment for USSC Random test account
      And Set Page
        | EAPage |
      When I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 6 Panel |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "RANDOM" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-TST1" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
      And I wait for 5 seconds
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
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80603AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I wait for 420 seconds
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "00000600" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "POSTEMP-TST1" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I click the inconclusive button for adjudication
      And I verify the Salaried Leader Pop-Up window appears on the screen
      And I click the Proceed Button on the Salaried Leader Pop-up window
      And I enter Salaried Leader Name "J. Adams" on the Four Eyes Check page in the Admin UI
      And I enter Additional Comments "Testing 4 eyes Check" on the Four Eyes Check page in the Admin UI
      And I enter a signature for the Four Eyes Check page
      And I click on the Certify button on the Four Eyes Check Page in Admin UI
      And I click the inconclusive button for adjudication
      And I enter a signature in the last Adjudication page of the Admin UI
      And I select the Inconclusive strips for the order in Admin UI
      And I verify the Sign and Submit button is disabled in Admin UI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      Then I click sign and submit button for inconclusive adjudication
      And I click the confirm button on the adjudication message modal

    @amazonSelfCollect @AmazonEndToEnd @eaOrderEntry @usscSkipAdj @sanity
    Scenario: EA Order Entry for USSC Random SkipAdjudication flow
      Given I navigate to the EA application and login to the environment for USSC Random skipAdjudication
      And Set Page
        | EAPage |
      When I click on New Order link
      And I provide data on Order tab
        | field          | value           |
        | cid            | 12354           |
        | alias          | test            |
        | custom package | Oraltox 6 Panel |
      And I click on Next button
      And I provide data on Subject tab
        | field                   | value                |
        | first name (given name) | TEST                 |
        | last name               | AUTO[gennum:5]       |
        | phone number            | 4042229999           |
        | email address           | esra.yilmaz@fadv.com |
        | birth day               | 01                   |
        | birth month             | February             |
        | birth year              | 2000                 |
        | address 1               | 3111 main street     |
        | city                    | Duluth               |
        | state                   | GEORGIA              |
        | zip                     | 30096                |
        | have ssn                | yes                  |
        | social security number  | 124-12-[gennum:4]    |
      And I click on Additional Searches tab
      And I wait for 17 seconds in EA
      And I select the reason for test as "RANDOM" for EA Order
      And I click on Review Order tab
      And I click on Submit Order button
      And I wait for 20 seconds in EA
      And I verify the order created successfully
      And I logout of EA
      And Set Page
        | ApplicantPage |
      And I navigate to Non-Preemployment applicant UI screen using the alias "POSTEMP-TST2" for orders created via Admin UI
      And I click the speech play button on the start screen
      And I enter the Candidate information retrieved from the EA UI
      And I wait for 5 seconds
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
      And I verify that I am navigated to the Review Package Before Opening screen
      And I select the REF Code "OT-80101AZ" from the Drop-down list in Applicant UI
      And I click the Next button
      And I can verify the Grab test kit and open pouch screen appears
      And I click the Next button
      And I wait for 2 seconds
      And I verify the saliva image is present
      And I wait for 18 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I can verify the Sample Collection screen appears
      And I wait for 150 seconds
      And I click the indicator is red button
      And I verify the Insert Swab image appears
      And I click the Cap is Sealed Tight button
      And I wait for 420 seconds
      And I click the Next button
      And I click the I see the results button
      And I wait for 2 seconds
      And I verify the photo rules screen appears
      And I click the button: I'm ready to take a photo
      And I wait for 5 seconds
      And I upload the photo of the drugscreen results
      And I wait for 3 seconds
      And I verify the Applicant Review your Uploaded Photo screen appears
      And I click the button: Enter Device Information
      And I wait for 2 seconds
      And I verify the Sample ID screen appears
      And I enter the sample ID "00000100" on the Enter Device Information screen
      And I enter the Barcode "1234" on the Enter Device Information screen in the Applicant UI
      And I wait for 3 seconds
      And I click the Next button
      And I wait for 2 seconds
      And I verify the screen appears: Please wait while we review your results
      And I wait for 2 seconds
      And Set Page
        | AdminPage |
      And the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I wait for 5 seconds in AdminUI
      And I click on the location link for "POSTEMP-TST2" in the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the auto-generated candidate created via EA UI
      And I wait for 5 seconds in AdminUI
      And I verify the page title is showing as Total Number of Devices Used
      And I select the Number of Tests Used for Drug "1" on the Total Number of Devices Used page
      And I click on the Certify button on the Total Number of Devices Used page of the Admin UI
      And I wait for 5 seconds in AdminUI
      And I click the Yes button on the Admin specimen id screen
      And I wait for 2 seconds in AdminUI
      And I verify the page title is showing as Validating for Modified Adjudication page
      And I click Valid Button in the Modified Adjudication Page of the Admin UI
      And I verify that I am navigated to Sign and Submit Page in the Admin UI
      And I enter the consent signature for the Admin adjudication
      And I verify the Sign and Submit button is disabled in Admin UI
      And I select the carrier "FedEx" in the Tracking Information page of the Admin UI
      And I enter the Tracking Number "123456587512" for Tracking Information page of the Admin UI
      And I click certify button for the adjudication in the Modified Adjudication Page
      Then I verify the confirm button is displayed on the Modified Adjudication Confirmation modal
      And I click the confirm button on the adjudication message modal
