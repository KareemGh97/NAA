@SADAD_Payments @Bug_PC-61059
@not_on_UAT_yet
Feature: SADAD Payments - Test Set

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1274
    @Regression
    @Smoke
    @Bug_PC-50473
  Scenario Outline: 1 - Customer add a new bill and pays it successfully
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
#    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "TestFullPayment" and continue
    Then user navigates to bill details screen
    And user clicks on add the bill button
    And user enters a valid otp "<otp>"
    Then user navigates to -bill added successfully- screen
    And user clicks on pay now button
    Then user navigates to pay bill screen
    And user clicks on continue button
    Then user navigates to confirm bill details screen
    And user clicks on confirm button
    And user enters a valid otp "<otp>"
    And Verify that success message bill paid successfully appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 515437628   | 1000036136 | 1225468246     | 135792   | 0000 | 71833736280   | Telecom and internet | STC             |
# | 563280497 | 1000023479 | 1108981760 | 135792 | 0000 | 71833736282 | Mobile Phone Service | STC |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 71833736283 | Mobile Phone Service | STC |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 71833736284 | Mobile Phone Service | STC |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 71833736285 | Mobile Phone Service | STC |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 71833736286 | Mobile Phone Service | STC |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 71833736287 | Mobile Phone Service | STC |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 845322244440002 | Insurance | Al Rajhi Takaful |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 34300002803719980 | Loans | Riyad Bank Payments |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 7548007231 | Bill Payment | Marafiq |
# | 595106482 | 1000024531 | 1852071649 | 135792 | 0000 | 845322244440002 | Insurance | Al Rajhi Takaful |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 515437628   | 1000036136 | 1225468246     | 135792   | 0000 | 71833736282   | Telecom and internet | STC             |
    @iOS @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 506234851   | 1000006921 | 1851004679     | 135792   | 0000 | 71833736280   | Telecom and internet | STC             |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 506234851   | 1000006921 | 1851004679     | 135792   | 0000 | 71833736281   | Telecom and internet | STC             |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1276
    @Bug_PC-50473
    @Smoke
    @Regression
# This scenario will be failed as per bug PC-50473
  Scenario Outline: 2 - Customer pays the bill partially successfully
# Add new unpaid bill that accepts partial payment
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
#    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "TestPartialPayment" and continue
    Then user navigates to bill details screen
    And user clicks on add the bill button
    And user enters a valid otp "<otp>"
    Then user navigates to -bill added successfully- screen
# Pay the bill partially
    And user clicks on pay now button
    Then user navigates to pay bill screen
    And Try to pay the bill partially "<PaidAmount>"
    Then user navigates to confirm bill details screen
    And user clicks on confirm button
    And user enters a valid otp "<otp>"
    And Verify that success message bill paid successfully appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber  | billCategory | billSubcategory        | PaidAmount |
      | 532750849   | 1000036137 | 2262241249     | 135792   | 0000 | 84532224443132 | Utilities    | National Water Company | 11         |
# | 545368791 | 1000018083 | 2990875613 | 135792 | 0000 | 84532224443132 | Water Services | Ministry Of Environment, Water And Agriculture | 20 |
# | 545368791 | 1000018083 | 2990875613 | 135792 | 0000 | 845322244440112 | Water Services | Ministry Of Environment, Water And Agriculture | 20 |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 2019988099964 | Credit Cards | Bank Al-Jazira | 200 |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 98822510 | Electricity | Saudi Electric Company |
# | 579606177 | 1000017497 | 1200445755 | 135792 | 0000 | 71833736242 | Mobile Phone Service | STC |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory | billSubcategory        | PaidAmount |
      | 532750849   | 1000036137 | 2262241249     | 135792   | 0000 | 283592972789  | Utilities    | National Water Company | 11         |
# | 547896325 | 1216731354 | 1000020553 | 135792 | 0000 | 84532224443132 | Water Services | Ministry Of Environment, Water And Agriculture | 20 |
# | 547896325 | 1216731354 | 1000020553 | 135792 | 0000 | 845322244440112 | Water Services | Ministry Of Environment, Water And Agriculture | 20 |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory | billSubcategory        | PaidAmount |
      | 582795613   | 1000006920 | 1701281915     | 135792   | 0000 | 283592972789  | Utilities    | National Water Company | 11         |
    @Android@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory | billSubcategory        | PaidAmount |
      | 582795613   | 1000006920 | 1701281915     | 135792   | 0000 | 283592972789  | Utilities    | National Water Company | 11         |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1277
    @Smoke
    @Regression
  Scenario Outline: 3 - Customer over pays the bill successfully
# Add new unpaid bill that accepts over payment
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
#    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "TestOverPayment" and continue
    Then user navigates to bill details screen
    And user clicks on add the bill button
    And user enters a valid otp "<otp>"
    Then user navigates to -bill added successfully- screen
# Make over payment
    And user clicks on pay now button
    Then user navigates to pay bill screen
    And Try to over pay the bill "<PaidAmount>"
    Then user navigates to confirm bill details screen
    And user clicks on confirm button
    And user enters a valid otp "<otp>"
    And Verify that success message bill paid successfully appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory        | billSubcategory | PaidAmount |
      | 507841395   | 1000036138 | 1571750981     | 135792   | 0000 | 0346564299947 | Banking and Finance | Bank Al-Jazira  | 12         |
