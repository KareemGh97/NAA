@Regression @RequestPay
Feature: Request to Pay

  @JiraIntegration @Priority:Highest @TEST_XRAY-3073
    @Android @iOS
    @Smoke
    #@retest
  Scenario Outline: 1 - user request to pay from Nera bank using Account number and receiver accept the the request
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to Nera bank
    Then user create new request
    And user set the amount "<amount>" of request
    And user Request to Pay from Nera using accountNumber "<accountNumber>"
    Then the amount "<amount>" Requested successfully
    And user click back from RTP screen
    And user UnRegister Device
    And user SignIn oneTimeUse with phoneNumber "<ReceiverMobileNumber>" NationalId "<receiverNationalNumber>" OTP "0000" for RTP
    And user remove rtp restrictions for the user "<receiverCIC>"
    When user accept RTP popup
    Then user accept Nera request to pay from receiver screen
    When user enter the OTP as "0000"
    Then the RTP accepted successfully
    @SIT
    Examples:
      | amount | accountNumber | ReceiverMobileNumber | receiverNationalNumber | receiverCIC |
      | 5      | 102962494     | 501257469            | 1228692552             | 1000037165  |
    @UAT
    Examples:
      | amount | accountNumber | ReceiverMobileNumber | receiverNationalNumber |
      | 5      | 100603535     | 529351740            | 1947345045             |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3074
    @Android @iOS
    @Smoke
  Scenario Outline: 2 - user request to pay from Nera bank using mobile number and receiver accept the the request
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to Nera bank
    Then user create new request
    And user set the amount "<amount>" of request
    And user Request to Pay from Nera using Mobile "<ReceiverMobileNumber>"
    Then the amount "<amount>" Requested successfully
    And user click back from RTP screen
    And user UnRegister Device
    And user SignIn oneTimeUse with phoneNumber "<ReceiverMobileNumber>" NationalId "<receiverNationalNumber>" OTP "0000" for RTP
    And user remove rtp restrictions for the user "<receiverCIC>"
    When user accept RTP popup
    Then user accept Nera request to pay from receiver screen
    When user enter the OTP as "0000"
    Then the RTP accepted successfully
    @SIT
    Examples:
      | amount | ReceiverMobileNumber | receiverNationalNumber | receiverCIC |
      | 70     | 586310572            | 1642370951             | 1000025967  |
    @UAT
    Examples:
      | amount | ReceiverMobileNumber | receiverNationalNumber |
      | 70     | 502761854            | 1425189279             |

  @JiraIntegration @TEST_XRAY-3075 @Priority:Highest
    @Android @iOS
    @Smoke
  Scenario Outline: 3 - user request to pay from Nera bank using mobile number and receiver reject the request
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to Nera bank
    Then user create new request
    And user set the amount "<amount>" of request
    And user Request to Pay from Nera using Mobile "<ReceiverMobileNumber>"
    Then the amount "<amount>" Requested successfully
    And user click back from RTP screen
    And user UnRegister Device
    And user SignIn oneTimeUse with phoneNumber "<ReceiverMobileNumber>" NationalId "<receiverNationalNumber>" OTP "0000" for RTP
    And user remove rtp restrictions for the user "<receiverCIC>"
    When user select later for RTP popup
    Then user select request to pay transfer
    And user select request to Nera bank
    Then receiver reject RTP
    And verify request status is "Rejected"
    @SIT
    Examples:
      | amount | ReceiverMobileNumber | receiverNationalNumber | receiverCIC |
      | 30     | 538012532            | 1186052394             | 1000025965  |
    @UAT
    Examples:
      | amount | ReceiverMobileNumber | receiverNationalNumber |
      | 30     | 535169208            | 1847736707             |

  @JiraIntegration @TEST_XRAY-3076 @Priority:Highest
    @Android @iOS
    @Smoke
  Scenario Outline: 4 - user request to pay from Nera bank using ID number and receiver accept the the request
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to Nera bank
    Then user create new request
    And user set the amount "<amount>" of request
    And user Request to Pay from Nera using NationalID "<receiverNationalNumber>"
    Then the amount "<amount>" Requested successfully
    And user click back from RTP screen
    And user UnRegister Device
    And user SignIn oneTimeUse with phoneNumber "<ReceiverMobileNumber>" NationalId "<receiverNationalNumber>" OTP "0000" for RTP
    And user remove rtp restrictions for the user "<receiverCIC>"
    When user accept RTP popup
    Then user accept Nera request to pay from receiver screen
    When user enter the OTP as "0000"
    Then the RTP accepted successfully
    @SIT
    Examples:
      | amount | ReceiverMobileNumber | receiverNationalNumber | receiverCIC |
      | 19     | 544705709            | 1200445750             | 1000019940  |
    @UAT
    Examples:
      | amount | ReceiverMobileNumber | receiverNationalNumber |
      | 19     | 519048532            | 1147912529             |

  @JiraIntegration @TEST_XRAY-3077 @Priority:Highest
    @Android @iOS
    @Smoke
  Scenario Outline: 5 - user request to pay from Nera bank using Email and receiver accept the the request
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to Nera bank
    Then user create new request
    And user set the amount "<amount>" of request
    And user Request to Pay from Nera using Email "<email>"
    Then the amount "<amount>" Requested successfully
    And user click back from RTP screen
    And user UnRegister Device
    And user SignIn oneTimeUse with phoneNumber "<ReceiverMobileNumber>" NationalId "<receiverNationalNumber>" OTP "0000" for RTP
    And user remove rtp restrictions for the user "<receiverCIC>"
    When user accept RTP popup
    Then user accept Nera request to pay from receiver screen
    When user enter the OTP as "0000"
    Then the RTP accepted successfully
    @SIT
    Examples:
      | amount | email                    | ReceiverMobileNumber | receiverNationalNumber | receiverCIC |
      | 200    | RMZ1L_DontUse@account.sa | 553182609            | 2622731111             | 1000020737  |
    @UAT
    Examples:
      | amount | email                    | ReceiverMobileNumber | receiverNationalNumber |
      | 200    | QHFWK@automationTeam.com | 563820517            | 1336102650             |

  @TEST_XRAY-1593 @Priority:Highest
    @Android @iOS
  Scenario Outline: 6 - user request IPS payment using Beneficiary
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to Nera bank
    Then user create new request
    And user set the amount "<amount>" of request
    Then user add new RTP beneficiary
    And user add and active beneficiary by using "IBAN" as "<IBAN>" and nickName as "AutomationUser"
    Then tap on done for adding RTP beneficiary
    Then the amount "<amount>" Requested successfully
    Then user click back from beneficiary details screen
    And user click back from RTP screen
    And user UnRegister Device
    And user SignIn oneTimeUse with phoneNumber "<ReceiverMobileNumber>" NationalId "<receiverNationalNumber>" OTP "0000" for RTP
    And user remove rtp restrictions for the user "<receiverCIC>"
    When user select later for RTP popup
    Then user select request to pay transfer
    And user select request to Nera bank
    Then receiver reject RTP
    And verify request status is "Rejected"

    @SIT
    Examples:
      | amount | IBAN                     | ReceiverMobileNumber | receiverNationalNumber | receiverCIC |
      | 200    | SA3380300011001100366592 | 528704951            | 1237320534             | 1000038149  |
    @UAT
    Examples:
      | amount | IBAN                     | ReceiverMobileNumber | receiverNationalNumber |
      | 511    | SA6080300011001100494825 | 587340215            | 1291237608             |


