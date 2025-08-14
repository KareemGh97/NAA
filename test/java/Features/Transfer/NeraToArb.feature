@CroToArb
@not_on_UAT_yet
Feature: Transfer || as a user i want to Send Money To ARB Customers

  @JiraIntegration
    @TEST_XRAY-591
    @Priority:Highest
    @Regression
    @Smoke
  Scenario Outline: 1 - user transfer CRO to ARB by using Email and amount less than 2500
  """
 Description : user transfer CRO to ARB by using Email and amount less than 2500
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    Then add money to the user account
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user remove all restrictions for the user "<CIC>"
 #And user save account balance before transfer
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user transfer "<transferType>" by using receiver email "<ReceiverEmail>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverEmail            | transferType |
      | 526941703   | 1000030065 | 102236009     | 2905565087     | 135792   | 0000 | 1      | u3084404X@banking.com.sa | CroToArb     |
      #| 596287354   | 1000021187 | 102236009     | 1156068296     | 135792   | 0000 | 1      | u3084404X@banking.com.sa | CroToArb     |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverEmail            | transferType |
      | 596287354   | 1000021187 | 102236009     | 1156068296     | 135792   | 0000 | 1      | u3084404X@banking.com.sa | CroToArb     |

  @JiraIntegration
    @TEST_XRAY-588
    @Priority:High
    @Smoke
    @Regression
  Scenario Outline: 2 - user transfer CRO to ARB by using IBAN number and amount less than 2500
  """
 Description : user transfer CRO to ARB by using IBAN number and amount less than 2500
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
# And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user remove all restrictions for the user "<CIC>"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user transfer by using receiver fullName "<fullName>" and IBAN "<IBAN>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 532106587   | 1000021191 | 1202037170     | 135792   | 0000 | 5      | mohamed  | SA9080000204608015995347 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 574319568   | 1000020439 | 2744936556     | 135792   | 0000 | 5      | mohamed  | SA9080000204608015995347 |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 561029837   | 1000007272 | 1148357209     | 135792   | 0000 | 5      | mohamed  | SA5655000000001198802436 |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 561029837   | 1000007272 | 1148357209     | 135792   | 0000 | 5      | mohamed  | SA5655000000001198802436 |

  @JiraIntegration
    @TEST_XRAY-589
    @Priority:High
    @Smoke
    @Regression
  Scenario Outline: 3 - user transfer CRO to ARB by using Mobile number and amount less than 2500
  """
 Description : user transfer CRO to ARB by using Mobile number and amount less than 2500
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
 #And user save account balance before transfer
    And user remove all restrictions for the user "<CIC>"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user transfer by using receiver phoneNumber "<ReceiverPhoneNumber>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber |
      | 590971582   | 1000024851 | 101575648     | 2592889386     | 135792   | 0000 | 1.11   | 569315047           |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber |
# | 570468912 | 1000020434 | 102807146 | 2878339312 | 135792 | 0000 | 1.11 |569315047|
      | 590971582   | 1000024851 | 101575648     | 2592889386     | 135792   | 0000 | 1.11   | 569315047           |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber |
      | 579081346   | 1000007308 | 100965313     | 1603781925     | 135792   | 0000 | 1.11   | 509250000           |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber |
      | 579081346   | 1000007308 | 100965313     | 1603781925     | 135792   | 0000 | 1.11   | 509250000           |

  @JiraIntegration
    @TEST_XRAY-590
    @Priority:Highest
    @Regression
    @Smoke
  Scenario Outline: 4 - user transfer CRO to ARB by using NationalId and amount less than 2500
  """
 Description : user transfer CRO to ARB by using NationalId and amount less than 2500
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user remove all restrictions for the user "<CIC>"
 #And user save account balance before transfer
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user transfer "<TransferType>" by using receiver nationalId "<ReceiverNationalId>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | TransferType |
      | 562783159   | 1000021662 | 100718887     | 1033624618     | 135792   | 0000 | 1.3    | 1620895563         | CroToArb     |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | TransferType |
      | 562783159   | 1000021662 | 100718887     | 1033624618     | 135792   | 0000 | 1.3    | 1620895563         | CroToArb     |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | TransferType |
      | 573091654   | 1000006906 | 100778297     | 1136657358     | 135792   | 0000 | 1.3    | 1007172545         | CroToArb     |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | TransferType |
      | 573091654   | 1000006906 | 100778297     | 1136657358     | 135792   | 0000 | 1.3    | 1007172545         | CroToArb     |

  @JiraIntegration
    @TEST_XRAY-1267
    @Priority:High
    @Smoke
    @Regression
  Scenario Outline: 5 - user makes a transfer to existing active beneficiary "CRO to ARB" transfer type from existing beneficiary list
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
 ##And user save account balance before transfer
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user transfer by using active "<transferType>" existing beneficiary
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp   | amount | transferType |
      | 573082514   | 1000022470 | 101908453     | 1857285249     | 135792   | 00000 | 5      | croToArb     |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp   | amount | transferType |
      | 573082514   | 1000022470 | 101908453     | 1857285249     | 135792   | 00000 | 5      | croToArb     |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | transferType |
      | 501953876   | 1000006912 | 100778335     | 1803246402     | 135792   | 0000 | 5      | croToArb     |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | transferType |
      | 501953876   | 1000006912 | 100778335     | 1803246402     | 135792   | 0000 | 5      | croToArb     |

  @JiraIntegration
    @Priority:High
    @TEST_XRAY-4011
    @Smoke
    @Regression
    @retest
  Scenario Outline: 6 - user transfer CRO to ARB by using Beneficiary Account number and amount greater than 2500
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user remove restriction for the user
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
 #And user save account balance before transfer
    Then user update transaction limit of "<CIC>" to "50000"
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user remove all restrictions for the user "<CIC>"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user send to new beneficiary
    And user Add active beneficiary by using AccountNumber "<AccountNumber>" and nickName "<nickName>"
    Then user select active beneficiary
    And user transfer money
    And user set the amount "<amount>"
    And user transfer by send Money now
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | AccountNumber         | nickName       |
      | 535189296   | 1000036531 | 101633918     | 2796619894     | 112233   | 0000 | 2550   | 204000010006085128485 | AutomationTest |
      # | 571325049   | 1000020734 | 101633918     | 1004212146     | 315894   | 0000 | 1   | 204000010006085128485 | AutomationTest |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp   | amount | AccountNumber         | nickName       |
      | 524670398   | 1000020572 | 102356071     | 1456124666     | 135792   | 00000 | 2550   | 204000010006085128485 | AutomationTest |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp   | amount | AccountNumber         |
      | 560486401   | 1000007300 | 100252082     | 1077083226     | 135792   | 00000 | 1.11   | 204000010006085128485 |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | AccountNumber         |
      | 560486401   | 1000007300 | 100252082     | 1077083226     | 135792   | 0000 | 1.11   | 204000010006085128485 |

  @JiraIntegration
    @Priority:High
    @TEST_XRAY-4012
    @Smoke
    @Regression
  Scenario Template: 7 - user transfer CRO TO ARB by using Beneficiary IBAN and amount greater than 2500
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
 #And user save account balance before transfer
    Then user update transaction limit of "<CIC>" to "50000"
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user remove all restrictions for the user "<CIC>"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user send to new beneficiary
    And user Add active beneficiary by using IBAN "<iban>" and nickName "<nickName>"
    And user transfer by send Money now
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | iban                     | nickName       |
      | 571325049   | 1000020734 | 101633918     | 1004212146     | 135792   | 0000 | 2550   | SA9080000204608015995347 | AutomationTest |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp   | amount | iban                     | nickName       |
      | 524670398   | 1000020572 | 102356071     | 1456124666     | 135792   | 00000 | 2550   | SA9080000204608015995347 | AutomationTest |

  @JiraIntegration
    @TEST_XRAY-1331
    @Priority:High
    @Smoke
    @Regression
  Scenario Outline: 8 - user transfer CRO to ARB by using Beneficiary mobile number amount greater than 2500
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user remove all restrictions for the user "<CIC>"
    Then user update transaction limit of "<CIC>" to "50000"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user send to new beneficiary
    And user Add active beneficiary by adding Arb mobile number "<phoneNumber>" and nickName "<nickName>"
    And user transfer by send Money now
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | phoneNumber | nickName       |
      | 506457123   | 1000021193 | 102356028     | 1911702403     | 135792   | 0000 | 2550   | 529432302   | AutomationTest |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | phoneNumber | nickName       |
      | 523501486   | 1000022850 | 102676408     | 2591865213     | 135792   | 0000 | 2550   | 529432302   | AutomationTest |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | phoneNumber | nickName       |
      | 560275391   | 1000007316 | 100965356     | 1732618904     | 135792   | 0000 | 2550   | 537797778   | AutomationTest |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | phoneNumber | nickName       |
      | 560275391   | 1000007316 | 100965356     | 1732618904     | 135792   | 0000 | 2550   | 537797778   | AutomationTest |

  @JiraIntegration
    @TEST_XRAY-592
    @Priority:High
    @Smoke
    @Regression
  Scenario Outline: 9 - user transfer CRO to ARB by using Beneficiary NationalId amount greater than 2500
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user delete beneficiary if exist by using DataBase"<CIC>"
    Then user update transaction limit of "<CIC>" to "50000"
    And user remove all restrictions for the user "<CIC>"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" of transfer
    And user send to new beneficiary
    And user transfer by using beneficiary nationalId "<ReceiverNationalId>"
    And user transfer by send Money now
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId |
# | 535416279 | 1000020640 | 101080978 | 2179056391 | 135792 | 0000 | 2550 | 1200445763 |
      | 540372865   | 1000021248 | 101773663     | 2248778439     | 135792   | 0000 | 2550   | 1620895563         |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId |
      | 540372865   | 1000021248 | 101773663     | 2248778439     | 135792   | 0000 | 2550   | 1620895563         |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId |
      | 507450850   | 1000001163 | 100002973     | 1254799758     | 135792   | 0000 | 2550   | 1620895563         |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId |
      | 507450850   | 1000001163 | 100002973     | 1254799758     | 135792   | 0000 | 2550   | 1620895563         |

  @JiraIntegration
    @TEST_XRAY-1175
    @Priority:Highest
    @Regression
    @Smoke
  Scenario Template: 10 - User couldn't use Quick transfer with more than the max limit of it
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user remove all restrictions for the user "<CIC>"
    And user select Cro to ARB transfer
    And user set the amount "<amount>" greater than the limit of transfer
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount |
      | 507914256   | 1000019737 | 101813312     | 1682003890     | 135792   | 0000 | 2500.1 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount |
      | 507914256   | 1000019737 | 101813312     | 1682003890     | 135792   | 0000 | 2500.1 |


 
