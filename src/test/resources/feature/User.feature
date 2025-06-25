Feature: Validate GET Users API

  Scenario: Validate success response for valid user id
    When I send a GET request to fetch user with id 2
    Then The response code should be 200
    And The email should be "janet.weaver@reqres.in"

  Scenario: Validate error response for invalid user id
    When I send a GET request to fetch user with id 23
    Then The response code should be 404

  Scenario: Validate success response when adding user
    When I send a POST request to add valid user
    Then The response code should be 201
    And I should receive valid id

  Scenario: Validate user data updation
    When I send a PUT request to update user data with id 2
    Then The response code should be 200
    And I should receive updated data

  Scenario: Validate user data updation
    When I send a PATCH request to update user data with id 2
    Then The response code should be 200
    And I should receive updated data

  Scenario: Validate user deletion
    When I send a DELETE request to delete a user with id 2
    Then The response code should be 204
