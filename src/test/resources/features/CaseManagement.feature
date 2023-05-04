@caseManagement
Feature: Case Management for EA Orders


  @amazon30 @eaCM
  Scenario: EA Case Management Case Details Action
    Given I navigate to the EA application and login to use the Case Management system
#    Given I navigate to the EA application and login to the set environment
#    Given I navigate to EA application and login
#      | account                | user               | password               |
#      | data.ea.login.account  | data.ea.login.user | data.ea.login.password |
    When I click on Cases In Queue link
    And I select the user "tester" in the case queue table
    And I click on the Case Details case action
    Then I can verify Case Status is "Processor Assigned"


#  need to update last 2 steps once the E.I.A.F status is working completely
#  need to make E.I.A.F process done via database
  @amazon30 @eaCM @TC6452
  Scenario: Case Management: Available option "Not To Consider Case as Peer Review"
    Given I navigate to EA application and login
      | account                | user               | password               |
      | data.cm.uat.login.account  | data.cm.uat.login.user | data.cm.uat.login.password |
    And I click on Cases In Queue link
    And I select the user "THCHECKCMOOO" in the case queue table
    When I click on the Case Details case action
    Then I click on the order actions to verify "Peer Review Complete" exists in the list
    And I can verify Case Status is "Completed"


  @amazon30 @eaCM @TC20278 @TC20281
  Scenario: Case Management: Peer Processors and Reviewers in HomePage Widget
    Given I navigate to the EA application and login as Case Management system user
    When I view the case management widget on the homepage
    Then I can verify the user "Reviewer,Processor" is in the available Secondary Processor dropdown of the Case Management widget
    And I can verify the user "Reviewer" is in the available Reviewer dropdown of the Case Management widget
    And I logout of EA