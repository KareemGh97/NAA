@Passcode
Feature: User Can Update/Reset Passcode

  @JiraIntegration @Priority:Highest @TEST_XRAY-1225
    @Regression
    @Android @iOS @SIT @UAT
  Scenario: 1 - Verify that user can't update his passcode with same old passcode
  """
 Description: Verify that user can't update his passcode with same old passcode
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And user update old passcode using old passcode
    Then user verify "same old passcode" error message

  @JiraIntegration @Priority:Highest @TEST_XRAY-1336
    @Regression
    @Android @iOS @SIT @UAT
  Scenario Template: 2 - Verify that user can't update his passcode with mismatch passcodes
  """
 Description: Verify that user can't update his passcode with mismatch passcodes
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And user update old passcode using mismatch passcode "<newPasscode>"
    Then user verify "error mismatch" error message
    Examples:
      | newPasscode |
      | 785698      |

  @JiraIntegration @Priority:Highest @TEST_XRAY-1482
    @Regression @Smoke
    @Android @iOS @SIT @UAT
  Scenario Template: 3 - Verify that user can reset his passcode successfully using Nafath
    Given The user skip App introduction
    When Read user Data from csv file
    And user SignIn oneTimeUse with phoneNumber NationalId from csv file and click on forget passcode
    And user sign in with with phoneNumber NationalId from csv file OTP "<otp>" using Nafath
    And user reset passcode to new passcode
    And user SignIn after change passcode with phoneNumber NationalId from csv file and OTP "<otp>"
    Examples:
      | otp  |
      | 0000 |

  @JiraIntegration @Priority:Highest @TEST_XRAY-1224
    @Smoke @Regression
    @Android @iOS @SIT @UAT
  Scenario: 4 - Verify that user can update his passcode successfully
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And user update old passcode to new passcode
    And user SignOut
    And user SignIn after change passcode with phoneNumber NationalId from csv file and OTP "0000"

  @JiraIntegration @Priority:Highest @TEST_XRAY-1227
    @Regression @Smoke
  Scenario Template: 5 - Verify that user can reset his passcode successfully using debit card
#    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" and click on forget passcode
    And user sign in with with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" OTP "<otp>" card pin "<PIN>" in the forget passcode screen
    And user reset passcode to new passcode
    And user SignIn after change passcode with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" OTP"<otp>"
    @Android @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | otp  | PIN  |
      | 508295173   | 1000021186 | 1668214438     | 0000 | 1995 |
    @iOS @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | otp  | PIN  |
      | 508295173   | 1000021186 | 1668214438     | 0000 | 1995 |
    @Android @iOS @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | otp  | PIN  |
      | 567014385   | 1000010540 | 1268452073     | 0000 | 2200 |