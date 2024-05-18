#User Story 2
#As a user, I want to see all the modules and username after login so that I can navigate to the required module.
  #Acceptance Criteria:
    #1. User should be able to see the module after login.
    #2. User should be able to see below modules after login.
      #   Files
      #   Activity
      #   Gallery
      #   Talk
      #   Calendar
      #   Deck
      #   Announcement

    #3. User should be able to see the username after login.
    #4. User should be able to see the search box after login.
    #5. User should be able to see the notifications after login.
    #6. User should be able to see the user icon after login.
    #7. User should be able to see the profile and settings after clicking on the user icon.

@dashboard
Feature: Dashboard Functions

  Background:
    Given the user is logged in

  Scenario: Display Modules
    Then the user should be able to see below modules
      | Files         |
      | Activity      |
      | Gallery       |
      | Talk          |
      | Calendar      |
      | Deck          |
      | Announcements |


  Scenario: Search Functionality
    When the user enters "galaxy" into the search box
    Then the user should see search results related to "galaxy"

  Scenario: Display Notifications
    Then the user should be able to see their notifications

  Scenario: Access User Settings
    When the user clicks on the user icon
    Then the user should be able to see their profile and settings

  Scenario: Access User Contact
    When the user clicks on the user icon
    Then the user should be able to see their contact menu