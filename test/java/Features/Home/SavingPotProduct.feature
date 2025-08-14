@SavingPotProduct @GoalGetter
@Android @iOS @SIT @UAT
Feature: Saving Pot Product | as a user i want to create and manage my saving goal

  @JiraIntegration @Priority:Medium @TEST_XRAY-2750
  @Regression @Smoke
  Scenario: 1 - create a new Saving Pot Product
  """
 Description: XDI-39563
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots page from the shortcut
    When user create a new saving pot
    And verify that saving pot is created

  @JiraIntegration @Priority:Medium @TEST_XRAY-2751
  @Regression @Smoke
  Scenario: 2 - add money to saving pot
  """
 Description: XDI-39574
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And add money to the user account
    Then user goes to saving pots page from the shortcut
    And enter an existing saving pot
    Then add money to saving pot product
    And verify the amount added is correct

  @JiraIntegration @Priority:Medium @TEST_XRAY-2752
  @Regression @Smoke
  Scenario: 3 - Withdraw money from the saving pot
  """
 Description: XDI-39575
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And add money to the user account
    Then user goes to saving pots page from the shortcut
    And enter an existing saving pot
    Then user withdraw money from the saving pot
    And verify the amount withdrew is correct

  @JiraIntegration @Priority:Medium @TEST_XRAY-2754
  @Regression @Smoke
  Scenario: 4 - Edit saving pot
  """
 Description: XDI-39564
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots page from the shortcut
    And enter an existing saving pot
    Then edit the saving pot
    And verify that the saving pot is edited correctly

  @JiraIntegration @Priority:Medium @TEST_XRAY-2755
  @Regression @Smoke
  Scenario: 5 - Closing saving pot
  """
 Description: XDI-39565
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots page from the shortcut
    And enter an existing saving pot
    Then close the saving pot
    And verify that the saving pot is closed
