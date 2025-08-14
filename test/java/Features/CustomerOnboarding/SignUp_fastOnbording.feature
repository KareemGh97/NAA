#@fastOnboarding@SitRegression
Feature: FOB
Feature: Croatia customer is Fast onboarding

  @E2E@happyFlow@FOB
    @JiraIntegration @Priority:Highest @UserStoryId:XRAY-1689@TestCaseId:XRAY-1691
  Scenario Outline: 1 - E2E fast onboarding Scenario without activate AIO card
    Given prospect croatia customer is fast onboarding at croatia using mobileNumber "<mobileNumber>" and NationalId "<NationalId>"
    And the customer has login to Alrajhi Online using username "<username>" and password "<password>"
    And user enter "<otp>" on fast onboarding
# And the customer has their email and occupational details
# When the customer clicks on continue
# Then croatia customer is redirected to the occupational information section
# When customer selects or add their occupational information in fast onboarding
    Then customer is redirected to the FOB financial information section
    Then the customer is at the FATCA details and checked Are You Pep
    Then the customer clicks on FATCA continue
    And the app directs the customer to the T&C page and accept the T&C
    Then the customer redirect to activate "card" and select later
    And the customer create a passcode
    Then the customer redirect to activate "touch" and select later
    Then the user is onboarded successfully
    @iOS @SIT
    Examples:
      | mobileNumber | NationalId | username    | password | otp  |
      | 559114256    | 1200479564 | u125150768X | test1234 | 1234 |
 # |593086786 |1002296612|u125200647X |test1234|1234|
    @Android @SIT
    Examples:
      | mobileNumber | NationalId | username    | password | otp  |
      | 523190151    | 1002296646 | u125150768X | test1234 | 1234 |
    @Android
    Examples:
      | mobileNumber | NationalId | username    | password | otp  |
      | 523190151    | 1002296646 | u125150768X | test1234 | 1234 |
    @IOS
    Examples:
      | mobileNumber | NationalId | username    | password | otp  |
      | 523190151    | 1002296646 | u125150768X | test1234 | 1234 |
