@NeraToNera
#  todo scenarios with @bug_PC-63476 needs to be verified after this bug is fixed
Feature: Transfer - as a user i want to Send Money To Nera Customers

  @JiraIntegration @Priority:Highest @TEST_XRAY-583
    @Android @iOS
    @Regression @Smoke
    @bug_PC-63476
  Scenario Template: 1 - user transfer Nera to Nera by using Account number and amount less than 2500
  """
 Description: user transfer Nera to Nera by using Account number amount less than 2500
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user select Nera to Nera transfer
    And user set the amount "<amount>" of transfer
    And user send to new beneficiary
    And user transfer by using receiver AccountNumber "<accountNumber>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | amount | accountNumber |
      | 1      | 100131382     |
    @UAT
    Examples:
      | amount | accountNumber |
      | 1      | 100517997     |

  @JiraIntegration @TEST_XRAY-584 @Priority:Highest
    @Android @iOS
    @Regression @Smoke
  Scenario Template: 2 - user transfer Nera to Nera by using Mobile number and amount less than 2500
  """
 Description: user transfer Nera to Nera by using Mobile number amount less than 2500
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user select Nera to Nera transfer
    Then user set the amount "<amount>" of transfer
    And user transfer by using receiver phoneNumber "<ReceiverPhoneNumber>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | amount | ReceiverPhoneNumber |
      | 1.5    | 579606164           |
    @UAT
    Examples:
      | amount | ReceiverPhoneNumber |
      | 1.5    | 569172385           |

  @JiraIntegration @Priority:High @TEST_XRAY-585
    @Android @iOS
    @Regression @Smoke
  Scenario Template: 3 - user transfer Nera to Nera by using NationalId and amount less than 2500
  """
 Description : user transfer Nera to Nera by using NationalId and amount less than 2500
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user select Nera to Nera transfer
    And user set the amount "<amount>" of transfer
    And user transfer "<transferType>" by using receiver nationalId "<ReceiverNationalId>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully

    @SIT
    Examples:
      | amount | ReceiverNationalId | transferType |
      | 1.9    | 1200445730         | NeraToNera   |
    @UAT
    Examples:
      | amount | ReceiverNationalId | transferType |
      | 1.9    | 1469366288         | NeraToNera   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-586
    @Android @iOS
    @Regression @Smoke
  Scenario Template: 4 - user transfer Nera to Nera by using Email and amount less than 2500
  """
 Description : user transfer Nera to Nera by using Email and amount less than 2500
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user select Nera to Nera transfer
    When user set the amount "<amount>" of transfer
    And user transfer "<transferType>" by using receiver email "<ReceiverEmail>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully

    @SIT
    Examples:
      | amount | ReceiverEmail   | transferType |
      | 15.99  | aws@mrgmail.com | NeraToNera   |
    @UAT
    Examples:
      | amount | ReceiverEmail            | transferType |
      | 15.99  | DRJY1@automationTeam.com | NeraToNera   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-587
    @Android @iOS
    @Regression @Smoke
  Scenario Outline: 5 - user transfer Nera to Nera by using IBAN Beneficiaries and amount greater than 2500
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user update transaction limit of "" to "50000"
#   end of prerequisite ⬆
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "IBAN" as "<iban>" and nickName as "AutomationUser"
    Then user goes back to transfer screen
    And user select Nera to Nera transfer
    And user set the amount "2550" of transfer
    And user transfer by using active "NeraToNera" existing beneficiary
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | iban                     |
      | SA1180300011001101575608 |
    @UAT
    Examples:
      | iban                     |
      | SA7680300011001100778262 |

  @JiraIntegration @TEST_XRAY-1329 @Priority:Highest
    @Android @iOS
    @Regression @Smoke
  Scenario Outline: 6 - user transfer Nera to Nera by using national ID Beneficiaries and amount greater than 2500
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user update transaction limit of "" to "50000"
#  -- end of prerequisite ⬆
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "NationalID" as "<NationalId>" and nickName as "AutomationUser"
    Then user goes back to transfer screen
    And user select Nera to Nera transfer
    And user set the amount "2550" of transfer
    And user transfer by using active "NeraToNera" existing beneficiary
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | NationalId |
      | 1526861362 |
    @UAT
    Examples:
      | NationalId |
      | 1222158931 |

  @JiraIntegration @TEST_XRAY-1330 @Priority:Highest
    @Android @iOS
    @Regression @Smoke
  Scenario Outline: 7 - user transfer Nera to Nera by using mobile Number Beneficiaries and amount greater than 2500
  """
 Description: user transfer Nera to Nera by using mobile Number Beneficiaries and amount greater than 2500
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user update transaction limit of "" to "50000"
    #  -- end of prerequisite ⬆
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "PhoneNumber" as "<PhoneNumber>" and nickName as "AutomationUser"
    Then user goes back to transfer screen
    And user select Nera to Nera transfer
    And user set the amount "2550" of transfer
    And user transfer by using active "NeraToNera" existing beneficiary
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | PhoneNumber |
      | 521746985   |
    @UAT
    Examples:
      | PhoneNumber |
      | 570326149   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-1268
    @Android @iOS
    @Regression @Smoke
  Scenario Outline: 8 - user makes a transfer to existing active beneficiary "Nera to Nera" transfer type from existing beneficiary list
    Given The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"0000"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user select Nera to Nera transfer
    And user set the amount "5" of transfer
    And user transfer by using active "NeraToNera" existing beneficiary
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode |
      | 554629370   | 1256980952     | 1000038151 | 135792   |
    @UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode |
      | 510472856   | 1254508995     | 1000010579 | 135792   |


  @JiraIntegration @Priority:Highest @TEST_XRAY-1174
  @Android @iOS @UAT @SIT
  @Regression @Smoke
  Scenario: 9 - User couldn't send amount greater than his daily limit
  """
 Description: User couldn't send amount greater than his daily limit
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user select Nera to Nera transfer
    When user set the amount "50001" of transfer greater Than the limit
    Then user is not able to transfer the amount

 #----------------------------------out of scope since feature is unable to execute ------------------------------
 #---------------------------IVR is mocked therefore the beneficiary will be activated directly-------------------

  @JiraIntegration @Priority:Highest @TEST_XRAY-1281
    @Android @iOS
  Scenario Outline: 10 - the user makes a transfer to existing inactive beneficiary "Nera to Nera" transfer type
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user Add Nera beneficiary
      #todo ⬆ adding the transfer to the screen
    And user add and active beneficiary by using "iban" as "<iban>" and nickName as "Automation User"
    Then user activate beneficiary "NeraToNera"
    And user transfer money
    And user set the amount "25"
    And user transfer by send Money now
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    @SIT
    Examples:
      | iban                     |
      | SA8980300011001100979497 |
    @UAT
    Examples:
      | iban                     |
      | SA7680300011001100778262 |