#    -------------------------------- RTP to local ⬇ ----------------------------------
#    -------------------------- not verified as it not stable --------------------------

  @JiraIntegration @TEST_XRAY-1588 @Priority:Highest
    @Android @iOS @SIT @UAT
    @not_on_UAT_yet
  Scenario Outline: 7 - user request to pay from local bank using IBAN number
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    And user select request to local bank
    Then user create new request
    And user set the amount "<amount>" of request
    And user IPS transfer by using receiver fullName "<fullName>" and IBAN "<IBAN>" and BankName "<Bank>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    Examples:
      | amount | fullName       | IBAN                     | Bank          |
      | 5      | AutomationTest | SA8480000204608015128469 | Bank AlJazira |

  @JiraIntegration @TEST_XRAY-1589 @Priority:Highest
    @Android @iOS @SIT @UAT
    @not_on_UAT_yet
  Scenario Outline: 8 - user request IPS payment using mobile number
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    Then user create new request
    And user set the amount "<amount>" of request
    And user IPS transfer by using receiver mobile "<ReceiverMobileNumber>" and BankName "<Bank>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    Examples:
      | amount | ReceiverMobileNumber | Bank    |
      | 1.5    | 598741255            | albilad |

  @TEST_XRAY-1590 @Priority:Highest
    @Android @iOS @SIT @UAT
    @not_on_UAT_yet
  Scenario Outline: 9 - user request IPS payment using ID number
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    Then user create new request
    And user set the amount "<amount>" of request
    And user IPS transfer by using receiver ID "<nationalId>" and BankName "<Bank>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    Examples:
      | amount | nationalId | Bank                |
      | 1.5    | 2389025467 | Saudi National Bank |

  @TEST_XRAY-1591 @Priority:Highest
    @Android @iOS @SIT @UAT
    @not_on_UAT_yet
  Scenario Outline: 10 - user request IPS payment using Email
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "" with -7 days by using dataBase
    And user remove restriction for the user
    Then user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user select request to pay transfer
    Then user create new request
    And user set the amount "<amount>" of request
    And user IPS transfer by using receiver email "<email>" and BankName "<Bank>"
    When user enter the OTP as "0000"
    Then the amount transferred successfully
    Examples:
      | amount | email            | Bank                |
      | 1.5    | Dummye@gmail.com | Saudi National Bank |