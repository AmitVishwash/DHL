Feature: Freight Time Calculator

  Scenario: User should be able to see the freight transit time page
    Given the user is on freight transit time calculator application
    Then the user should be able to see the DHL Freight Transit time calculator page

  Scenario Outline: User should be able to select a origin country
    Given the user is on freight transit time calculator application
    Then the user should be able to select origin country "<originCountry>"

    Examples:
      |originCountry|
      |HU           |

 Scenario Outline: User should be able to select a destination country
    Given the user is on freight transit time calculator application
    Then the user should be able to select the destination country "<destinationCountry>"
    Examples:
      |destinationCountry|
      |AT                |

  @positive1
  Scenario Outline: User should be able to see the freight transit time for different country
    Given the user is on freight transit time calculator application
    And the user selects the origin country code "<originCountry>"
    And the user provides origin post code "<originPostCode>"
    And the user provides destination post code "<destinationPostCode>"
    And the user clicks on Calculate button
    Then the user should be able to see the transit time result

    Examples:
      |originCountry|originPostCode|destinationPostCode|
      |HU            |1051          |17141	           |


  Scenario Outline: User should be able to see an error message for invalid postcode
    Given the user is on freight transit time calculator application
    And the user provides origin post code "<originPostCode>"
    And the user provides destination post code "<destinationPostCode>"
    And the user clicks on Calculate button
    Then the user should be able to see the post code error message
    Examples:
      |originPostCode|destinationPostCode|
      |101          |1115              |

  @positive
  Scenario Outline: User should be able to see the freight time for same country
    Given the user is on freight transit time calculator application
    And the user provides origin post code "<originPostCode>"
    And the user provides destination post code "<destinationPostCode>"
    And the user clicks on Calculate button
    Then the user should be able to see the transit time result
    Examples:
      |originPostCode|destinationPostCode|
      |11351          |11115              |




