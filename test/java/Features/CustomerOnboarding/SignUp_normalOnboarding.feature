@normalOnboarding @needsOnboarding
Feature: Croatia customer is normal onboarding

  @JiraIntegration @Priority:Highest @TEST_XRAY-3981
    @Android @SIT @iOS @UAT
    @Regression @Smoke
  Scenario Template: Missing place of birth from NAFATH response -  Activate ALO card
  """
Description: Missing place of birth from NAFATH response - Activate ALO card -
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user enters place of birth data
    And The user enters occupation "<occupational>" information details
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user Activate ALO card
    And the user create card pin "<CardPIN>"
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And select later for adding card to apple wallet if applicable
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | CardPIN |
      | 10          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 1357    |
      | 20          | IqamaID@AutomationTeam.com    | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 1357    |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3982
    @Android @SIT @iOS @UAT
    @Regression @Smoke
  Scenario Template: Missing place of birth from NAFATH response - without Activate ALO card
  """
Description:Missing place of birth from NAFATH response -  without Activate ALO card
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user enters place of birth data
    And The user enters occupation "<occupational>" information details
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user Activate ALO card Later
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 10          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 20          | IqamaID@AutomationTeam.com    | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3983
    @Android @SIT @iOS @UAT
    @Regression @Smoke
  Scenario Template: Normal NAFATH response - FOREIGNER - Place of birth saudi arabia - Activate ALO card
  """
Description: Normal NAFATH response - FOREIGNER - Place of birth saudi arabia| Activate ALO card -
"""
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
    And the user Activate ALO card
    And the user create card pin "<CardPIN>"
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And select later for adding card to apple wallet if applicable
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | CardPIN |
      | 25          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 1357    |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3984
    @Android @SIT @iOS @UAT
    @Regression
  Scenario Template: Normal NAFATH response - SAUDI - Place of birth saudi arabia| without Activate ALO card
  """
Description: Normal NAFATH response - SAUDI - Place of birth saudi arabia| without Activate ALO card
"""
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
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 12          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 15          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3985
    @Android @SIT @iOS @UAT
    @Regression @Smoke
  Scenario Template: Normal NAFATH response - FOREIGNER - Place of birth outside saudi arabia - Without activate ALO card
  """
Description: Normal NAFATH response - FOREIGNER - Place of birth outside saudi arabia -Without activate ALO card
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
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 27          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3986
    @Android @SIT @iOS @UAT
    @Regression
  Scenario Template: Normal NAFATH response - SAUDI - Place of birth outside Saudi arabia - Activate ALO card
  """
Description: Normal NAFATH response - SAUDI- Place of birth outside Saudi arabia - Activate ALO card -
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
    And the user Activate ALO card
    And the user create card pin "<CardPIN>"
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And select later for adding card to apple wallet if applicable
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | CardPIN |
      | 18          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 1357    |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3987
    @Android @SIT @iOS @UAT
  Scenario Template:Normal NAFATH response- High risk based on occupation

  """
 Description: E2E onboarding High risk based on occupation
 """
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user confirm BirthPlace return from nafath
    When customer select profession "<Profession>" Sector "<Sector>" occupation "<Occupation>" companyName "<CompanyName>"
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And the user is on the homepage
    @Smoke
    Examples:
      | IDStartWith | Email                         | Profession | Sector              | Occupation | CompanyName | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 17          | NationalId@AutomationTeam.com | Employee   | Government Employee | Lawyer     | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
    @Regression
    Examples:
      | IDStartWith | Email                         | Profession | Sector              | Occupation         | CompanyName | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 17          | NationalId@AutomationTeam.com | Employee   | Government Employee | Lawyer             | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | IqamaId@AutomationTeam.com    | Employee   | Government Employee | Assistant minister | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | NationalId@AutomationTeam.com | Employee   | Government Employee | Judge              | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | IqamaId@AutomationTeam.com    | Employee   | Government Employee | Kateb Adel         | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | NationalId@AutomationTeam.com | Employee   | Government Employee | Ambassador         | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | IqamaId@AutomationTeam.com    | Employee   | Government Employee | Scholar            | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | NationalId@AutomationTeam.com | Employee   | Government Employee | Diplomat           | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 17          | IqamaId@AutomationTeam.com    | Employee   | Government Employee | Officer            | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3988
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: ID expired From NAFATH response -
  """
Description:E2E |Normal onboarding|ID expired From NAFATH response -
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    Then The user back to Onboarding screen
    Examples:
      | IDStartWith |
      | 13          |
      | 23          |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3989
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Age below 18 From NAFATH response
  """
 Description:E2E |Normal onboarding|Age below 18 From NAFATH response
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    Then The user back to Onboarding screen
    Examples:
      | IDStartWith |
      | 19          |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3990
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Missing first name From NAFATH response
  """
Description:E2E |Normal onboarding|Missing first name From NAFATH response
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    Then error message of authentication fail
    Examples:
      | IDStartWith |
      | 16          |
      | 26          |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3991
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: No data found from NAFATH response
  """
