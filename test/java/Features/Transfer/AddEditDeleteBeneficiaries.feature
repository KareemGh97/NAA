@AddEditDeleteBeneficiaries
@Smoke @Regression
Feature: beneficiary - Add edit delete beneficiary

  @JiraIntegration @Priority:Highest @TEST_XRAY-574
    @Android @iOS
  Scenario Outline: 1 - User could add edit delete New CRO beneficiary by using IBAN
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "iban" as "<iban>" and nickName as "Automation User"
    And user edit beneficiary nickName"Rahaf Automation"
    And user delete beneficiary
    @SIT
    Examples:
      | iban                     |
      | SA8980300011001100979497 |
    @UAT
    Examples:
      | iban                     |
      | SA6680300011001100137078 |

  @JiraIntegration @TEST_XRAY-575 @Priority:Highest
    @Android @iOS
  Scenario Outline: 2 - User could add edit delete New nera beneficiary by using nationalId
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "nationalId" as "<nationalId>" and nickName as "Automation User"
    And user edit beneficiary nickName"Rahaf Automation"
    And user delete beneficiary
    @SIT
    Examples:
      | nationalId |
      | 1105483800 |
    @UAT
    Examples:
      | nationalId |
      | 1222158931 |

  @JiraIntegration @TEST_XRAY-576 @Priority:Highest
    @Android @iOS
  Scenario Outline: 3 - User could add edit delete New Nera beneficiary by using phoneNumber
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "phoneNumber" as "<phoneNumber>" and nickName as "Automation User"
    And user edit beneficiary nickName"samir Automation"
    And user delete beneficiary
    @SIT
    Examples:
      | phoneNumber |
      | 524590718   |
    @UAT
    Examples:
      | phoneNumber |
      | 538601245   |

  @JiraIntegration @TEST_XRAY-577 @Priority:Highest
    @Android @iOS
    #addeing smoke test and retest tag
    #@Smoke
    #@retest
  Scenario Outline: 4 - User could add edit delete New Nera beneficiary by using accountNumber
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    When user open transfer screen
    And user Add Nera beneficiary
    And user add and active beneficiary by using "AccountNumber" as "<AccountNumber>" and nickName as "Automation User"
    And user edit beneficiary nickName"Samar Automation"
    And user delete beneficiary
    @SIT
    Examples:
      | AccountNumber |
      | 100097346     |
    @UAT
    Examples:
      | AccountNumber |
      | 100517997     |

  @JiraIntegration @Priority:Highest @TEST_XRAY-578
    @Android @iOS
    @not_on_UAT_yet
  Scenario Outline: 5 - User could add edit delete New ARB beneficiary by using IBAN
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user Add ARB beneficiary
    And user add and active beneficiary by using "iban" as "<iban>" and nickName as "Automation User"
    And user edit beneficiary nickName"editedNickName"
    And user delete beneficiary
    @SIT @UAT
    Examples:
      | iban                     |
      | SA9080000204608015995347 |
#      | SA1380000204608015514643 |

  @JiraIntegration @TEST_XRAY-579 @Priority:Highest
    @Android @iOS
    @not_on_UAT_yet
  Scenario Outline: 6 - User could add edit delete New ARB beneficiary by using nationalId
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user remove all restrictions for the user "<CIC>"
    And user Add ARB beneficiary
    And user add and active beneficiary by using "nationalId" as "<nationalId>" and nickName as "Automation User"
    And user edit beneficiary nickName"editedNickName"
    And user delete beneficiary
    @SIT @UAT
    Examples:
      | nationalId |
      | 1072587916 |

  @JiraIntegration @TEST_XRAY-580 @Priority:Highest
    @Android @iOS
    @not_on_UAT_yet
  Scenario Outline: 7 - User could add edit delete New ARB beneficiary by using phoneNumber
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user remove all restrictions for the user "<CIC>"
    And user Add ARB beneficiary
    And user add and active beneficiary by using "phoneNumber" as "<phoneNumber>" and nickName as "Automation User"
    And user edit beneficiary nickName"editedNickName"
    And user delete beneficiary
    @SIT @UAT
    Examples:
      | phoneNumber |
      | 529432302   |
#      | 549506871   |

  @JiraIntegration @TEST_XRAY-581 @Priority:Highest
    @Android @iOS

    @not_on_UAT_yet
  Scenario Outline: 8 - User could add edit delete New ARB beneficiary by using accountNumber
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user Add ARB beneficiary
    And user add and active beneficiary by using "AccountNumber" as "<AccountNumber>" and nickName as "Automation User"
    And user edit beneficiary nickName"userAutomation"
    And user delete beneficiary
    @SIT @UAT
    Examples:
      | AccountNumber         |
      | 204000010006085995347 |

  @JiraIntegration @TEST_XRAY-582 @Priority:Highest
    @Android @iOS
    @not_on_UAT_yet
    #kindly remove smoke and retest tag
    #@Smoke
    #@retest
  Scenario Outline: 9 - User could add edit delete New Local beneficiary by using IBAN
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user update registered device Date in DataBase by using CIC "<CIC>" with -7 days by using dataBase
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    And user remove all restrictions for the user "<CIC>"
    And user Add Local beneficiary
    And user Add active beneficiary by using local IBAN "<iban>" and nickName "<nickName>"
    And user edit beneficiary nickName"<editedNickName>"
    And user delete beneficiary
    @SIT @UAT
    Examples:
      | iban                     | nickName     | editedNickName |
      | SA1015000562104005610004 | First Family | userAutomation |
