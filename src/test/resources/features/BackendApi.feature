@amazonab
Feature: Backend Api Testing

  @backendApi @apiAdminUI  @TC18880
  Scenario: CreateOrder For Test
    Given the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    Then validate the CreateOrder api response

  @backendApi @apiApplicantUI  @TC900
  Scenario Outline: LookupOrder, good response
    Given the login page for Room Admin UI is showing in the browser
    When user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      |EACaseId       |[gennum:9]     |
    And a request json "<jsonFile>" for LookupOrder api
    And update the json request
      | json path         | new value |
      | encryptedOrderId  | data.runtime.invite-encrypted-wellness-order-id |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"
    And validate the LookupOrder api response

    Examples:
      | jsonFile           | httpStatus  |
      | LookupOrder.json   | 200         |

  @backendApi @apiApplicantUI  @TC901
  Scenario Outline: LookupOrder, Text Order ID
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for LookupOrder api
    And update the json request
      | json path         | new value |
      | encryptedOrderId  | invalid   |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile           | httpStatus  |
      | LookupOrder.json   | 404         |

  @backendApi @apiApplicantUI  @TC902
  Scenario Outline: LookupOrder, OrderID not found
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for LookupOrder api
    And update the json request
      | json path         | new value |
      | .encryptedOrderId | GgVpFnYjkWn5RCTtwRtKdw== |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile           | httpStatus  |
      | LookupOrder.json   | 404         |

  @backendApi @apiApplicantUI  @TC903
  Scenario Outline: LookupOrder, drug collection has already been completed
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for LookupOrder api
    And update the json request
      | json path         | new value |
      | .encryptedOrderId | vL9BVBcLpENUmu7YE5aYgriZOnW/bWU0zu2wM2saJRA= |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile           | httpStatus  |
      | LookupOrder.json   | 400         |

  @backendApi @apiApplicantUI  @TC904
  Scenario Outline: LookupOrder, invalid requests
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for LookupOrder api
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                  | httpStatus  |
      | LookupOrder-invalid1.json | 404         |
      | LookupOrder-invalid2.json | 404         |

  @backendApi @apiApplicantUI  @TC1000
  Scenario Outline: LookupInvite, good response
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<orderJsonFile>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | Automation      |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And a request json "<jsonFile>" for LookupInvite api
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"
    And validate the LookupInvite api response

    Examples:
      |orderJsonFile| jsonFile           | httpStatus  |
      |WAOrder.json | LookupInvite.json  | 200         |


  @backendApi @apiApplicantUI  @TC1001
  Scenario Outline: LookupInvite, record not found
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<orderJsonFile>" for CreateOrder api
    And update the json request
      | json path   | new value  |
      | .lastName   | Automation |
      | .wellnessId | [gennum:9] |
      | .EACaseId   | [gennum:9] |
    And a POST call is sent to the api
    And a request json "<jsonFile>" for LookupInvite api
    And update the json request
      | json path | new value |
      | .lastName | invalid   |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | orderJsonFile | jsonFile          | httpStatus |
      | WAOrder.json  | LookupInvite.json | 404        |

  @backendApi @apiApplicantUI  @TC1002
  Scenario Outline: LookupInvite, invalid requests
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for LookupInvite api
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                   | httpStatus  |
      | LookupInvite-invalid1.json | 400         |
      | LookupInvite-invalid2.json | 400         |
      | LookupInvite-invalid3.json | 400         |

  @backendApi @apiApplicantUI  @TC1200
  Scenario Outline: Status POST, update status, valid step
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request json "<jsonFile>" for Status api with invite uuid
    And update the json request
      | json path | new value |
      | .step     | consent   |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"
    And validate the Status api response with status "<expectedStatus>"

    Examples:
      | jsonFile    | httpStatus  | expectedStatus |
      | Status.json | 200         | consent        |


  @backendApi @apiApplicantUI  @TC1201
  Scenario Outline: Status POST, update status, invalid data
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request json "<jsonFile>" for Status api with invite uuid
    And update the json request
      | json path | new value |
      | .step     | wrong     |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile     | httpStatus  |
      | Status.json  | 422         |


  @backendApi @apiApplicantUI  @TC1202
  Scenario Outline: Status POST, update status, invalid request json
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request json "<jsonFile>" for Status api with invite uuid
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile             | httpStatus  |
      | Status-invalid1.json | 422         |
      | Status-invalid2.json | 422         |


  @backendApi @apiApplicantUI  @TC1300
  Scenario: SubmitImage, valid request
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "WAOrder.json" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | Submit2       |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "LookupInvite.json" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | Submit2|
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api with runtime invite uuid
    When a Post call is sent to the api with retries
    Then a response should return with status "200"
    And validate the SubmitImage api response


  @backendApi @apiApplicantUI  @TC1302 @TC11214 @TC1301
  Scenario Outline: SubmitImage, invalid request
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "WAOrder.json" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | Submit2       |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "LookupInvite.json" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | Submit2|
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "<jsonFile>" for SubmitImage api with runtime invite uuid
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                           | httpStatus  |
      | SubmitImage-invalid1.json          | 400         |
      | SubmitImage-invalid2.json          | 400         |
      | SubmitImage-invalid3.json          | 400         |
      | SubmitImage-invalid4.json          | 400         |
      | SubmitImagePartialInvalidCode.json | 400         |


  @backendApi @apiApplicantUI @TC1400
  Scenario Outline: Help api, update to valid status
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request for Help api with invite uuid for status "<helpStatus>"
    When a GET call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | helpStatus    | httpStatus  |
      | requested     | 200         |
      | notRequested  | 200         |
      | resolved      | 200         |

  @backendApi @apiApplicantUI @TC1401
  Scenario Outline: Help api, update to invalid status
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request for Help api with invite uuid for status "<helpStatus>"
    When a GET call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | helpStatus    | httpStatus  |
      | non-status    | 400         |

  @backendApi @apiAdminUI  @TC2000
  Scenario Outline: CreateOrder, valid data
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .firstName    | Test          |
      | .lastName     | Auto1         |
      | .dateOfBirth  | 01/01/2000    |
      | .phoneNumber  | 404-229-1234  |
      | .expires      | 01/01/2024    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]     |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"
    And validate the CreateOrder api response

    Examples:
      | jsonFile     | httpStatus  |
      | WAOrder.json | 200         |


  @backendApi @apiAdminUI  @TC2001
  Scenario Outline: CreateOrder, invalid birthdate
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .dateOfBirth  | 2000          |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]     |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile     | httpStatus  |
      | WAOrder.json | 400         |


  @backendApi @apiAdminUI  @TC2002
  Scenario Outline: CreateOrder, invalid expires date
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for CreateOrder api
    And update the json request
      | json path   | new value  |
      | .wellnessId | [gennum:9] |
      | .EACaseId   | [gennum:9] |

    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                          | httpStatus |
      | WAOrderInvalidExpirationDate.json | 400        |

  @backendApi @apiAdminUI  @TC2003
  Scenario Outline: CreateOrder, missing field in json request
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]     |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                | httpStatus  |
      | WAOrder_invalid1.json   | 400         |
      | WAOrder_invalid2.json   | 400         |
      | WAOrder_invalid3.json   | 400         |
      | WAOrder_invalid4.json   | 400         |
      | WAOrder_invalid5.json   | 400         |
      | WAOrder_invalid6.json   | 400         |
      | WAOrder_invalid7.json   | 400         |
      | WAOrder_invalid8.json   | 400         |
      | WAOrder_invalid9.json   | 400         |
      | WAOrder_invalid10.json   | 400         |
      | WAOrder_invalid11.json   | 400         |
      | WAOrder_invalid12.json   | 400         |

  @backendApi @apiAdminUI  @TC2100
  Scenario: GetActiveTestsForLocation, valid data
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "WAOrder.json" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | Submit2       |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]     |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "LookupInvite.json" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | Submit2|
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a response should return with status "200"
    And a request json "SubmitImage.json" for SubmitImage api with runtime invite uuid
    And a Post call is sent to the api with retries
    And a response should return with status "200"
    When a request for getActiveTestsForLocation api for default location
    And a GET call is sent to the api
    Then a response should return with status "200"


  @backendApi @apiAdminUI  @TC2101
  Scenario Outline: GetActiveTestsForLocation, invalid location
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for getActiveTestsForLocation api for location "<locationUuid>"
    When a GET call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | locationUuid       | httpStatus  |
      | location.invalid   | 204         |


  @backendApi @apiAdminUI @TC2200
  Scenario Outline: Location
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for Location api
    When a GET call is sent to the api
    Then a response should return with status "<httpStatus>"
    And validate the Location api response

    Examples:
      | httpStatus  |
      | 200         |

  @backendApi @apiAdminUI  @TC2300
  Scenario Outline: Admin Help, valid case
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request json "<jsonFile>" for Admin Help api with default invite uuid for status "<helpStatus>"
    And update the json request
      | json path              | new value |
      | .helpResolutionComment | helped    |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile  | helpStatus    | httpStatus  |
      | Help.json | resolved      | 200         |

  @backendApi @apiAdminUI  @TC2301
  Scenario Outline: Admin Help, invalid invite uuid
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for Admin Help api with invite uuid "<uuid>" for status "<helpStatus>"
    And update the json request
      | json path              | new value |
      | .helpResolutionComment | helped    |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile  | uuid               | helpStatus    | httpStatus  |
      | Help.json | invalid.uuid       | resolved      | 404         |

  @backendApi @apiAdminUI  @TC2302
  Scenario Outline: Admin Help, invalid help status
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonFile>" for Admin Help api with invite uuid "<uuid>" for status "<helpStatus>"
    And update the json request
      | json path              | new value |
      | .helpResolutionComment | helped    |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile  | uuid               | helpStatus    | httpStatus  |
      | Help.json | data.invite.uuid   | invalid       | 404         |


  @backendApi @apiAdminUI  @TC2401
  Scenario Outline: Adjudicate Negative
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | AutoAdj01      |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]     |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "<jsonLookupInvite>" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | AutoAdj01    |
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a response should return with status "<httpStatus>"
    And a request json "<jsonSubmitStripResults>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a response should return with status "<httpStatus>"
    When a request json "<jsonAdjudicate>" for Adjudicate api with invite uuid "<uuid>" for result "<drugResult>"
    And a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder | jsonLookupInvite  | jsonSubmitImage  | jsonSubmitStripResults       | jsonAdjudicate  | uuid                      | drugResult    | httpStatus  |
      | WAOrder.json | LookupInvite.json | SubmitImage.json | SubmitImageProcessStrips.json| Adjudicate.json | data.runtime.invite-uuid  | negative      | 200         |

  @backendApi @apiAdminUI  @TC2402
  Scenario Outline: Adjudicate retakePicture
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | AutoAdj2      |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "<jsonLookupInvite>" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | AutoAdj2    |
      | .dateOfBirth  | 01/01/2001  |
      | .wellnessId   | [gennum:9]  |
    And a POST call is sent to the api
    And a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a request json "<jsonSubmitStripResults>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    When a request json "<jsonAdjudicate>" for Adjudicate api with invite uuid "<uuid>" for result "<drugResult>"
    And a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder | jsonLookupInvite  | jsonSubmitImage  | jsonSubmitStripResults         | jsonAdjudicate  | uuid                      | drugResult    | httpStatus  |
      | WAOrder.json | LookupInvite.json | SubmitImage.json |   SubmitImageProcessStrips.json|Adjudicate.json  | data.runtime.invite-uuid  | retakePicture | 200         |


  @backendApi @apiAdminUI  @TC2403
  Scenario Outline: Adjudicate invalid
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | AutoAdj3      |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "<jsonLookupInvite>" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | AutoAdj3    |
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a request json "<jsonSubmitStripResults>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    When a request json "<jsonAdjudicate>" for Adjudicate api with invite uuid "<uuid>" for result "<drugResult>"
    And a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder | jsonLookupInvite  | jsonSubmitImage  |jsonSubmitStripResults         |  jsonAdjudicate       | uuid                      | drugResult    | httpStatus  |
      | WAOrder.json | LookupInvite.json | SubmitImage.json |  SubmitImageProcessStrips.json|AdjudicateInvalid.json | data.runtime.invite-uuid  | invalid       | 200         |

  @backendApi @apiAdminUI  @TC2404
  Scenario Outline: Adjudicate confirmation
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | AutoAdj4      |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "<jsonLookupInvite>" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | AutoAdj4    |
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a request json "<jsonSubmitStripResults>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a response should return with status "<httpStatus>"
    When a request json "<jsonAdjudicate>" for Adjudicate api with invite uuid "<uuid>" for result "<drugResult>"
    And a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder | jsonLookupInvite  | jsonSubmitImage  | jsonSubmitStripResults        | jsonAdjudicate  | uuid                      | drugResult    | httpStatus  |
      | WAOrder.json | LookupInvite.json | SubmitImage.json |  SubmitImageProcessStrips.json| Adjudicate.json | data.runtime.invite-uuid  | confirmation  | 200         |


  @backendApi @apiAdminUI  @TC2405
  Scenario Outline: Adjudicate confirmation with selected drugtest
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | AutoAdj5      |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "<jsonLookupInvite>" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | AutoAdj5    |
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    When a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a request json "<jsonSubmitStripResults>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a request json "<jsonAdjudicate>" for Adjudicate api with invite uuid "<uuid>" for result "<drugResult>"
    And a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder | jsonLookupInvite  | jsonSubmitImage  | jsonSubmitStripResults       | jsonAdjudicate               | uuid                      | drugResult    | httpStatus  |
      | WAOrder.json | LookupInvite.json | SubmitImage.json | SubmitImageProcessStrips.json| AdjudicateInconclusive.json  | data.runtime.invite-uuid  | confirmation  | 200         |



  @backendApi @apiAdminUI  @TC5466
  Scenario: EA - 1Step Xchange, ReasonForTest YES, Options for OralTox
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And create a new case using Xchange 1Step
      | file                      |
      | 1stepOralToxPromotion.xml |
    Then I verify the order was created via One Step Xchange

