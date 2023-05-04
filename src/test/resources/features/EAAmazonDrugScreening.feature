Feature: EA for Amazon Drug Screening

  @amazon30 @eaOrderEntry
  Scenario: EA Order Entry 1
    Given I navigate to the EA application and login to the set environment
    When I click on New Order link
    And I provide data on Order tab
     | field          | value               |
     | custom package | Oraltox Drug Screen |
     | cid            | 12354           |
    And I click on Next button
    And I provide data on Subject tab
      | field         | value               |
      | first name    | test                |
      | last name     | Auto[gennum:5]      |
      | phone number  | 4042229999          |
      | email address | long.pham1@fadv.com |
      | birth day     | 01                  |
      | birth month   | February      |
      | birth year    | 2000                |
      | address 1     | 3111 main street    |
      | city          | Duluth              |
      | state         | GEORGIA             |
      | zip           | 30096               |
      | have ssn      | yes                  |
      |social security number | null         |
    And I click on Review Order tab
    And I click on Submit Order button
    Then I verify the order created successfully
    And I logout of EA
    And I wait for 60 seconds
    And I navigate to the applicant welcome screen after retrieving newly create order via UI
    And I click the speech play button on the start screen
    And I enter the Applicant information retrieved from EA UI and set booth number to "9"
    And I click the Next button
    And I can verify the Applicant Review Information screen appears


  @TC13910 @amazon30 @eaOrderEntry
  Scenario: EA- OralTox: Enabling Required Zip Code field for Package Preference
    Given I navigate to the EA application and login to the set environment
    And I click on New Order link
    And I provide data on Order tab
      | field          | value               |
      | custom package | Oraltox Drug Screen |
    And I click on Next button
    When I provide data on Subject tab
      | field         | value               |
      | first name    | test                |
      | last name     | Auto[gennum:5]      |
      | phone number  | 4042229999          |
      | email address | long.pham1@fadv.com |
      | birth day     | 01                  |
      | birth month   | January             |
      | birth year    | 2000                |
      | address 1     | 3111 main street    |
      | city          | Duluth              |
      | state         | GEORGIA             |
      | have ssn      | no                  |
    And I click on Review Order tab
    Then I verify the zip required message appears when creating an EA order
    And I logout of EA
    
  @TC18910 @amazon30 @eaOrderEntry
  Scenario: EA Oraltox: No Order Created without Social Security Number
    Given I navigate to the EA application and login to the set environment
    When I click on New Order link
    And I provide data on Order tab
      | field          | value               |
      | custom package | Oraltox Drug Screen |
    And I click on Next button
    And I provide data on Subject tab
      | field         | value               |
      | first name    | test                |
      | last name     | Auto[gennum:5]      |
      | phone number  | 4042229999          |
      | email address | long.pham1@fadv.com |
      | birth day     | 01                  |
      | birth month   | February      |
      | birth year    | 2000                |
      | address 1     | 3111 main street    |
      | city          | Duluth              |
      | state         | GEORGIA             |
      | zip           | 30096               |
      | have ssn      | no                  |
    And I click on Review Order tab
    And I click on Submit Order button
    And I verify the order created successfully
    And I logout of EA
    And I wait for 60 seconds
    And I navigate to the applicant welcome screen after retrieving newly create order via UI
    And I click the speech play button on the start screen
    And I enter last four digits of social security number "1111"
    And I enter the Applicant information retrieved from EA UI without SSN and booth number
    Then I can verify the error message appears for non-matching last name or birthday or social security number

  @amazon30 @eaOrderEntry @TC86804
  Scenario: EA Order Entry 1 for Random
    Given I navigate to the EA application and login to the environment for random test account
    When I click on New Order link
    And I enter Order Information on Order tab
      | field       | value |
      | employee id | 12356 |
      | alias       | alias |
    And I provide data on Order tab
      | field          | value                  |
      | Custom Package | Oral Tox Random Screen |
    And I click on Next button
    And I wait for 3 seconds in EA
    Then I verify that I am on Subject tab
