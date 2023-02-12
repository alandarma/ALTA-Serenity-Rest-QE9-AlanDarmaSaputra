Feature: Testing Post Login Unsuccess user Reqres API


  @Tugas @NegatifCase
  Scenario: Post Login Unsuccess user with valid json file
    Given Post login unsuccess user with valid json file
    When Send request post login user unsuccess
    Then Should return status code 400 error
    And Response body should contain error "Missing password"
    And Validate json schema post login unsuccess