#Oraleze is not in use for near future
#  @backendApi @apiAdminUI  @TC5771
#  Scenario: EA - 1Step Xchange, ReasonForTest YES, Options for OralEze
#    Given the login page for Room Admin UI is showing in the browser
#    And user login with "data.admin.login.user" and "data.admin.login.pass"
#    And create a new case using Xchange 1Step
#      | file                   |
#      | 1stepOralEzeRandom.xml |
#    Then I verify the order was created via One Step Xchange


  @backendApi @apiAdminUI  @TC9883
  Scenario: Admin Filter By
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "WAOrder.json" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | A24HourFilter  |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "LookupInvite.json" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | A24HourFilter|
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a response should return with status "200"
    And a request json "SubmitImageProcessStrips.json" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a request json "AdjudicateInconclusive.json" for Adjudicate api with invite uuid "data.runtime.invite-uuid" for result "confirmation"
    And a POST call is sent to the api
    And a response should return with status "200"
    And a request for Location api
    And a request for getActiveTestsForLocation api for default location
    And a GET call is sent to the api
    And a response should return with status "200"
    When a request json "SearchBy24.json" for Filter By Search
    And a POST call is sent to the api
    Then a response should return with status "200"
    And I validate the candidate by last name "A24HourFilter" exists in the search results


  @backendApi @apiAdminUI  @TC11214
  Scenario Outline: Expired Invalid Duplicate and Resolve with Retest
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | Automation    |
      | .dateOfBirth  | 01/01/2000    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "<jsonLookupInvite>" for LookupInvite api
    And a POST call is sent to the api
    When a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    And a POST call is sent to the api
    And a response should return with status "<httpStatusError>"
    Then a request for Help api with invite uuid for status "<helpStatus>"
    And a POST call is sent to the api
    And a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder | jsonLookupInvite  | jsonSubmitImage                |   helpStatus| httpStatus  |httpStatusError|
      | WAOrder.json | LookupInvite.json | SubmitImage-expired.json       |   resolved  |200          | 400           |
      | WAOrder.json | LookupInvite.json | SubmitImage-invalidDevice.json |   resolved  |200          | 400           |
      | WAOrder.json | LookupInvite.json | SubmitImage-duplicate.json     |   resolved  |200          | 400           |



  @backendApi @apiAdminUI @TC31505 @TC33898 @TC31494 @TC34341 @TC34622 @TC34619 @TC34620 @TC34623 @TC34624 @34388 @74688
  Scenario Outline: Create Order via Admin API
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for Admin CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | adminOrder1   |
      | .dateOfBirth  | 01/01/1965    |
      | .candidateId  | [gennum:12]   |
      | wellnessId    | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "<httpStatus>"
    When a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "<httpStatus>"
    And a request json "<jsonPatchOrder>" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "<httpStatus>"
    And a GET call is sent to the api
    And a response should return with status "<httpStatus>"
    Then I verify the Create Order Candidate information is updated
      |firstName  |Terry        |
      |lastName   |AdminOrder1  |
      |dateOfBirth| 1970-12-12  |

    Examples:
      | jsonNewOrder      |httpStatus|jsonPatchOrder           |
      | AdminUIOrderRND.json |200       |AdminUIOrderForPatchRND.json|


  @TC35654 @backendApi @apiAdminUI
  Scenario Outline: Search Invites via Admin API
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for Admin CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | adminOrder1   |
      | .dateOfBirth  | 01/01/1965    |
      | .candidateId  | [gennum:12]   |
      | .phoneNumber  | 6789769898  |
      | .ssn          | 123-12-7809   |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "<httpStatus>"
    When a request to retrieve existing Candidates via Admin SearchInvites api
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "<httpStatus>"
    Then I verify the Create Order Candidate information is updated
      |firstName  |Terry        |
      |lastName   |adminOrder1  |
      |dateOfBirth| 1965-01-01  |
      |phoneNumber|6789769898   |


    Examples:
      | jsonNewOrder      |httpStatus|
      | AdminUIOrder.json |200       |

    
  @backendApi @apiAdminUI @TC52161
  Scenario Outline: Admin UI - Api: SideAlley Update Location via Admin UI
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for Admin CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | adminOrder1  |
      | .dateOfBirth  | 01/01/1965    |
      | .candidateId  | [gennum:12]   |
      | .phoneNumber  | 6789769898  |
      | .ssn          | 123-12-7809   |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "<httpStatus>"
    And a request to retrieve existing Candidates via Admin SearchInvites api
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "<httpStatus>"
    And a request for Location api
    And a GET call is sent to the api
    And a response should return with status "<httpStatus>"
    When a request to update to location "093421d4-676f-456d-b211-69d3218131bf" for existing Order via Admin UI
    And a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonNewOrder      |httpStatus|
      | AdminUIOrder.json |200       |

  @backendApi @apiApplicantUI  @TC52701
  Scenario Outline: Candidate UI - API: Booth number validation
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request json "<jsonFile>" for LookupInvite api
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                     | httpStatus |
      | LookupInvite-invalid0.json   | 400        |
      | LookupInvite-invalid100.json | 400        |
      | LookupInvite.json            | 200        |


  #Need to finish this after the functionality rolls out. It's very involved and need more time with getting
