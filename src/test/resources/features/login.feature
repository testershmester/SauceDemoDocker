Feature: Login to https://www.saucedemo.com/

  @api
  Scenario: Login as standard user
    Given Login page is opened
    When STANDARD_USER logs in
    Then Products page is opened

  @ui
  Scenario: Login as standard user
    Given Login page is opened
    When STANDARD_USER logs in
    Then Products page is opened