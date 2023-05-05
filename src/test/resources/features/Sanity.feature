@Sanity
  Feature:Login Using Self Healing Code
    @Sanity_01
    Scenario:Admin UI Login
      Given the login page for Room Admin UI is showing in the browser
      And Set Page
        | AdminUILoginPage |
      And user login with "data.admin.login.user" and "data.admin.login.pass"