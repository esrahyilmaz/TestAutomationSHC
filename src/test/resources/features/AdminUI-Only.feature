Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin

  @amazonSelfCollect @adminUI @AdminUI-Only @amazonST
  Scenario: Admin UI - No tests in progress message
   # This test will only pass if there are no other tests running in parralel
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    When I click on the location link for "CLT4" in the Admin UI
    And I wait for 2 seconds in AdminUI
    Then I can verify the message appears for no active candidates

  @amazonSelfCollect @adminUI @AdminUI-Only @TC5000 @amazonRegression
  Scenario Outline: Login, valid username and valid password
    Given the login page for Room Admin UI is showing in the browser
    When user login with "<username>" and "<password>"
    Then user login successfully

    Examples:
      | username              | password              |
      | data.admin.login.user | data.admin.login.pass |

  @amazonSelfCollect @adminUI @AdminUI-Only @TC2498-01 @amazonST
  Scenario Outline: Login, invalid username and/or invalid password
    Given the login page for Room Admin UI is showing in the browser
    When user login with "<username>" and "<password>"
    Then user login failed

    Examples:
      | username       | password |
      | non_exist_user | any_pass |

  @amazonSelfCollect @adminUI @AdminUI-Only @TC9888 @amazonRegression
  Scenario: Admin UI - Completed Tests Tab: Paginated Results
    Given a request json "WAOrder.json" for CreateOrder api
    And update the json request
      | json path    | new value  |
      | .lastName    | Complete1  |
      | .dateOfBirth | 01/01/2001 |
      | .wellnessId  | [gennum:9] |
      | .EACaseId    | [gennum:9] |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "LookupInvite.json" for LookupInvite api
    And update the json request
      | json path    | new value  |
      | .lastName    | Complete1  |
      | .dateOfBirth | 01/01/2001 |
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api with runtime invite uuid
    And a Post call is sent to the api with retries
    And a response should return with status "200"
    And validate the SubmitImage api response
    And the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the location link for "CLT4" in the Admin UI
    And I click on the Completed Tests Tab in the Admin UI
    When I set the start date range to -13 days prior current date for completed tests
    And I set the end date range to current day for completed tests
    And I wait for 2 seconds in AdminUI
    Then I can verify that I can go to page "2"

  @amazonSelfCollect @adminUI @AdminUI-Only @TC20254 @amazonST
  Scenario:Admin UI: Admin logins to see "Completed tests" label displayed as "Concluded Test"
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 1 seconds in AdminUI
    When I click on the location link for "CLT4" in the Admin UI
    And I wait for 1 seconds in AdminUI
    Then I can verify the concluded and in progress tabs are the only displayed tabs

  @amazonSelfCollect @adminUI @AdminUI-Only @TC26920 @TC26923 @amazonST
  Scenario:Admin UI:FADV Employee should not be able to login  when choosing other than FADV Employee log in option.
    Given the login page for Room Admin UI is showing in the browser
    When I click the Log in button for Admin UI
    And I wait for 3 seconds in AdminUI
    And I verify the sign in page
    And I click Amazon SuperUser button
    And I verify that I am not able to log in
    And I navigate back
    And I click Amazon RoomAdmin button
    Then I verify that I am not able to log in

  @amazonSelfCollect @adminUI @AdminUI-Only @TC35677 @amazonST
  Scenario: Admin UI -  Manage Orders Header: "Placed Orders", "Create New Order" and "Bulk Orders" needs to be displayed
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    When I click on the menu and choose Manage Orders
    And I wait for 3 seconds in AdminUI
    Then I verify header has Placed Orders, Create New Order and Bulk orders
    And I verify Placed Orders page opening as a default

  @amazonSelfCollect @adminUI @AdminUI-Only @TC48244 @amazonST
  Scenario: Admin UI - Drug Testing Center Should be appeared instead of admin UI
    Given the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    Then I verify the "Drug Testing Center" is available on Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Only @TC48502 @TC47602 @amazonST
  Scenario: Admin UI - Bulk Orders:  Bulk Order landing page should have column with the details
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    When I click the Manage Orders Tab "Bulk Orders"
    Then I verify Bulk Orders page displays in the Admin UI
    And I verify all column headers "Status, Creator, File name, Date/Time, Batch ID, Package, Reason for Test" exists for Bulk Upload Table in the Admin UI
    And I verify chronological order exists for items in the Bulk Order List in the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Only @TC77216 @TC77220 @amazonST
  Scenario: Admin UI - Landing Page: Search Filters "Location Name", "State" and "Reason for Test" should be displayed
    Given the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    And I wait for 1 seconds in AdminUI
    Then I verify that I am on the Locations Landing page of the Admin UI
    And I verify Location Name and State search filters are displayed in the Landing Page of the Admin UI
    And I verify Location Name and State fields are displayed in the Search Results Grid of the Landing Page

  @amazonSelfCollect @adminUI @AdminUI-Only @TC81547 @TC81553 @amazonST
  Scenario: Admin UI - 'User Guide' icon should be in the top right corner
    Given the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    Then I verify that User Guide is visible
    And I verify that version number is not visible on the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Only @TC76968 @TC76960 @TC76964 @amazonRegression
  Scenario: Admin UI - Ability to search by Location - Message should be shown if matching result does not found
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    When I enter "abc" into the Location search filter of Landing Page in Admin UI
    Then I can verify that No Matching Locations Found error message is given
    And I enter "abc" into the State search filter of Landing Page in Admin UI
    And I can verify that No Matching Locations Found error message is given
    And I enter "LGB" into the Location search filter of Landing Page in Admin UI
    And I can verify that the search results are showing "LGB" locations in the Admin UI
    And I enter "CA" into the State search filter of Landing Page in Admin UI
    And I can verify that the search results are showing "CA" state locations in the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Only @TC77100 @TC77101 @amazonRegression
  Scenario: Admin UI - Landing page: Admin should only see last three visited location names
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    When I click on the location link for "CLT4" in the Admin UI
    And I click the browser back button
    And I click on the location link for "RDM-DET1" in the Admin UI
    And I click the browser back button
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I click the browser back button
    Then I can verify the Recent Locations are "CLT4", "RDM-DET1" and "RDM-CLT4" in the Admin UI
    And I click the browser back button
    And I click on the location link for "RDM-CLT4" in the Admin UI
    And I can verify that I am on the Tests in Progress page of the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Only @TC79129 @amazonST
  Scenario: Admin UI - Create New Order: Hiring Information Page label should be changed to "Location Information"
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    When I click the Manage Orders Tab "Create New Order"
    Then I verify the page title is showing as Location Information page
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason " Post Accident "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI

  @amazonSelfCollect @adminUI @AdminUI-Only @TC140959 @amazonRegression
  Scenario: Admin UI - Update Reasons for Drug Test Dropdown Menu in Create Order Screen
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I verify the page title is showing as Location Information page
    When I click on the Reason for test drop-down menu in Admin UI
    And I wait for 2 seconds in AdminUI
    Then I verify Order Reasons drop down options are listed as expected on the Location Information Page





