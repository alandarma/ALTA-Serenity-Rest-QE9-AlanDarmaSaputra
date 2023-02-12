Feature: Testing update user Reqres API

  @Tugas @PositifCase
  Scenario: Put update user
    Given Put update user with id 2 and with valid json file
    When Send request put update user
    Then Status code should be 200
    And Response body name should be "morpheus update" and job "zion resident update"
    And Validate json schema update user

    @Tugas @NegatifCase
  Scenario: Put update user
    Given Put update user with id "2" and with invalid json file
    When Send request put update user
    Then Status code should be 400
    And Response body name should be "Andreas Bagas Update" and job "student"
