@nera
Feature: nera card

  @JiraIntegration @Priority:Highest @TEST_XRAY-1305
    @Android @iOS @SIT @UAT
    @Smoke @Regression
    @needsOnboarding
  Scenario Template: 1 - User select and activate the nera card
  """
 Description:
 This scenario covers the complete flow for a user to select and activate a nera card (TC ID: XDI-9518 ),
 including verification, OTP entry (TC ID: XDI-11246 ), activates card (TC ID: XDI-33745 ), and final verification.
 """
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
    And add money to the user account
    Given user goes to cards from footer tap
    When user on card screen
    And user activate nera card
    And the user create card pin "<CardPIN>"
   # Then user is activate card successfully
    And user view card details
    And user is on the card page
    Examples:
      | IDStartWith | Email                      | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | CardPIN |
      | 12          | IqamaID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 2200    |

  @JiraIntegration @Priority:Low @TEST_XRAY-1315
  @Smoke @Regression
  @unleashFeatureDisabled
  @Android @iOS @SIT @UAT
  Scenario: 2 - Check that the card settings options are navigate to the related pages
  """
 Description:
 This scenario covers the settings options of AIO cards and its 6 options (TC ID: XDI-11246 )
 the customer will be navigated to the corresponding page where they can perform the actions related to that section.
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    When user goes to cards from footer tap
    Then goes to the settings page
    And verify that All 6 options are displayed
    Then change card PIN option navigated to the corresponding page
    And order physical card option navigated to the corresponding page
    And card close and replacement option navigated to the corresponding page
# And add to Apple wallet option navigated to the corresponding page
    And permanent card closure option navigated to the corresponding page
    And statements option navigated to the corresponding page


  @JiraIntegration @Priority:Medium @TEST_XRAY-1316
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 3 - check the successful PIN reset for nera card
  """
 Description:
 This scenario covers the complete flow for a user to change the PIN,(TC ID: XDI-22889 )
 and verify that the new PIN has been set successfully.
"""
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    When user goes to cards from footer tap
    Then goes to the settings page
    And click on 'change PIN' option
    Then enter and confirm a new PIN
    And verify that PIN number has changed to the new PIN

  @JiraIntegration @Priority:Medium @TEST_XRAY-1317
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 4 - Create nera Card Replacement
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then add money to the user account
    When user goes to cards from footer tap
    Then goes to the settings page
    And User press on Close and Replacement option then navigated to Replacement flow
    And user sets up passcode "1357" twice
    And user view card details
    And user is on the card page


  @JiraIntegration @Priority:Low @TEST_XRAY-1326
    @Smoke @Regression
  Scenario Outline: 5 - View Transaction History
#    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    When user goes to cards from footer tap
    And User press on transaction view all button and check all the records
    @iOS @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 559368104   | 1259577698     | 1000038152 | 135792   | 0000 |
    @iOS@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 572453890   | 1706219274     | 1000006897 | 135792   | 0000 |
    @Android @SIT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 559368104   | 1259577698     | 1000038152 | 135792   | 0000 |
    @Android@UAT
    Examples:
      | phoneNumber | nationalNumber | CIC        | passCode | otp  |
      | 530765924   | 1279013369     | 1000010207 | 135792   | 0000 |

  @JiraIntegration @Priority:Low @TEST_XRAY-1376
  @Regression
  @Android @iOS @SIT @UAT
  Scenario: 6 - Freeze and Defrost nera card
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    When user goes to cards from footer tap
    Then User Freeze the card
    Then User DeFrost the card

  @JiraIntegration @Priority:Low @TEST_XRAY-1378
  @Regression
  @Android @iOS @SIT @UAT
  Scenario: 7 - Add and Refund money to nera card
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    When user goes to cards from footer tap
    Then User adds "10" SAR to the card successfully
 #Refund money from nera card
    Then User refunds money from the card successfully


# @TEST_XRAY-1380
# Scenario Outline: 8 - Add money to nera card with value exceeds the available balance
# Given The user skip App introduction
# And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# When user goes to cards from footer tap
# Then User adds "1000000" SAR which exceeds the available balance to the card
#
# @iOS
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 552233220 | 1552233220 | 206815 | 0000 |

# @TEST_XRAY-1382
# Scenario Outline: 9 - Refund money from nera card
# Given The user skip App introduction
# And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# When user goes to cards from footer tap
# Then User refunds money from the card successfully
#
# @iOS
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 552233220 | 1552233220 | 206815 | 0000 |
# @Android
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 552233220 | 1552233220 | 135792 | 0000 |

# @TEST_XRAY-1384
# Scenario Outline: 10 - Refund money from nera card with value exceeds the card balance
# Given The user skip App introduction
# And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
# When user goes to cards from footer tap
# Then User refunds "1000000" SAR which exceeds the available balance in the card
#
# @iOS
# Examples:
# | phoneNumber | nationalNumber | passCode | otp |
# | 552233220 | 1552233220 | 206815 | 0000 |


