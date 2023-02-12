Feature: Testing Patch update user Reqres API

  @Tugas @PositifCase
  Scenario: Patch Update User with valid json file
    Given Patch update user with id 2 and with valid json
    When Send request patch update user
    Then Status code should be 200
    And Response body name should be "morpheus" and job "zion resident"
    And Validate json schema patch user


    @Tugas @NegatifCase
      Scenario: Patch Update User with invalid json
      Given Patch update user with id 2 and with invalid json
      When Send request patch update user
      Then Status code should be 400



  @Tugas @NegatifCase
    Scenario Outline: Patch update user with invalid path
      Given Patch update user with valid json with invalid "<id>"
      When Send request patch update user
      Then Should return status code 400
      Examples:
        | id     |
        | 8%^&09 |