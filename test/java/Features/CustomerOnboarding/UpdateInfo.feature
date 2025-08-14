@Update_Info
Feature: Update customer information

  @TEST_XRAY-1644
  Scenario: 1 -Update customer account management-Check if the user can update his "Financial Information" only and neglect the other options in case of (not high risk to not high risk )
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then User Press on Financial Information Edit Button
    And User updates the Financial Information
    And User updates the occupational information
    And User updates the PEP Flag and Save the updates
    And Verify That Financial Information are updated successfully

  @TEST_XRAY-1645
  Scenario: 2 - Update customer account management-Check if the user can update Additional income in case of (not high risk to not high risk )
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then User Press on Financial Information Edit Button
    And User updates the Financial Information with additional income
    And User updates the occupational information
    And User updates the PEP Flag and Save the updates
    And Verify That Financial Information are updated successfully
    Then User disables the additional income then saves the changes

  @TEST_XRAY-1647
  Scenario: 3 - Update customer account management-Check if the user can update national address information
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then User Press on National Address Information Edit Button
    And Verify that address information is disabled
    And User updates the national address information
    