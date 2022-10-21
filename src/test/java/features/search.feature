Feature: Search

Scenario: Search dresses
  Given start the web
  When try log in
  Then login success

Scenario: Search options
  Given start the web
  When try log in
  And login success
  And click on each menu option
  Then validate option


  Scenario Outline: Search PIM
    Given start the web
    When try log in
    And login success
    And search Employee id <employee_id>
    Then validate employee id

    Examples:
      |employee_id|
      |0099|
