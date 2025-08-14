@SavingPots
@Android @iOS @SIT @UAT
Feature: Saving Pots | as a user i want to create and manage Saving pots

# --------------------------------create + add money + collect goal ---------------------------------------------
  @JiraIntegration @Priority:Medium @TEST_XRAY-1270
  @Regression @Smoke
  Scenario: 1 - Verify that user can collect saving pot goal
  """
 Description:
 This scenario verifies that a user can create a saving pot goal(TC ID: XDI-29783 ),
 add money to it (TC ID: XDI-30254 ) , and then collect the goal successfully. (TC ID: XDI-31038 )
"""
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots from goal getter footer tap
    And user complete the saving pot details
    Then saving pot is created successfully
    And user added money to there goal
    And choose collect your goal options

# --------------------------------Delete Recurring Setup---------------------------------------------

  @JiraIntegration @Priority:Medium @TEST_XRAY-1271
  @Regression @Smoke
  Scenario: 2 - Verify that user can end the saving pot goal (Delete Recurring Setup)
  """
 Description:
 This scenario verifies that a user can end a saving pot goal
 and delete the recurring setup while keeping the actual product (TC ID: XDI-30255 ).
"""
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots from goal getter footer tap
    And user complete the saving pot details
    Then saving pot is created successfully
    When user enter the saving pot goal and click on three dots on the top right corner
    And user end the goal and collect it
    Then the saving pot goal is ended successfully

# --------------------------------Extend saving pot---------------------------------------------

  @JiraIntegration @Priority:Medium @TEST_XRAY-1337
  @Bug-PC-52918
  @Regression @Smoke
  Scenario: 3 - Verify that user can extend saving pot Goal
  """
 Description:
 This scenario verifies that a user can extend a saving pot goal (TC ID: XDI-30258 ).
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots from goal getter footer tap
    And user complete the saving pot details
    Then saving pot is created successfully
    And user added money to there goal
    And choose extend your goal options
    And extend there goal with extra amount of "1500"

# --------------------------------Edit saving pot---------------------------------------------

  @JiraIntegration @Priority:Medium @TEST_XRAY-2246
  @Regression @Smoke
  Scenario: 4 - Verify that user can edit saving pot Goal
  """
 Description:
 This scenario verifies that a user can extend a saving pot goal (TC ID: XDI-30258 ).
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user goes to saving pots from goal getter footer tap
    And user complete the saving pot details
    Then saving pot is created successfully
    When user enter the saving pot goal and click on three dots on the top right corner
    And user edit the goal details with "2500" target amount and "10" as contribution
    Then confirm the changes of the goal on the summary
    When user enter the OTP as "0000"
    And click on Check It Out button
    Then verify that edits are reflected to the goal