Feature: failed

  @failed
  Scenario:
    Given  flied
    When print from one to hundred on console
    Then assert if Cucumber contains