@Sanity
  Feature:Login Using Self Healing Code
    @Sanity_01
    Scenario:Admin UI Login
      Given the login page for Room Admin UI is showing in the browser
      And Set Page
        | AdminUILoginPage |
      And user login with "data.admin.login.user" and "data.admin.login.pass"
      And I click on the menu and choose Manage Orders
      And I click the Manage Orders Tab "Create New Order"
      And I wait for 1 seconds in AdminUI
      And I choose the Package Reason "Pre-employment"
      And I click the next button for the order in the Admin UI
      And I can verify the Package Information screen is displayed
      And I click the next button for the order in the Admin UI
      And I can verify the Identification Information screen is displayed
      And I enter the Candidate ID Number "123456789011" on the Identification Information Screen
      And I enter First Name "Alice" on the Identification Information Screen
      And I enter Last Name "Pete" on the Identification Information Screen
      And I enter Date of Birth  "01/01/2001" on the Identification Information Screen
#      And I enter Social Security Number "123-44-5544" on the Identification Information Screen
      And I click the next button for the order in the Admin UI
      And I can verify the Contact Information screen is displayed
      And I enter the phone number "678-546-3324" for the order in the Admin UI
      And I enter the email address "tonia.hines@fadv.com" for the order in the Admin UI
      When I click the next button for the order in the Admin UI
      Then I can verify the Residence Information screen is displayed
      And I click the browser back button
      And I can verify the Residence Information screen is displayed
      And I can verify the Country is present for the order in the Admin UI
      And I verify the address first line is present on the Residence Screen
      And I verify the address second line is present on the Residence Screen
      And I can verify the City is present for the order within the Admin UI
      And I can verify the State is present for the order in the Admin UI
      And I can verify Zip Code is present for the order in the Admin UI
      And I choose the country "United States of America" for the order within the Admin UI
      And I enter "123 main st" in the first line of the address for the order
      And I enter "suite 23" in the second line of the address for the order
      And I enter the city "Dallas" for the order
      And I choose the state "Georgia" on the Location Information Screen
      And I enter the zip code "30132" for the order
      And I click on the submit button for the order in the Admin UI
      And I verify the Order completed message in the Admin UI