#  file inside json
#  @TC39314 @backendApi @apiAdminUI @TC39314 @TC39318 @TC39324
#  Scenario Outline: Backend API: Upload Multiple Orders
#    Given a request json "<jsonBatchUploadOrder>" for Admin Batch Upload Orders api
#    When a POST call is sent to the api
#    Then a response should return with status "<httpStatus>"
#    And I verify the the 9 Batch Orders are created
#
#    Examples:
#      | jsonBatchUploadOrder |httpStatus|
#      | AdminUIOrder.json    |200       |

  @backendApi  @apiAdminUI  @TC59769 @74688 @81589
  Scenario: Admin UI - Backend API: Salary Leader adjudicates with Confirmation-Verification
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "adminUIOrderRND.json" for Admin CreateOrder api
    And update the json request
      | json path    | new value   |
      | .lastName    | adminOrder1 |
      | .dateOfBirth | 01/01/2001  |
      | .candidateId | [gennum:12] |
      | .phoneNumber | 6789769898  |
      | .ssn         | 123-12-8998 |
      | wellnessId   | [gennum:9]  |
      | .EACaseId    | [gennum:9]  |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatchRND.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "LookupInviteNoBooth_SalaryVerification.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageWValuesAdminUIRND.json" for SubmitImage api for Admin UI order
    And a POST call is sent to the api
    And a response should return with status "200"
    When a request json "AdjudicateConfirmationVerification.json" for Confirmation-Verification api
    And a POST call is sent to the api
    Then a response should return with status "200"

  @backendApi  @apiAdminUI  @TC60753
  Scenario:Admin UI - Backend API: Salary Leader adjudicates with Negative-Verification
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "adminUIOrderRND.json" for Admin CreateOrder api
    And update the json request
      | json path    | new value   |
      | .lastName    | adminOrder1 |
      | .dateOfBirth | 01/01/2001  |
      | .candidateId | [gennum:12] |
      | wellnessId   | [gennum:9]  |
      | .EACaseId    | [gennum:9]  |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatchRND.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "LookupInviteNoBooth_SalaryVerification.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImageWValuesAdminUIRND.json" for SubmitImage api for Admin UI order
    And a POST call is sent to the api
    And a response should return with status "200"
    When a request json "AdjudicateNegativeVerification.json" for Negative-Verification api
    And a POST call is sent to the api
    Then a response should return with status "200"


    @backendApi  @apiAdminUI  @TC60755
  Scenario: Admin UI - Backend API: Salary Leader verification is not valid for non-Random orders
      Given the login page for Room Admin UI is showing in the browser
      And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "adminUIOrder.json" for Admin CreateOrder api
    And update the json request
      | json path    | new value   |
      | .lastName    | adminOrder1 |
      | .dateOfBirth | 01/01/2001  |
      | .candidateId | [gennum:12] |
      | .phoneNumber | 6789769898  |
      | .ssn         | 123-12-8998 |
      | wellnessId   | [gennum:9]  |
      | .EACaseId    | [gennum:9]  |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatch_SalaryVerificationPRE.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "LookupInvite.json" for LookupInvite api
    And a POST call is sent to the api
    And a request json "SubmitImage.json" for SubmitImage api for Admin UI order
    And a POST call is sent to the api
    And a response should return with status "200"
    When a request json "AdjudicateConfirmationVerification.json" for Confirmation-Verification api
    And a POST call is sent to the api
    Then a response should return with status "400"
    And a request json "AdjudicateNegativeVerification.json" for Negative-Verification api
    And a POST call is sent to the api
    And a response should return with status "400"

  @backendApi @apiApplicantUI  @TC67273
  Scenario Outline: updateContactInformation, valid data
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
     And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    When a request json "<jsonFile>" for updateContactInformation api with invite uuid
    And update the json request
      | json path     | new value    |
      | .phoneNumber  | 404-222-3344 |
      | .emailAddress | abc@fadv.com |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                      | httpStatus |
      | UpdateContactInformation.json | 200        |
      
  @backendApi @apiApplicantUI  @TC72613
  Scenario Outline: updateContactInformation, invalid data
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request for CreateOrder and POST to the api
      | json field    | new value     |
      | lastName      | Auto[gennum:5]|
      | deviceType    | oralTox       |
      | reasonForTest | PRE           |
      | wellnessId    | [gennum:9]    |
      | EACaseId      |[gennum:9]     |
    And validate the CreateOrder api response
    And a request json "<jsonFile>" for updateContactInformation api with invite uuid
    And update the json request
      | json path     | new value    |
      | .phoneNumber  | 404-222-34 |
      | .emailAddress | abc@fadvcom |
    When a POST call is sent to the api
    Then a response should return with status "<httpStatus>"

    Examples:
      | jsonFile                      | httpStatus |
      | UpdateContactInformation.json | 400        |

  @backendApi @apiApplicantUI  @TC74793
  Scenario Outline: Applicant UI - Alias : API call for Applicant UI Amazon Alias field for non-PreEmployment Orders
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for Admin CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | AdminOrder1   |
      | .dateOfBirth  | 01/01/1965    |
      | .candidateId  | [gennum:12]   |
      | wellnessId    | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "<httpStatus>"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "<httpStatus>"
    And a request json "<jsonPatchOrder>" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "<httpStatus>"
    And a GET call is sent to the api
    And a response should return with status "<httpStatus>"
    And I verify the Create Order Candidate information is updated
      |firstName  |Terry        |
      |lastName   |AdminOrder1  |
      |dateOfBirth| 1970-12-12  |
    When a request json "<jsonLookUpInvite>" for LookupInvite api
    And a POST call is sent to the api
    Then a response should return with status "<LookupInviteStatusCode>"

      Examples:
      | jsonNewOrder         | httpStatus | jsonPatchOrder               | jsonLookUpInvite                      | LookupInviteStatusCode |
      | AdminUIOrderRND.json | 200        | AdminUIOrderForPatchRND.json | LookupInviteAdminNonPre-Invalid.json  | 400                    |
      | AdminUIOrderRND.json | 200        | AdminUIOrderForPatchRND.json | LookupInviteAdminNonPre-Invalid2.json | 400                    |
      | AdminUIOrderRND.json | 200        | AdminUIOrderForPatchRND.json | LookupInviteAdminNonPre.json          | 200                    |

  @backendApi  @apiAdminUI  @TC74038
  Scenario: Admin UI -  API: Tracking Information
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "TrackingInfo.json" for UpdateShippingInformation api
    And update the json request
      | json path       | new value          |
      | .shipper        | UPS                |
      | .trackingNumber | 123654789654123147 |
    When a POST call is sent to the api
    Then a response should return with status "200"

  @backendApi @apiApplicantUI  @TC92283 @TC92286
  Scenario Outline: Applicant UI -API: Scan New QR Code
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "<jsonNewOrder>" for CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | Submit2       |
      | .dateOfBirth  | 01/01/2001    |
      | .wellnessId   | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a POST call is sent to the api
    And validate the CreateOrder api response
    And a request json "LookupInvite.json" for LookupInvite api
    And update the json request
      | json path     | new value   |
      | .lastName     | Submit2|
      | .dateOfBirth  | 01/01/2001  |
    And a POST call is sent to the api
    And a request json "<jsonSubmitImage>" for SubmitImage api with runtime invite uuid
    When a Post call is sent to the api with retries
    Then a response should return with status "<httpStatus>"
    Examples:
      | jsonNewOrder | jsonSubmitImage                   | httpStatus |
      | WAOrder.json | SubmitImageNewQR.json         | 200        |
      | WAOrder.json | SubmitImageNewQR_invalid.json | 400        |

    #Support tool requires an FADV user with roles, now it fails because of existing user
