@Signin
Feature: SignIn || As a User I want to use SignIn functionality to signIn Nera Mobile App

  @JiraIntegration @Priority:High @TEST_XRAY-3997
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 1 - User Can register device from device Management After one time signIn
  """
 Description: User Can register device from device Management After one time signIn
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user register device from device Management

  @JiraIntegration @Priority:High @TEST_XRAY-537
  @Smoke @Regression
  @Android @iOS @SIT @UAT
  Scenario: 2 - User could SignIn with valid data for one time use
  """
 Description: user could SignIn with valid data for one time use
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn oneTimeUse with data provided from csv file
    Then user SignOut from one time use

  @JiraIntegration
  @Priority:Highest
  @TEST_XRAY-539
  @Smoke
  @Regression
  @Android @iOS @SIT @UAT
  Scenario: 3 - User could SignIn with valid data for Register Device
  """
 Description: user could SignIn with valid data for Register Device "User register new device"
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    Then user UnRegister Device

  @JiraIntegration
  @Priority:Highest
  @TEST_XRAY-543
  @Smoke
  @Regression
  @Android @iOS @SIT @UAT
  Scenario: 4 - User SignIn registered device with valid passCode
  """
 Description: user signIn in registered device with valid passcode"
 """
    Given The user skip App introduction
    When Read user Data from csv file
    Then user SignIn Register Device with data provided from csv file
    And user SignOut from registered device
    And user Sign In Registered Device with his passcode
    Then user UnRegister Device


  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-540
    @Regression
  Scenario Template: 5 - User account blocked in case of enter 3 times invalid otp
  """
 Description: user account blocked in case of enter 3 times invalid otp
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    Then user blocked to Sign in with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" invalid three times OTP"<otp>"
    @Android@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 570468912   | 1000020434 | 2878339312     | 135792   | 1234 |
    @UAT@Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 553014268   | 1000006890 | 1825153255     | 135792   | 1234 |
    @iOS@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 507259418   | 1000019769 | 1886199726     | 135792   | 1234 |
    @UAT@iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 553014268   | 1000006890 | 1825153255     | 135792   | 1234 |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-569
    @Regression
  Scenario Template: 6 - User account blocked in case of enter 3 times invalid passCode
  """
 Description : User account blocked in case of enter 3 times invalid passCode
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    Then user blocked to SignIn with phoneNumber "<phoneNumber>"NationalId"<nationalNumber>"InValid three times passCode"<passCode>"
    @Android@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 597548062   | 1000018082 | 2937618920     | 135793   |
    @UAT@Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 514837962   | 1000006888 | 1422881084     | 135793   |
    @iOS@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 590271638   | 1000019754 | 1576023103     | 135793   |
    @UAT@iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 514837962   | 1000006888 | 1422881084     | 135793   |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-542
    @Regression
  Scenario Template: 7 - User couldn't SignIn with invalid credentials phoneNumber nationalNumber
  """
 Description : user couldn't signIn with invalid phonenumber or invalid id
 """
    Given The user skip App introduction
    Then User couldn't SignIn with invalid credentials "<phoneNumber>" "<nationalNumber>"
    @Android@SIT
    Examples:
      | phoneNumber | nationalNumber |
      | 545368792   | 2990875613     |
    @UAT@Android
    Examples:
      | phoneNumber | nationalNumber |
      | 598002436   | 1224920098     |
    @iOS@SIT
    Examples:
      | phoneNumber | nationalNumber |
      | 545368791   | 2990875612     |
    @UAT@iOS
    Examples:
      | phoneNumber | nationalNumber |
      | 549582354   | 1269365894     |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-1282
    @Regression
  Scenario Template: 8 - User couldn't SignIn with valid phoneNumber , ID and invalid passcode
  """
 Description : user couldn't Sign in with invalid passcode
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    And The user skip App introduction
    Then user Couldn't SignIn With "<phoneNumber>" and "<nationalNumber>" and inValid Passcode"<passCode>"
    @Android@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 571649250   | 1000019745 | 1825179110     | 123456   |
    @UAT@Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 520617543   | 1000006884 | 1411607748     | 123456   |
    @iOS@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 544615709   | 1000020056 | 2485340588     | 123456   |
    @UAT@iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode |
      | 520617543   | 1000006884 | 1411607748     | 123456   |

  @JiraIntegration
    @Priority:Highest
    @TEST_XRAY-706
    @Regression
  Scenario Template: 9 - User Couldn't SignIn With invalid otp
  """
 Description: User Couldn't SignIn With invalid otp
 """
    Given activate user status "<CIC>" by using API
    And user UnRegister all Devices related to customer id "<CIC>" by using dataBase
    When The user skip App introduction
    Then user could Not Sign in with phoneNumber "<phoneNumber>" NationalId "<nationalNumber>" passCode "<passCode>" invalid OTP"<otp>"
    @Android@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 576549831   | 1000020430 | 2007027267     | 135792   | 1234 |
    @UAT@Android
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 569183247   | 1000010686 | 1244402689     | 135792   | 1234 |
    @iOS@SIT
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 521750986   | 1000019753 | 1988022461     | 135792   | 1234 |
    @UAT@iOS
    Examples:
      | phoneNumber | CIC        | nationalNumber | passCode | otp  |
      | 547296531   | 1000010688 | 1266913969     | 135792   | 1234 |