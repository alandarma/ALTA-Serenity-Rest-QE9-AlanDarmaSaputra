Feature: Testing Reqres API ALTA QE8

  # tidak boleh ada spasi setelah petik dua ":"
  # Scenario Outline: --> menggunakan examples
  # Scenario: --> tidak menggunakan examples

  # Get
  @Latihan
  Scenario Outline: Get list user with valid parameter page reqres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body should page should be <page>
  Examples:
    | page |
    | 1    |
    | 2    |
  # POST
  #Anotasi

#  PUT
  @Latihan
  Scenario Outline: Put update user with valid json
    Given Put update user with json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "<name>" and job "<job>"
    Examples:
      | name          |  | job  |
      | Andreas Bagas |  | SDET |

#    Delete
    @Latihan
    Scenario Outline: Delete users with valid id
      Given Delete users with valid id <id>
      When Send request delete user
      Then Should return status code 204
      Examples:
        | id |
        | 1  |
        | 2  |
