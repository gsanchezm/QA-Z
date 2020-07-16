Feature: User can login into E'Commerce application

  Background:
    Given I see application opened

  Scenario: User can login with correct credentials
    When I click "My Account" link
    And I enter UserName and Password
      | UserName                    | Password        |
      | gilsanchezts@outlook.com    | NHNKW5@Pjgm4EHY |
    Then I should see the username with hello