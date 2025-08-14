@SessionManagement
Feature: Session | as a user i want to Verify Session once i leave it out for a while without any interaction

  @JiraIntegration
    @Priority:Medium
    @UserStoryId:XRAY-492
    @TestCaseId:XRAY-608
    @TEST_XRAY-601
    @TESTSET_XRAY-600
    @Scope_1.0
  Scenario Template: 1 - Mobile session will force user to logout after time of leave it away-One time login
  """
 Description: user will logout when he Leave session away for more than 1 min ,
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user will be locked due to inactivity for "<waitingPeriod>" sec and return back to Login screen
    @Android
    @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 585062479   | 1000020437 | 1560810721     | 135792   | 0000 | 300000        |
    @iOS
    @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 574319568   | 1000020439 | 2744936556     | 135792   | 0000 | 300000        |

  @JiraIntegration
    @Priority:Medium
    @UserStoryId:XRAY-492
    @TestCaseId:XRAY-601
    @TEST_XRAY-603
    @TESTSET_XRAY-600
    @Scope_1.0
  Scenario Template: 2 - Mobile session will force user to logout after time of leave it away -Login in with Register device
  """
 Description: user will logout when he Leave session away for more than 1 min ,
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user will be locked due to inactivity for "<waitingPeriod>" sec and return back to Passcode screen
    @Android
    @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 525387460   | 1000020440 | 2130266949     | 135792   | 0000 | 300000        |
    @iOS
    @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 576528901   | 1000020524 | 1247375858     | 135792   | 0000 | 300000        |

  @SessionManagement
    @JiraIntegration
    @Priority:Medium
    @UserStoryId:XRAY-492
    @TestCaseId:XRAY-603
    @TEST_XRAY-605
    @TESTSET_XRAY-600
  Scenario Template: 3 - Accept time extension when a mobile session asks the user to take extra time after leaving it for a while
  """
 Description: user accept More time which appear after leaving mobile session away without using
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user will confirm more time when he leave session away for "<waitingPeriod>" sec
    And user UnRegister Device

    @Android
    @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 595813762   | 1000020527 | 2313501765     | 135792   | 0000 | 300000        |
    @iOS
    @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 593412507   | 1000020528 | 1104940224     | 135792   | 0000 | 300000        |

  @SessionManagement @JiraIntegration @Priority:Medium @UserStoryId:XRAY-492 @TestCaseId:XRAY-605
    @TEST_XRAY-608 @TESTSET_XRAY-600 @Scope_1.0
  Scenario Template: 4 - Reject time extension when a mobile session asks the user to take extra time after leaving it for a while
  """
 Description: user will reject More time which appear after leaving mobile session away without using before forcing the logout behaviour
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user will reject more time when he leave session away for "<waitingPeriod>" sec
    @Android @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 505498376   | 1000020532 | 2428164699     | 135779   | 0000 | 300000        |
    @iOS @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | waitingPeriod |
      | 554639718   | 1000020539 | 2275795371     | 135792   | 0000 | 300000        |