#  @backendApi @apiAdminUI  @TC117799 @TC117193 @TC117195
#  Scenario: Admin UI - API - Support Tool -Search Candidate
#    Given the login page for Room Admin UI is showing in the browser
#    And user login with "data.admin.login.user" and "data.admin.login.pass"
#    And a request for Support Tool and GET to the api
#    And a response should return with status "200"
#    And a request json "AdminUIOrderRND.json" for Admin CreateOrder api
#    And update the json request
#      | json path     | new value     |
#      | .lastName     | AdminOrder1   |
#      | .dateOfBirth  | 01/01/1965    |
#      | .candidateId  | [gennum:12]   |
#      | wellnessId    | [gennum:9]    |
#      | .EACaseId      |[gennum:9]    |
#    And a Post call with Admin UI order information is sent to the api
#    And a response should return with status "200"
#    And a request to retrieve an existing candidate for the CreateOrder api
#    And a GET call is sent to the api
#    And a response should return with status "200"
#    And a request json "AdminUIOrderForPatchRND.json" for Admin CreateOrder Patch api
#    And update the json with the current candidate id
#    And a request to retrieve an existing candidate for the CreateOrder api
#    And a PATCH call is sent to the api
#    And a response should return with status "200"
#    And a GET call is sent to the api
#    And a response should return with status "200"
#    And I verify the Create Order Candidate information is updated
#      |firstName  |Terry        |
#      |lastName   |AdminOrder1  |
#      |dateOfBirth| 1970-12-12  |
#    And a request json "LookupInviteAdminNonPre.json" for LookupInvite api
#    And a POST call is sent to the api
#    And a response should return with status "200"
#    And a request for Candidate and GET to the api
#    And a response should return with status "200"
#    When I search by candidate name "AdminOrder1" in the support tool
#    Then a response should return with status "200"
#    And I search by device ID "000" in the support tool
#    And a response should return with status "200"

    #Support tool requires an FADV user with roles, now it fails because of existing user
