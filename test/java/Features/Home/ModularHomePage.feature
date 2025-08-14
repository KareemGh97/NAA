@homeModular
Feature: Home module | as a user i want to

  @JiraIntegration @Priority:Medium @TEST_XRAY-2468
  @Regression
  Scenario: 1 - user login an see the account page
  """
 Description: user login and see the account page
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    When user click on click on navigate to Account button
    Then user can access the customer account management

  @JiraIntegration @Priority:low @TEST_XRAY-2467
  @Regression
  Scenario: 2 - user View Pending Actions on the home page
  """
 Description: user View Pending Actions on the home page
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And the customer has pending actions
    When the customer clicks on View Tasks
    Then each pending action shall include the following details: Title AND Description
    And the selected pending action shall display a navigation CTA

  @JiraIntegration @Priority:low @TEST_XRAY-2469
  @Regression
  Scenario: 3 - user check the arrangement of components on home page
  """
 Description: user check the arrangement of components on home page
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And the customer go to customization Home Section
    And the customer edit Home Screen
