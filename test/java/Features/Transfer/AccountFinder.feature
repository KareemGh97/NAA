@AccountFinder
Feature: Account Finder

  @JiraIntegration @Priority:High @TEST_XRAY-1387
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 1 - User activate the account finder
  """
 Description:
 Note: the user needs ARB cic to activate
 This scenario covers the complete flow for a user to activate account finder for the first time (TC ID: XDI-29841 ).
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And Add "100" points to the account
    Then user goes to Account Finder option from transfer quick action
    When a message 'You have to activate account finder first' appear
    Then user click on confirm to activate account finder
    And pass IVR call
    Then account finder is activated successfully

  @JiraIntegration @Priority:High @TEST_XRAY-1388
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 2 - initiate account finder inquiry
  """
 Description:
 This scenario covers the complete flow for a user to initiate account finder inquiry (TC ID: XDI-29877 )
 and View the final inquiry result. (TC ID: XDI-29883 )
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And Add "100" points to the account
    Then user goes to Account Finder option from transfer quick action
    And active account finder if it not active
    And user select Inquiry option
    When user enter the OTP as "0000"
    Then user did get Inquiry screen successfully