Feature: Search

Scenario Outline: Login successful
  Given start the web
  When try log in with <username> and <password>
  Then login success

  Examples:
  | username | password |
  | Admin | admin123 |
  | | |
  | test1 | test123 |

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

Scenario: log out
  Given start the web
  When try log in
  And login success
  And click on profile and click log out
  Then validate the log out

Scenario: Check about profile fields
  Given start the web
  When try log in
  And login success
  And click on about button into profile
  Then validate the profile fields

Scenario: check time button and behavior
  Given start the web
  When try log in
  And login success
  And click on time option
  Then Validate found data

Scenario: check dashboard option
  Given start the web
  When try log in
  And login success
  And click on dashboard option
  Then validate image of launching soon

Scenario: check the directory data
  Given start the web
  When try log in
  And login success
  And click on directory option
  Then validate the data of the directory

Scenario: check buzz option
  Given start the web
  When try log in
  And login success
  And click on buzz option
  Then validate image of launching soon

Scenario: Check support window
  Given start the web
  When try log in
  And login success
  And click on support button
  Then validate the support window

Scenario:  hide the menu
  Given start the web
  When try log in
  And login success
  Then click on button hide menu and validate

Scenario: Try to search password
  Given start the web
  When try log in
  And login success
  And click profile and password option
  Then validate the update password screen

Scenario: Search Admin menu option in the search field
  Given start the web
  When try log in
  And login success
  And Search Admin in the search field
  Then validate that the found menu option is correct

Scenario: Search my info
  Given start the web
  When try log in
  And login success
  And click on my info menu option
  Then validate that the panel my info is available

Scenario: Log out into maintenance menu option
  Given start the web
  When try log in
  And login success
  And click on maintenance option
  And type the admin password
  Then validate the window

Scenario: Search vacancies availability
  Given start the web
  When try log in
  And login success
  And click on menu recruitment option and click on the tag vacancies
  Then validate if exist available vacancies

Scenario: check correct log out
  Given start the web
  When try log in
  And login success
  And click on profile and log out option
  Then validate log out success