Feature: Testing Delete user Reqres API

  @Tugas @PositifCase
  Scenario Outline: Delete user
    Given Delete users with valid id <id>
    When Send request delete user
    Then Status code should be 204 No content
    Examples:
      |id|
      |2 |

    @Tugas @NegatifCase
    Scenario Outline: Delete user with invalid id
      Given Delete users with invalid id "<id>"
      When Send request delete user
      Then Status code should be 204 No content
      Examples:
        | id   |
        | 1^#@ |