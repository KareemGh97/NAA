@TravelInsurance
@not_on_UAT_yet
Feature: TravelInsurance | Domestic travel, International travel, Study abroad.

  @TEST_XRAY-2987
    @JiraIntegration
    @Priority:High
    @Smoke
    @Regression
  Scenario Template: 1 - Travel insurance - Domestic travel insurance application || Verify the Full Journey for Domestic travel insurance .
  """
 Description: This scenario covers the complete flow for the Full Journey for Domestic travel insurance ,
 (TC ID: XDI-44158, XDI-42320, XDI-42427, XDI-42439 )
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user navigates to Travel Insurance feature
    And user clicks on + button to add policy
    And user selects Domestic then Apply
    And user selects to be the main traveler and fill all required fields
    And user clicks on Add Travellers
    And user selects Family type
    And user enters all family details
    And user enters trip details
    And user proceeds to the summary page
    And verify all details are existed and clicks on Confirm button
    And user enters a valid otp "<otp>"
    Then verify that success message Policy issued successfully appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 574235190   | 1000036140 | 1728493410     | 135792   | 0000 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 574235190   | 1000036140 | 1728493410     | 135792   | 0000 |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513818726   | 1000006990 | 1027601045     | 101010   | 0000 |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 552379608   | 1000006933 | 1333444071     | 135792   | 0000 |

  @TEST_XRAY-2988
    @JiraIntegration
    @Priority:High
#    @Smoke
    @Regression
  Scenario Template: 2 - Travel insurance - Outbound travel insurance application || Verify the Full Journey for Outbound travel insurance .
  """
 Description: This scenario covers the complete flow for the Full Journey for Outbound travel insurance ,
 (TC ID: XDI-44168, XDI-42320, XDI-42322, XDI-42334, XDI-42427 )
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user navigates to Travel Insurance feature
    And user clicks on + button to add policy
    And user selects Outbound then Apply
    And user selects to be the main traveler and fill all required fields
    And user clicks on Add Travellers
    And user selects Family type
    And user enters all family details
    And user enters trip details for outbound or Student journey
    And user proceeds to the summary page for outbound journey
    And verify all details are existed and clicks on Confirm button
    And user enters a valid otp "<otp>"
    Then verify that success message Policy issued successfully appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 538671459   | 1000036141 | 2768562387     | 135792   | 0000 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 538671459   | 1000036141 | 2768562387     | 135792   | 0000 |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513818726   | 1000006990 | 1027601045     | 135792   | 0000 |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 552379608   | 1000006933 | 1333444071     | 135792   | 0000 |


    @TEST_XRAY-2989
    @JiraIntegration
    @Priority:High
#    @Smoke
    @Regression
  Scenario Template: 3 - Travel insurance - Student travel insurance application || Verify the Full Journey for Student travel insurance .
  """
 Description: This scenario covers the complete flow for the Full Journey for Student travel insurance ,
 (TCs ID: XDI-44169 , XDI-42191, XDI-42203, XDI-42282, XDI-42320, XDI-42427, XDI-42626, XDI-42627 )
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user navigates to Travel Insurance feature
    And user clicks on + button to add policy
    And user selects Student then Apply
    And user selects to be the main traveler and fill all required fields then clicks on next
    And user enters trip details for outbound or Student journey
    And user proceeds to the summary page for student journey
    And verify all details are existed and clicks on Confirm button for student journey
    And user enters a valid otp "<otp>"
    Then verify that success message Policy issued successfully appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 509153287   | 1000036197 | 1235783550     | 135792   | 0000 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 509153287   | 1000036197 | 1235783550     | 135792   | 0000 |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 513818726   | 1000006990 | 1027601045     | 135792   | 0000 |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 552379608   | 1000006933 | 1333444071     | 135792   | 0000 |