Description:E2E |Normal onboarding|No data found from NAFATH response
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    Then wait 3 min then back to onboarding screen
    Examples:
      | IDStartWith |
      | 29          |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3992
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Missing Father's & grandfather's names from NAFATH response -  Activate ALO card
  """
Description: Missing Father's & grandfather's names from NAFATH response -  Activate ALO card
"""
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
    And the user Activate ALO card
    And the user create card pin "<CardPIN>"
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And select later for adding card to apple wallet if applicable
    And the user is on the homepage

    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | CardPIN |
      | 28          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 1357    |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3993
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Missing Father's & grandfather's names from NAFATH response -  Without Activate ALO card
  """
Description: Missing Father's & grandfather's names from NAFATH response -  Without Activate ALO card
"""
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
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 28          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3994
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Normal NAFATH response - High risk based on PEP

  """
 Description: E2E normal onboarding High risk pep user Scenario
 """
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user confirm BirthPlace return from nafath
    And The user enters occupation "<occupational>" information details
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the customer is confirm PEP
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 12          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
      | 22          | IqamaID@AutomationTeam.com    | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3995
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Sanction NAFATH response
  """
Description:Sanction NAFATH response
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
    Then the customer is stopped at pending approval screen
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount |
      | 14          | NationalId@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            |
      | 24          | IqamaId@AutomationTeam.com    | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            |

  @JiraIntegration @Priority:High @TEST_XRAY-3996
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Normal NAFATH response - Additional Spending's and Tax - High Risk PEP
  """
 Description: Onboarding with additional Spending's and Tax-High Risk PEP
 """
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enters email<Email>
    And The user confirm BirthPlace return from nafath
    When customer select profession "<Profession>" Sector "<Sector>" occupation "<Occupation>" companyName "<CompanyName>"
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the customer is confirm PEP and add Tax residency
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                             | Profession | Sector              | Occupation | CompanyName | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 17          | AutomationTeam@AutomationTeam.com | Employee   | Government Employee | Accountant | NeraBank    | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3998
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Missing street Name & city from NAFATH response -  Activate ALO card
  """
Description: Missing street Name & city from NAFATH response -  Activate ALO card
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enter missing Address
    And The user enters email<Email>
    And The user confirm BirthPlace return from nafath
    And The user enters occupation "<occupational>" information details
    And The user enter financial information "<SourceOfIncome>" "<IncomeAmount>" "<MonthlyDebitCreditAmount>"
    And the user clicks on FATCA continue
    And the user accept Terms&conditions and Sama consent
    And the user Activate ALO card
    And the user create card pin "<CardPIN>"
    And the user create passcode "<passcode>"
    And the user redirect to activate "touch" and select later
    Then the user is onboarded successfully
    And select later for adding card to apple wallet if applicable
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                         | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode | CardPIN |
      | 11          | NationalID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   | 1357    |

  @JiraIntegration @Priority:Highest @TEST_XRAY-3999
    @UAT @Android @SIT @iOS
    @Regression @Smoke
  Scenario Template: Missing street Name from NAFATH response -  without Activate ALO card
  """
Description:Missing street Name from NAFATH response -  without Activate ALO card
"""
    Given Generate valid credentials ID <IDStartWith> and phone Number
    And The user skip App introduction
    And Tahaqoq validates the credentials entered by the user
    And OTP validation is sent by the system to the phone number entered by the user
    And The user allows nera to retrieve data from Nafath
    And The user enter missing Address streetName
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
    And the user is on the homepage
    Examples:
      | IDStartWith | Email                      | occupational | SourceOfIncome | IncomeAmount          | MonthlyDebitCreditAmount | passcode |
      | 21          | IqamaID@AutomationTeam.com | Not Employee | Salary         | From 3001 to SAR 6000 | 2,501 - 5,000            | 135792   |