#  @backendApi @apiAdminUI  @TC119169 @TC119272 @TC119282
#  Scenario Outline: Support Tool - Backend - WellnessId should not accept non-numeric value
#    Given the login page for Room Admin UI is showing in the browser
#    And user login with "data.admin.login.user" and "data.admin.login.pass"
#    And a request for Support Tool and GET to the api
#    And a response should return with status "200"
#    And a request json "AdminUIOrderRND.json" for Admin CreateOrder api
#    And update the json request
#      | json path     | new value     |
#      | .lastName     | AdminOrder1   |
#      | .dateOfBirth  | 01/01/1965    |
#      | .candidateId  | [gennum:12]   |
#      | wellnessId    | [gennum:9]    |
#      | .EACaseId      |[gennum:9]    |
#    And a Post call with Admin UI order information is sent to the api
#    And a response should return with status "200"
#    And a request to retrieve an existing candidate for the CreateOrder api
#    And a GET call is sent to the api
#    And a response should return with status "200"
#    And a request json "AdminUIOrderForPatchRND.json" for Admin CreateOrder Patch api
#    And update the json with the current candidate id
#    And a request to retrieve an existing candidate for the CreateOrder api
#    And a PATCH call is sent to the api
#    And a response should return with status "200"
#    And a GET call is sent to the api
#    And a response should return with status "200"
#    And I verify the Create Order Candidate information is updated
#      |firstName  |Terry        |
#      |lastName   |AdminOrder1  |
#      |dateOfBirth| 1970-12-12  |
#    And a request json "LookupInviteAdminNonPre.json" for LookupInvite api
#    And a POST call is sent to the api
#    And a response should return with status "200"
#    And a request for Candidate and GET to the api
#    And a response should return with status "200"
#    When a request json "<json file>" for Support Tool Patch api
#    And a PATCH call is sent to the api
#    Then a response should return with status "<status>"
#    And a request json "supportToolPatch_StepStatus.json" for Support Tool Patch api
#    And a PATCH call is sent to the api
#    And a response should return with status "200"
#    Examples:
#      | json file                         | status |
#      | supportToolPatch_WID.json         | 200    |
#      | supportToolPatch_WID_invalid.json | 400    |

  @backendApi @apiApplicantUI @TC136571
  Scenario: Applicant UI - API: Backend Testing for "updateCandidateEmailFlag" api
    Given the login page for Room Admin UI is showing in the browser
    And user login with "data.admin.login.user" and "data.admin.login.pass"
    And a request json "AdminUIOrderRND.json" for Admin CreateOrder api
    And update the json request
      | json path     | new value     |
      | .lastName     | EmailReport1   |
      | .dateOfBirth  | 01/01/1965    |
      | .candidateId  | [gennum:12]   |
      | wellnessId    | [gennum:9]    |
      | .EACaseId      |[gennum:9]    |
    And a Post call with Admin UI order information is sent to the api
    And a response should return with status "200"
    And a request to retrieve an existing candidate for the CreateOrder api
    And a GET call is sent to the api
    And a response should return with status "200"
    And a request json "AdminUIOrderForPatchRND.json" for Admin CreateOrder Patch api
    And update the json with the current candidate id
    And a request to retrieve an existing candidate for the CreateOrder api
    And a PATCH call is sent to the api
    And a response should return with status "200"
    And a GET call is sent to the api
    And a response should return with status "200"
    And I verify the Create Order Candidate information is updated
      |firstName  |Terry       |
      |lastName   |AdminOrder1  |
      |dateOfBirth| 1970-12-12  |
    And a request json "LookupInviteAdminNonPre.json" for LookupInvite api
    And a POST call is sent to the api
    And a response should return with status "200"
    When a request json "emailResultTrue.json" for UpdateCandidateEmailFlag api
    And a POST call is sent to the api
    Then a response should return with status "200"
    And a request json "emailResultFalse.json" for UpdateCandidateEmailFlag api
    And a POST call is sent to the api
    And a response should return with status "200"


