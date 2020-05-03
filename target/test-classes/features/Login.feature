Feature: Login feature
  As user, I want to be able to log in with etsy account, as well as with google
  and facebook accounts.
  @wip
  Scenario: Login with etsy credentials (positive)
    Given use clicks on get started
    When user logs in with etsy credentials
    Then user verifies that etsy logo is displayed