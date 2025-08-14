@neraPlus
Feature: nera plus card

  @prerequisite @JiraIntegration @Priority:Highest @TEST_XRAY-1304
    @Android @iOS @SIT @UAT
    @Smoke @Regression
    @needsOnboarding
    @Bug-PC-52795
  Scenario Outline: 1 - High Risk /User select and activate the nera Plus card
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
    Given remove bloke code for "<CIC>" by using API
    Given activate user status "<CIC>" by using API
    Then add money to the user account
    Given user goes to cards from footer tap
    And user navigates to AioScreen and verifies Explore button
    And user completes initial setup for credit plus
    And user enters OTP "0000" and activates card
    And user sets up passcode "2200" twice
    And user is on the card page
    Examples:
      | CIC   | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | EMPTY | 12          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration
    @Priority:High
    @TEST_XRAY-1325
    @Bug-PC-52795
    @Regression
  Scenario Outline: 2 - check the successful selection and activation for plus benefits
  """
 Description:
 This scenario covers the complete flow for a user navigating to the choose your benefits
 Page from the feed tab of the dashboard (TC ID: XDI-29817),then proceeding to the benefits
 Page (TC ID: XDI-29836). afterward, the user navigates to the activation summary page
 (TC ID: XDI-29986) and finally confirms and activates the subscription on the activation summary page (TC ID: XDI-29989).
"""
# Given prospect croatia customer is onboarding at croatia
# And the customer has passed both Tahqoq and Nafath authentications
# And the customer has approved the received data from Nafath
# And the customer has their email and occupational details
# When the customer clicks on continue
# Then croatia customer is redirected to the occupational information section
# When customer selects or add their occupational information
# Then customer is redirected to the financial information section
# And customer selects or add their financial information
# And the customer is at the FATCA details and checked out all the required details
# Then the customer clicks on FATCA continue
# And the app directs the customer to the T&C page and accept the T&C
# Then the customer redirect to activate "card" and select later
# And the customer create a passcode
# Then the customer redirect to activate "touch" and select later
# Then the customer is onboarded successfully
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    Then add money to the user account
    Given user goes to cards from footer tap
    And user navigates to AioScreen and verifies Explore button
    And user completes initial setup for credit plus
    And user enters OTP "0000" and activates card
    And user sets up passcode "2200" twice
    And user is on the card page
    When customer clicks choose your subscription tab in the benefits section
    Then verify that 3 cursors displaying the introduction of the subscription with the “unlock Free benefits” button
    And user will be redirected to the 'Your Benefits' page
    And user activate a specific subscription
    And the benefit will disappear from the 'All Benefits' screen
    And the benefit will move to the 'Active Benefits' screen
    @iOS@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
# | 598765432 | 1000019004 | 1598765432 | 135792 | 0000 |
# | 538061336 | 1000019111 | 1012345678 | 135792 | 0000 |
# | 532624777 | 1000019115 | 1258888444 | 135792 | 0000 |
      | 539516082   | 1000019732 | 1940548728     | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 564864165   | 2135135814     | 1000006366 | 101010   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 564864165   | 2135135814     | 1000006366 | 101010   | 0000 |

  @JiraIntegration
    @Priority:Low
    @TEST_XRAY-1339
    @Regression
  Scenario Outline: 3 - Check that the card settings options are navigate to the related pages
  """
 Description:
 This scenario covers the settings options of AIO cards and its 6 options (TC ID: XDI-15901 ),
 the customer will be navigated to the corresponding page where they can perform the actions related to that section.
"""
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    Then add money to the user account
    When user goes to cards from footer tap
    Then goes to the settings page
    And verify that All 5 options are displayed for nera plus card
    Then change card PIN option navigated to the corresponding page
    And card close and replacement option navigated to the corresponding page
