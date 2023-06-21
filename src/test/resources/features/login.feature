Feature: Login to https://www.saucedemo.com/

  @api
  Scenario: Login API as standard user
    Given Login page is opened
    When STANDARD_USER logs in
    Then Products page is opened

  @ui
  Scenario: Login UI as standard user
    Given Login page is opened
    When STANDARD_USER logs in
    Then Products page is opened