#---------------------------out of scope since feature is unable to execute in sit since ivr is mocked-------------------
# @TEST_XRAY-1343@TESTSET_XRAY-556@SIT@JiraIntegration @Priority:High @UserStoryId:PC-16535 @TestCaseId:XRAY-1343
# Scenario Outline: - the user makes a transfer to existing inactive beneficiary "CRO to Arb" transfer type
# Given activate user status "<CIC>" by using API
# And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
# When The user skip App introduction
# And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
# And user SignOut from registered device
# And user Sign In Registered Device with his passcode
# And user delete beneficiary if exist by using DataBase"<CIC>"
# And user Add ARB beneficiary
# And user deactivate beneficiary by using IBAN "<iban>" and nickName "<nickName>"
# Then user activate beneficiary "<transferType>"
# And user transfer money
# And user set the amount "<amount>"
# And user transfer by send Money now
# When user enter the OTP as "0000"
# Then the amount transferred successfully
# And user UnRegister Device
# @SIT @Android
# Examples:
# | phoneNumber | CIC | nationalNumber | passCode | otp | iban | nickName | amount |transferType|
# | 556402873 | 1000019747 | 1807593510 | 162780 | 0000 | SA8480000204608015128469 | AutomationUser | 20 |croToArb |
# @SIT @iOS
# Examples:
# | phoneNumber | CIC | nationalNumber | passCode | otp | iban | nickName | amount |transferType|
# | 593264710 | 1000019752 | 1443505720 | 135792 | 0000 | SA8480000204608015128469 | AutomationUser | 10 |croToArb|
