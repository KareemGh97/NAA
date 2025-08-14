@Gold
Feature: Gold wallet

  @JiraIntegration @Priority:Medium @TEST_XRAY-3169
    @Regression @Smoke
  Scenario Outline: 1 - Check the Gold wallet creation in case the user already has one
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    Then User selects gold product and Navigates to the Buy or Sell gold screen
    And User navigates to buy gold screen and orders the gold grams
    And User view gold transactions
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
#      | 529186340   | 1000020436 | 2774611681     | 135792   | 0000 |
      | 568713295   | 1000020735 | 1936821873     | 135792   | 0000 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 568713295   | 1000020735 | 1936821873     | 135792   | 0000 |

#    no UAT buy of sell for now
#    @iOS@UAT
#    Examples:
#      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
#      | 548959491   | 1077087334     | 1077087334 | 135792   | 0000 |
#    @Android@UAT
#    Examples:
#      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
#      | 564245580   | 1077085718     | 1000009818 | 135792   | 0000 |

  @JiraIntegration @Priority:Medium @TEST_XRAY-2210
    @Android @iOS @SIT @UAT
    @Regression @Smoke
    @needsOnboarding
  Scenario Outline: 2 - Check the Gold wallet creation in case the user didn't have a gold wallet
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user confirm BirthPlace return from nafath
    And The user enters occupation "<occupational>" information details
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user Activate ALO card Later
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And add money to the user account
    Then New User selects gold wallet product
    And User accepts buy or sell gold terms and conditions then press on confirm button
    And User navigates to buy gold screen and orders the gold grams
    And User view gold transactions
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 12          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |