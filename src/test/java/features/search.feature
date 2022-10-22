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

Scenario: Search forgot pwd
  Given start the web
  When click on forgot password
  And copy the username and click on the button reset pwd
  Then validate popup

Scenario: Search web page from button
  Given start the web
  When click on txt url
  Then validate web site

Scenario: trying to Add employee without data
  Given start the web
  When try log in
  And login success
  And click on add employee
  Then validate the required fields

