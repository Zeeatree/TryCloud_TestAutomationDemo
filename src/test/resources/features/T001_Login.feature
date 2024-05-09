@login
Feature: Login
  As a user
  I want to be able to log in
  So that I can access the application

  Scenario Outline: Valid login
    Given I am on the login page
    When I log in with "<username>" and "<password>" using "<submitType>"
    Then I should see the url contains "/index.php/apps"
    Examples:
      | username   | password    | submitType   |
      | Employee61 | Employee123 | submitButton |
      | Employee61 | Employee123 | enterKey     |

  @NegativeLogin
  Scenario Outline: Invalid login with wrong username or password
    Given I am on the login page
    When I log in with "<username>" and "<password>" using "<submitType>"
    Then I should see the message "Wrong password."
    Examples:
      | username   | password    | submitType   |
      | 1234       | Employee123 | submitButton |
      | 1234       | 1234        | submitButton |
      | Employee61 | 1234        | submitButton |
      | 1234       | Employee123 | enterKey     |
      | 1234       | 1234        | enterKey     |
      | Employee61 | 1234        | enterKey     |

  @NegativeLogin
  Scenario Outline: Invalid login with empty username or password
    Given I am on the login page
    When I log in with "<username>" and "<password>" using "<submitType>"
    Then I should see the alert "Please fill out this field."
    Examples:
      | username   | password    | submitType   |
      |            | Employee123 | submitButton |
      | Employee61 |             | submitButton |
      |            |             | submitButton |
      |            | Employee123 | enterKey     |
      | Employee61 |             | enterKey     |
      |            |             | enterKey     |

  Scenario: Password visibility
    Given I am on the login page
    When I enter a password
    Then I should see the password as dots


  Scenario: Forgot password
    Given I am on the login page
    Then I should see the forgot password link
    When I click the forgot password link
    Then I should see the "Reset password" button

