@user_profile
Feature: Profile Settings Functionality

  Background:
    Given the user is logged in
    And the user clicks the user icon
    And the user clicks settings label

  Scenario: User can see at least following titles inside personal info under Full name/Email/Phone Number
    Then the user should see following labels
      | Full name       |
      | Email           |
      | Phone number    |
      | Address         |
      | Website         |
      | Twitter         |
      | Language        |
      | Locale          |
      | Profile picture |

  Scenario: User can change "Full name" info under Profile Settings page
    And the user enters the name "Richard L. Link"
    Then the user should be able to see the "Richard L. Link" as the name

  Scenario: User can make "Phone number" info as private under Profile Settings page
    And the user clicks the phone icon-triangle
    And the user clicks the private label
    Then the user should see the private is selected

  Scenario: User can see the current local time under the Local dropdown
    Then the user should see the localtime in page

  Scenario: User can change profile picture
    When the user clicks on the upload profile picture button
    And the user uploads a new picture
    Then the user should see the new picture as the profile picture

  Scenario: User can change language settings
    When the user selects a new language from the language dropdown
    Then the user should see the application in the new language

  Scenario: User can delete their account
    When the user clicks on the delete account button
    Then the user should see the change of text to "Request account deletion sent!"



