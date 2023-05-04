@oraltox
Feature: Oral-Tox Batch Upload



  @amazon30 @eaBatchOrder
  Scenario: EA Process Batch Order
    Given I navigate to the EA application and login to the set environment
    When I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraltox Drug Screen |
      | upload file    | Batch_OralTox.xls   |
      | upload name    | upload [gennum:4]   |
    And I click on Process Batch button
    Then I verify the batch order created successfully
    And I logout of EA


  @TC3322 @amazon30 @eaBatchOrder @amazonEAst @Test
  Scenario: EA: OralTox Batch Upload with 'Select Reason For Test'  Required Message
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the set environment
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraltox Drug Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      |Last Name          |First Name|DOB (MM/DD/YYYY)|SSN (###-##-####)|Phone Number [(###)###-####]|Email Address       |Address1 (123 Main Street) |City        |State |Zip  |
      |AutomationCandidate|Batch     |1/1/1980        |334-35-0909      |(357)557-4509               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |30519|
    And I provide data on Batch Processing page
      | field                | value               |
      | custom package       | Oraltox Drug Screen |
      | use download location|      default        |
      | upload name          | upload [gennum:4]   |
    And I click on Process Batch button
    And I cleanup existing files in the downloads folder
    And I click the Download Rejects button for batch
    And I wait for 10 seconds
    Then  I verify the Header "Reason For Test" is present in the Excel Type xls spreadsheet
    And I verify the required message appears for the missing Reason For Test field or value
    And I cleanup existing files in the downloads folder


  @TC3325 @amazon30 @eaBatchOrder @amazonEAst
  Scenario: EA: OralTox Batch Upload with 'Select Reason For Test' = PRE_EMPLOYMENT
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the set environment
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraltox Drug Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      |Last Name              |First Name|DOB (MM/DD/YYYY)|SSN (###-##-####)|Phone Number [(###)###-####]|Email Address       |Address1 (123 Main Street) |City        |State |Zip  |Reason For Test|
      |ToxAutomationCandidate |Batch     |1/1/1980        |334-35-0909      |(357)557-4509               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |30519|PRE_EMPLOYMENT |
      |ToxAutomationCandidate2|Batch     |1/1/1980        |334-35-0910      |(357)557-4508               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |30519|PRE_EMPLOYMENT |
    And I provide data on Batch Processing page
      | field                | value               |
      | custom package       | Oraltox Drug Screen |
      | use download location|      default        |
      | upload name          | upload [gennum:4]   |
    And I click on Process Batch button
    Then I verify "Submitted:2" batch orders created successfully
    And I cleanup existing files in the downloads folder


  @amazon30 @eaBatchOrder @amazonEAst @TC13911
  Scenario: EA: OralTox Batch Upload with Zip Required Message
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the set environment
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value               |
      | custom package | Oraltox Drug Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      |Last Name              |First Name|DOB (MM/DD/YYYY)|SSN (###-##-####)|Phone Number [(###)###-####]|Email Address       |Address1 (123 Main Street) |City        |State |Reason For Test|
      |ToxZipRequired         |Batch     |1/1/1980        |334-35-0808      |(357)557-4509               |tonia.hines@fadv.com|123 S Main St              |Buford      |Ga    |PRE_EMPLOYMENT |
    And I provide data on Batch Processing page
      | field                | value               |
      | custom package       | Oraltox Drug Screen |
      | use download location|      default        |
      | upload name          | upload [gennum:4]   |
    And I click on Process Batch button
    And I cleanup existing files in the downloads folder
    And I click the Download Rejects button for batch
    And I wait for 10 seconds
    Then  I verify the Header "Zip" is present in the Excel Type xls spreadsheet
    And I verify the required message appears for the missing Zip Code field or value
    And I cleanup existing files in the downloads folder


  @TC74074 @amazon30 @eaBatchOrder @amazonEAst
  Scenario:System should throw error in XLS file in ClientRef2 field is left blank in Batch file
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the environment for random test account
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value                  |
      | Custom Package | Oral Tox Random Screen |
    And I click the Download Template button in the batch upload section
    And I wait for 5 seconds
    When I insert the data into the downloaded blank batch spreadsheet
      | CR1 (EMPLOYEE ID) | CR2 (ALIAS) | Last Name               | First Name | DOB (MM/DD/YYYY) | SSN (###-##-####) | Phone Number [(###)###-####] | Email Address        | Address1 (123 Main Street) | City   | State | Zip   | Reason For Test |
      | 69578             |             | ToxAutomationCandidate  | Batch      | 1/1/1980         | 334-35-0909       | (357)557-4509                | tonia.hines@fadv.com | 123 S Main St              | Buford | Ga    | 30519 | RANDOM          |
      | 69579             |             | ToxAutomationCandidate2 | Batch      | 1/1/1980         | 334-35-0910       | (357)557-4508                | tonia.hines@fadv.com | 123 S Main St              | Buford | Ga    | 30519 | OTHER           |
    And I provide data on Batch Processing page
      | field                 | value                  |
      | custom package        | Oral Tox Random Screen |
      | use download location | default                |
      | upload name           | upload [gennum:4]      |
    And I click on Process Batch button
    And I wait for 2 seconds
    And I verify "Submitted:2" batch orders created successfully
    And I wait for 2 seconds
    And I cleanup existing files in the downloads folder
    And I click the Download Rejects button for batch
    And I wait for 10 seconds
    Then  I verify the Header "CR2 (ALIAS (LETTERS ONLY))" is present in the Excel Type xls spreadsheet
    And I verify the required message appears for the missing Client Reference for Alias field or value
    And I cleanup existing files in the downloads folder

  @TC74083 @amazon30 @eaBatchOrder @amazonEAst @TC86806
  Scenario:EA BATCH Oraltox Non-Preemployment orders - System should throw error if ClientRef2 field is blank
    Given I cleanup existing files in the downloads folder
    And I navigate to the EA application and login to the environment for random test account
    And I click on Process Batch link
    And I provide data on Batch Processing page
      | field          | value                  |
      | Custom Package | Oral Tox Random Screen |
    When I click the Download Template button in the batch upload section
    And I wait for 6 seconds
    And I insert the data into the downloaded blank batch spreadsheet
      | CR1 (EMPLOYEE ID) | CR2 (ALIAS) | Last Name               | First Name | DOB (MM/DD/YYYY) | SSN (###-##-####) | Phone Number [(###)###-####] | Email Address        | Address1 (123 Main Street) | City   | State | Zip   | Reason For Test |
      | 123547            | ALIAS       | ToxAutomationCandidate  | Batch      | 1/1/1980         | 334-35-0909       | (357)557-4509                | tonia.hines@fadv.com | 123 S Main St              | Buford | Ga    | 30519 | RANDOM          |
      | 123654            | ALIASABC    | ToxAutomationCandidate2 | Batch      | 1/1/1980         | 334-35-0910       | (357)557-4508                | tonia.hines@fadv.com | 123 S Main St              | Buford | Ga    | 30519 | OTHER           |
    And I provide data on Batch Processing page
      | field                 | value                  |
      | custom package        | Oral Tox Random Screen |
      | use download location | default                |
      | upload name           | upload [gennum:4]      |
    And I click on Process Batch button
    And I wait for 2 seconds
    Then I verify "Submitted:2" batch orders created successfully
    And I wait for 2 seconds
    And I cleanup existing files in the downloads folder
    And I wait for 2 seconds
    And I navigate to Non-Preemployment applicant UI screen using the alias "RDM-CLT4" for orders created via Admin UI
    And I wait for 2 seconds
    And I click the speech play button on the start screen
    And I enter the Applicant Last Name "ToxAutomationCandidate", Birthday "01/01/1980", and alias " "
    And I click the get started button on the Get Started screen
    And I verify Please enter a valid Amazon alias message appears on the Get Started screen
