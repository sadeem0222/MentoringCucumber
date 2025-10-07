Feature: Add Record

  @AddRecord
  Scenario: Add 25 records and verify
    Given user visits "https://claruswaysda.github.io/addRecordWebTable.html"
    When enter data
      | Name1  | 15 | Germany    |
      | Name2  | 25 | Canada     |
      | Name3  | 20 | UK         |
      | Name4  | 30 | USA        |
      | Name5  | 10 | Australia  |
      | Name6  | 40 | Germany    |
      | Name7  | 22 | Canada     |
      | Name8  | 35 | UK         |
      | Name9  | 28 | USA        |
      | Name10 | 19 | Australia  |
      | Name11 | 33 | Germany    |
      | Name12 | 26 | Canada     |
      | Name13 | 31 | UK         |
      | Name14 | 24 | USA        |
      | Name15 | 18 | Australia  |
      | Name16 | 29 | Germany    |
      | Name17 | 21 | Canada     |
      | Name18 | 32 | UK         |
      | Name19 | 27 | USA        |
      | Name20 | 23 | Australia  |
      | Name21 | 36 | Germany    |
      | Name22 | 20 | Canada     |

    Then table should contain 25 rows of data
    Then close browser
