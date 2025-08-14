@Documents
Feature: Request IBAN letter - UI Smoke Test Set

  @TEST_XRAY-1185 @JiraIntegration @Priority:High
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 1 - Verify adhoc documents by Check the ability of Request IBAN Letter (Success) and (preview - downloading ) it
  """
		 Description: Check the ability of Request IBAN Letter (Success) and (preview - downloading ) it,
		 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user click on click on navigate to Account button
    And user request new document
    Then verify that user can preview requested document and download it

  @TEST_XRAY-1291 @JiraIntegration @Priority:High
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 2 - Verify adhoc documents by Check the ability of Request Bank Certificate (Success) and (preview - downloading ) it
  """
		 Description: Check the ability of Request Bank Certificate (Success) and (preview - downloading ) it,
		 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user click on click on navigate to Account button
    And user request new bank certificate document
    Then verify that user can preview requested document and download it

  @Bug_PC-57356
  @TEST_XRAY-1292 @JiraIntegration @Priority:High
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 3 - Verify adhoc documents by Check the ability of Request Tax Invoice Certificate (Success) and (preview - downloading ) it
  """
		 Description: Check the ability of Request Tax Invoice Certificate (Success) and (preview - downloading ) it,
		 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user click on click on navigate to Account button
    And user request new Tax Invoice Certificate document
    Then verify that user can download the requested document
