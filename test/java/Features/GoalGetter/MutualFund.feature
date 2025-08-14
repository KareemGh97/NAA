@GoalGetter @MutualFund
Feature: Mutual fund

  @TEST_XRAY-1300 @TESTSET_XRAY-1299 @Bug_PC-49717 @JiraIntegration @Priority:Medium @UserStoryId:PC-44405 @TestCaseId:XDI-31112
  Scenario Outline: 1 - Mutual Fund Enhancement-SL-98-Validate the onboarding flow (success)
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    Then User selects Mutual Fund product and Navigates to suitability Questions screen

    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 552233220   | 1000021226 | 1552233220     | 206815   | 0000 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 552233220   | 1000021226 | 1552233220     | 206815   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 512651648   | 1651050980     | 1000006365 | 101010   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 512651648   | 1651050980     | 1000006365 | 101010   | 0000 |