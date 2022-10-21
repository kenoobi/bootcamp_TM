Feature: Search

Scenario: Search dresses
  Given start the web
  When try log in
  Then login success

Scenario: Menu options
  Given start the web
  When try log in
  And login success
  And click on each menu option
  Then validate option