# And add to Apple wallet option navigated to the corresponding page
    And permanent card closure option navigated to the corresponding page
    And statements option navigated to the corresponding page
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 529461307   | 2252659913     | 1000021663 | 135792   | 0000 |
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 576781537   | 1978454551     | 1000021666 | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 513548461   | 1834340040     | 1000006846 | 101010   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 513548461   | 1834340040     | 1000006846 | 101010   | 0000 |

  @JiraIntegration
    @Priority:Medium
    @TEST_XRAY-1340
    @Regression
  Scenario Outline: 4 - check the successful PIN reset for nera plus card
  """
 Description:
 This scenario covers the complete flow for a user to change the PIN,(TC ID: XDI-22890 )
 and verify that the new PIN has been set successfully.
"""
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    Then add money to the user account
    When user goes to cards from footer tap
    Then goes to the settings page
    And click on 'change PIN' option
    Then enter and confirm a new PIN
    And verify that PIN number has changed to the new PIN
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 565801723   | 1246466286     | 1000021053 | 135792   | 0000 |
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 530671842   | 2121672535     | 1000021929 | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513648761   | 1000007004 | 1846646787     | 135792   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513648761   | 1000007004 | 1846646787     | 135792   | 0000 |

  @JiraIntegration
    @Priority:Low
    @TEST_XRAY-1341
    @Regression
  Scenario Outline: 5 - Create Card Replacement
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    Then add money to the user account
    When user goes to cards from footer tap
    Then goes to the settings page
    And User press on Close and Replacement option then navigated to Replacement flow
    And user sets up passcode "1357" twice
    And user view card details
    And user is on the card page
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 540372865   | 2248778439     | 1000021248 | 135792   | 0000 |
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 540859489   | 1540859488     | 1000020008 | 135792   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513818726   | 1000006990 | 1027601045     | 101010   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513818726   | 1000006990 | 1027601045     | 101010   | 0000 |

  @JiraIntegration
    @Priority:Low
    @TEST_XRAY-1342
    @Regression
  Scenario Outline: 6 - View Transaction History
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    When user goes to cards from footer tap
    And User press on transaction view all button and check all the records
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
# | 565872149 | 1606587432 | 1000021702 | 135792 | 0000 |
      | 525473809   | 2046695140     | 1000022474 | 135792   | 0000 |
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 525473809   | 2046695140     | 1000022474 | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 564506486   | 1230154385     | 1000007053 | 101010   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 564506486   | 1230154385     | 1000007053 | 101010   | 0000 |

  @JiraIntegration
    @Priority:Low
    @TEST_XRAY-1377
    @Regression
  Scenario Outline: 7 - Freeze and Defrost nera plus card
    Given The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    When user goes to cards from footer tap
    Then User Freeze the card
    Then User DeFrost the card
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 540859489   | 1540859488     | 135792   | 0000 |
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 540859489   | 1540859488     | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 528083673   | 1288863006     | 135792   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 528083673   | 1288863006     | 135792   | 0000 |

  @JiraIntegration
    @Priority:Low
    @TEST_XRAY-1379
    @Regression
  Scenario Outline: 8 - Add and Refund money to nera plus card
    Given The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    When user goes to cards from footer tap
    Then User adds "10" SAR to the card successfully
    Then User refunds money from the card successfully
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 565872149   | 1606587432     | 135792   | 0000 |
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 565872149   | 1606587432     | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 513548461   | 1834340040     | 101010   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | passCode | otp  |
      | 513548461   | 1834340040     | 101010   | 0000 |

# @TEST_XRAY-1381
# Scenario Outline: 9 - Add money to nera plus card with value exceeds the available balance
# Given The user skip App introduction
# And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# When user goes to cards from footer tap
# Then User adds "1000000" SAR which exceeds the available balance to the card
#
# @iOS
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 540859489 | 1540859488 | 135792 | 0000 |

# @TEST_XRAY-1383
# Scenario Outline: 10 - Refund money from nera plus card
# Given The user skip App introduction
# And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# When user goes to cards from footer tap
# Then User refunds money from the card successfully
#
# @Android
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 540859489 | 1540859488 | 135792 | 0000 |
#
# @iOS
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 540859489 | 1540859488 | 135792 | 0000 |

# @TEST_XRAY-1385
# Scenario Outline: 11 - Refund money from nera plus card with value exceeds the card balance
# Given The user skip App introduction
# And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# When user goes to cards from footer tap
# Then User refunds "1000000" SAR which exceeds the available balance in the card
#
# @iOS
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 540859489 | 1540859488 | 135792 | 0000 |