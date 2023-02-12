Feature: Testing get list user Reqres API

  @Latihan @PositifCase
  Scenario Outline: Get list user with valid page
    Given Get list user with valid page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    And Validate json schema get list user
    Examples:
      | page |
      | 1    |
      | 2    |

    @Tugas @NegatifCase
    Scenario Outline: Get list user with invalid page
      Given Get list user with invalid page "<page>"
      When Send request get list user
      Then Should return status code 404
      And Response body page should be "<page>"
      Examples:
        | page     |
        | $#@^#^@  |
        | #^@^#*&^ |

      @Tugas @NegatifCase
      Scenario Outline: Get list user with invalid page
        Given Get list user with invalid page <page>
        When Send request get list user
        Then Should return status code 404
        And Response body page should be <page>
        Examples:
          | page    |
          | 342324  |
          | 2321321 |