Feature: Order makan di restoran

  Scenario: Pelanggan memesan makanan
    Given Pelanggan duduk di restoran
    When Pelanggan melihat menu
    And Pelayan mencatat order
    And Pelayan memberikan order ke dapur
    And Dapur memasak makanan
    Then Makanan siap disajikan
    And Pelayan memberikan kepada pelanggan
    And Pelanggan menikmati
    And Pelanggan membayar