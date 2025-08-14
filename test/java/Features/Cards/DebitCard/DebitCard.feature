@DebitCard
Feature: Croatia customer is activate debit card of a new onboarded customer/Change pass code and request physical card

  @JiraIntegration @Priority:High @TEST_XRAY-1308
    @Android @iOS @SIT @UAT
    @Smoke @Regression
    @unleashFeatureDisabled @needsOnboarding
  Scenario Outline: 1 - Croatia customer is activate debit card of a new onboarded customer/Change pass code and request physical card
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user set Birth Country
    And The user confirm BirthPlace return from nafath
    And The user enters occupation "<occupational>" information details
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user Activate ALO card Later
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    Then add money to the user account
    And user click on click on navigate to Account button
# And user wait for card to be displayed
    And user user click on request cards tab
    Then user activate debit card
# And user enter "<otp>"
    And verify card details after activation
    And user click on card setting
    And user update with new pin "<newPinCode>"
    And verify pin code updated successfully
    Then user order physical card
    Then user verify that order is send successfully
    Examples:
      | IDStartWith | Email                      | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | newPinCode |
      | 12          | IqamaID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 8520       |

  @JiraIntegration @Priority:High @TEST_XRAY-1313
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 2 - Verify setting page
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And user click on click on navigate to Account button
    And user user click on cards tab
    And user click on card setting
    Then user view setting screen options

  @JiraIntegration @Priority:High @TESTSET_XRAY-1846
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 3 - Verify activate card and Freez/unfreez
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    And user click on click on navigate to Account button
    And user user click on cards tab
    Then user activate debit card
    And user click on click on navigate to Account button
    And user user click on cards tab
    And user freez Debit card
 #unfreez Card
    Then user un-freez Debit card

  @JiraIntegration
    @Priority:Low
    @TEST_XRAY-1311
    @Regression
  Scenario Outline: 4 - Reset Pin card Number with weak pin
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user click on click on navigate to Account button
    And user user click on cards tab
    And user click on card setting
    And user update with week pin "<newPinCode>"
    And verify that error PincodeTooEasyAlert message is appearing
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase

    @iOS @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | newPinCode |
      | 536541870   | 1000019937 | 2191151949     | 135792   | 0000 | 1234       |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | newPinCode |
      | 513456278   | 1000006939 | 1521546224     | 135792   | 0000 | 1234       |
    @Android @SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | newPinCode |
      | 571306829   | 1000022520 | 2660473675     | 135792   | 0000 | 1234       |
    @Android@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | newPinCode |
      | 513456278   | 1000006939 | 1521546224     | 135792   | 0000 | 1234       |