# | 545368791 | 1000018083 | 2990875613 | 135792 | 0000 | 2019988099964 | Credit Cards | Bank Al-Jazira | 200 |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory        | billSubcategory | PaidAmount |
      | 507841395   | 1000036138 | 1571750981     | 135792   | 0000 | 0346564299947 | Banking and Finance | Bank Al-Jazira  | 12         |
# | 547896325 | 1216731354 | 1000020553 | 135792 | 0000 | 2019988099964 | Credit Cards | Bank Al-Jazira | 200 |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory        | billSubcategory | PaidAmount |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 0346564299947 | Banking and Finance | Bank Al-Jazira  | 12         |
    @Android@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory        | billSubcategory | PaidAmount |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 0346564299947 | Banking and Finance | Bank Al-Jazira  | 12         |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1345
    @Regression
  Scenario Outline: 4 - Customer can't add/pay a new bill that's status is paid
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
#    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
#    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
#    And user SignOut from registered device
#    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "NoAddedBill" and continue
    Then Verify that bill status is paid
# Then Verify that add the bill button is disabled
# And user clicks on add the bill button
# And user enters a valid otp "<otp>"
# Then user navigates to -bill added successfully- screen
# And Verify that pay now button is disabled
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 531702694   | 1000024533 | 1764198352     | 135792   | 0000 | 71833736240   | Telecom and internet | STC             |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 531702694   | 1000024533 | 1764198352     | 135792   | 0000 | 71833736240   | Telecom and internet | STC             |
    @iOS@UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736240   | Telecom and internet | STC             |
    @Android @UAT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736240   | Telecom and internet | STC             |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1346
    @Regression
  Scenario Outline: 5 - Customer can't make partial OR over payment for bills that don't allow those transactions
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
#    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "FullPayOnly" and continue
    Then user navigates to bill details screen
    And user clicks on add the bill button
    And user enters a valid otp "<otp>"
    Then user navigates to -bill added successfully- screen
# Try to make partial or over payment
    And user clicks on pay now button
    Then user navigates to pay bill screen
    And Verify that user can't make partial or over payment
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 562910734   | 1000024536 | 1845731092     | 135792   | 0000 | 71833736260   | Telecom and internet | STC             |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 562910734   | 1000024536 | 1845731092     | 135792   | 0000 | 71833736260   | Telecom and internet | STC             |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736260   | Telecom and internet | STC             |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736260   | Telecom and internet | STC             |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1347
    @Regression
  Scenario Outline: 6 - Account not found error message should appear when trying to enter invalid account number
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    Then Verify that account not found error message appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 570521948   | 1000024537 | 1920865473     | 135792   | 0000 | 0346564299947 | Telecom and internet | STC             |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 570521948   | 1000024537 | 1920865473     | 135792   | 0000 | 0346564299947 | Telecom and internet | STC             |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 0346564299947 | Telecom and internet | STC             |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 0346564299947 | Telecom and internet | STC             |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1374
    @Regression
  Scenario Outline: 7 -Verify that user can cancel deleting saved bill
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
#    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "TestCancelPayment" and continue
    Then user navigates to bill details screen
    And user clicks on add the bill button
    And user enters a valid otp "<otp>"
    Then user navigates to -bill added successfully- screen
    And user clicks on close button
# Check the saved bill
    Then Verify that payment section and data appeared successfully
    And user clicks on the new added bill
    Then Verify that bill details are appeared successfully
    And user clicks on delete the bill button
    And user clicks on cancel button
    Then the bill isn't deleted and user able to redirect to saved bill screen
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 515970628   | 1000024538 | 1596024831     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 515970628   | 1000024538 | 1596024831     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1375
    @Regression
  Scenario Outline: 8 - Verify that user can delete saved bill
    Given activate user status "<CIC>" by using API
    When The user skip App introduction
#    And user SignIn oneTimeUse with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user SignIn Register Device with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" OTP"<otp>"
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And add money to the user account
    And user navigates to SADAD payment screen
    And user clicks on add bill button
    Then user navigates to add bill screen
    And user selects bill Category "<billCategory>"
    And user selects bill Subcategory "<billSubcategory>"
    And user set the account number "<AccountNumber>" of the bill
    And user set the bill description "TestCancelPayment" and continue
    Then user navigates to bill details screen
    And user clicks on add the bill button
    And user enters a valid otp "<otp>"
    Then user navigates to -bill added successfully- screen
    And user clicks on close button
# Check the saved bill
    Then Verify that payment section and data appeared successfully
    And user clicks on the new added bill
    Then Verify that bill details are appeared successfully
    And user clicks on delete the bill button
    And user clicks on delete button
    Then the bill is deleted and a confirmation message appears
    @SIT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 585390142   | 1000036139 | 2539099891     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
    @SIT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 585390142   | 1000036139 | 2539099891     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
    @UAT @iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
    @UAT @Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  | AccountNumber | billCategory         | billSubcategory |
      | 558219436   | 1000006919 | 1976792497     | 135792   | 0000 | 71833736252   | Telecom and internet | STC             |
