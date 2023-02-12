Feature: Testing Register user Reqres API

  @Tugas @PositifCase
  Scenario: Post register new user with valid json
    Given Post register user with valid json
    When Send request post register
    Then Should return status code 200
    And Response body id should be 4 and token "QpwL5tke4Pnpja7X4"
    And Validate json schema register user

  @Tugas @NegatifCase
    Scenario: Post register new user with invalid json
    Given Post register user with invalid json
    When Send request post register
    Then Should return status code 400
    And Validate json schema failed register user