Feature: Login Page Aplikasi Kasir Aja

  Scenario: Success Login
    Given Halaman login kasir Aja
    When input username
    And input password
    And click login button
    Then User in on dashboard page

