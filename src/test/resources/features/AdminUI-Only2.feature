Feature: Room Admin UI
  This feature is related to the Admin UI application and the functionality of a Room Admin

  @amazonSelfCollect @adminUI @AdminUI-Only2 @TC138593 @TC138325 @TC138594 @TC138324 @amazonRegression
  Scenario: Admin UI - Add New Business Line - USSC
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And I click on the menu and choose Manage Orders
    And I click the Manage Orders Tab "Create New Order"
    And I verify the page title is showing as Location Information page
    And I wait for 1 seconds in AdminUI
    And I choose the Package Reason " Random "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I click on the Business Line list on the Package Information Page
    When I verify that I can see the business Line as "  United States Sorting Center " on the Package Information page of Admin UI
    And I can click the previous button for the order in the Admin UI
    And I choose the Package Reason " Pre-employment "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    Then I verify that the Business Line is disabled on the Package Information page of Admin UI
    And I can click the previous button for the order in the Admin UI
    And I choose the Package Reason " Reasonable Suspicion "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I verify that the Business Line is disabled on the Package Information page of Admin UI
    And I can click the previous button for the order in the Admin UI
    And I choose the Package Reason " Post Accident "
    And I choose the country "United States of America" for the order within the Admin UI
    And I enter the city "Houston" for the order
    And I choose the state "Texas" on the Location Information Screen
    And I click the next button for the order in the Admin UI
    And I can verify the Package Information screen is displayed
    And I verify that the Business Line is disabled on the Package Information page of Admin UI


