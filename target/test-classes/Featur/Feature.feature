
Feature: Product Occurance Validation

  Scenario: Validating product occurance using keyword
    Given Logging into Greenkart Page
    When Enters "tom" and checks if product is present
    Then Enters "tom" in Top Deals and checks both products from green cart page and top deal page are same
    


