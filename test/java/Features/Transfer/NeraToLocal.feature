@CroToLocal
@not_on_UAT_yet
Feature:Check the flow of making a quick Local transfer

  @JiraIntegration
    @Priority:Highest
    @Regression
  Scenario Template: 1 - SARI - Quick Local transfer using "IBAN" to "Local bank" in case of the amount greater than 20,000 -"IPS Transfer"
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user remove all restrictions for the user "<CIC>"
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user select Cro to Local transfer
    And user set the amount "<amount>" of local transfer
    And user send to new beneficiary
    And user Add active local beneficiary by adding quick IBAN "<IBAN>" and nickName "<nickName>"
    And user local transfer by using receiver fullName "<fullName>" and IBAN "<IBAN>"
    And user enter OTP
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     | nickName |
      | 526351479   | 1000019756 | 100774728     | 1730944053     | 135792   | 0000 | 150  | mohamed  | SA5655000000009538300127 | SARI     |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 556290748   | 1000019760 | 100774801     | 1992443786     | 135792   | 0000 | 23000  | mohamed  | SA5655000000009538300127 |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 513309069   | 1000007588 | 100432269     | 1036669495     | 135792   | 0000 | 100    | mohamed  | SA7993000047050099448000 |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 513309069   | 1000007588 | 100432269     | 1036669495     | 135792   | 0000 | 100    | mohamed  | SA7993000047050099448000 |

  @JiraIntegration
    @TEST_XRAY-593
    @Priority:Highest
    @Regression
  Scenario Template: 2 - quick Local transfer using "IBAN" to "Local bank" in case of the amount less than 20,000 -"IPS Transfer"
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    Then user update transaction limit of "<CIC>" to "50000"
    And user remove all restrictions for the user "<CIC>"
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user select Cro to Local transfer
    And user set the amount "<amount>" of local transfer
    And user local transfer by using receiver fullName "<fullName>" and IBAN "<IBAN>"
    And user enter OTP
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 526351479   | 1000019756 | 100774728     | 1730944053     | 135792   | 0000 | 100    | mohamed  | SA5655000000009538300127 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 556290748   | 1000019760 | 100774801     | 1992443786     | 135792   | 0000 | 100    | mohamed  | SA5655000000009538300127 |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 513309069   | 1000007588 | 100432269     | 1036669495     | 135792   | 0000 | 100    | mohamed  | SA7993000047050099448000 |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | fullName | IBAN                     |
      | 513309069   | 1000007588 | 100432269     | 1036669495     | 135792   | 0000 | 100    | mohamed  | SA7993000047050099448000 |

  @JiraIntegration
    @TEST_XRAY-594
    @Priority:Highest
    @Regression
  Scenario Template: 3 - user transfer CRO to LOCAL by using Mobile number
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user remove all restrictions for the user "<CIC>"
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user delete beneficiary if exist by using DataBase"<CIC>"
    And user select Cro to Local transfer
    And user set the amount "<amount>" of local transfer
    And user transfer locally by using receiver phoneNumber "<ReceiverPhoneNumber>" and bank "<Bank>"
    And user enter OTP
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber | Bank       |
      | 565207438   | 1000019764 | 100774887     | 1585174590     | 148723   | 0000 | 100    | 500074144           | Riyad Bank |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber | Bank       |
      | 579083416   | 1000019770 | 102984803     | 1902542909     | 862701   | 0000 | 100    | 500074144           | Riyad Bank |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber | Bank       |
      | 559970910   | 1000007592 | 100432331     | 2418001745     | 135792   | 0000 | 100    | 509250000           | Riyad Bank |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverPhoneNumber | Bank       |
      | 559970910   | 1000007592 | 100432331     | 2418001745     | 135792   | 0000 | 100    | 509250000           | Riyad Bank |

  @JiraIntegration
    @TEST_XRAY-595
    @Priority:Highest
    @Regression
  Scenario Template: 4 - user transfer CRO to LOCAL by using NationalId
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user remove all restrictions for the user "<CIC>"
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user select Cro to Local transfer
    And user set the amount "<amount>" of local transfer
    And user transfer by using local nationalId "<ReceiverNationalId>" and bank "<Bank>"
    And user enter OTP
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | Bank               |
      | 508192765   | 1000030064 | 102984846     | 2648368419     | 135792   | 0000 | 1      | 2446800193         | Arab National Bank |
     # | 530528649   | 1000019773 | 102984846     | 1604670164     | 063918   | 0000 | 1      | 2446800193         | Arab National Bank |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | Bank               |
      | 538049256   | 1000019767 | 102984749     | 1250183157     | 135792   | 0000 | 1.11   | 2446800193         | Arab National Bank |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | Bank               |
      | 559778295   | 1000007597 | 100897784     | 1751914290     | 135792   | 0000 | 1.11   | 2446800193         | Arab National Bank |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverNationalId | Bank               |
      | 559778295   | 1000007597 | 100897784     | 1751914290     | 135792   | 0000 | 1.11   | 2446800193         | Arab National Bank |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-596
    @Regression
  Scenario Template: 5 - user transfer CRO to LOCAL by using Email
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user remove all restrictions for the user "<CIC>"
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user select Cro to Local transfer
    And user set the amount "<amount>" of local transfer
    And user transfer by using receiver email "<ReceiverEmail>" and bank "<Bank>"
    And user enter OTP
    Then the amount transferred successfully
    And user UnRegister Device
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverEmail   | Bank                  |
      | 521750986   | 1000019753 | 100774666     | 1988022461     | 135792   | 0000 | 1.5    | rohit@gamil.com | Saudi Investment Bank |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverEmail   | Bank                  |
      | 530564872   | 1000019751 | 100774623     | 1077624086     | 135792   | 0000 | 15.99  | rohit@gamil.com | Saudi Investment Bank |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverEmail   | Bank                  |
      | 557008289   | 1000007587 | 100379341     | 2154226415     | 135792   | 0000 | 15.99  | rohit@gamil.com | Saudi Investment Bank |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount | ReceiverEmail   | Bank                  |
      | 557008289   | 1000007587 | 100379341     | 2154226415     | 135792   | 0000 | 15.99  | rohit@gamil.com | Saudi Investment Bank |

  @JiraIntegration
    @TEST_XRAY-1176
    @Priority:Highest
    @Regression
  Scenario Template: 6 - User couldn't use Quick transfer with more than the max limit of it
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user topUp his account "<senderAccount>" with balance "<amount>" by using API
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user select Cro to Local transfer
    And user set the local amount "<amount>" greater than the limit of transfer
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount |
      | 573891402   | 1000019735 | 101813298     | 1560011338     | 135792   | 0000 | 2500.1 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | senderAccount | nationalNumber | passCode | otp  | amount |
      | 598413756   | 1000019718 | 100558637     | 1306201177     | 135792   | 0000 | 2500.1 |