Feature: Testing Reqres API for Single User Endpoint

  @Tugas
  Scenario Outline: Get single user with valid id
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 200
    And Validate json schema single user
    Examples:
      | id |
      | 1  |
      | 2  |

    @Tugas @NegatifCase
      Scenario Outline: Get list user with invalid parameter page
      Given Get single user with invalid id "<id>"
      When Send request get single user
      Then Should return status code 404
      Examples:
        | id            |
        | dsasadasdsada |
        | 1213213       |