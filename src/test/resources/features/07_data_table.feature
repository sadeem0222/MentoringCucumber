Feature: Data Table Test

  @DataTable
  Scenario: Data Table Scenario
    Given user gets list of string
      | Name1 |
      | Name2 |
      | Name3 |
      | Name4 |
      | Name5 |
    When user gets map of string
      | Name1 |22 |
      | Name2 |44 |
      | Name3 |55 |
      | Name4 |55 |
      | Name5 |33 |
    And user gets list of list of string
      | John   | Doe    | 35 | New York |
      | Mary   | Allen  | 43 | Berlin   |
      | Tom    | Hawk   | 12 | London   |
      | Bob    | Jessie | 35 | Paris    |
      | Cedric | Mal    | 15 | Rome     |
      | Tim    | Carter | 6  | Riyad    |
      | Kevin  | Hook   | 60 | Sydney   |

