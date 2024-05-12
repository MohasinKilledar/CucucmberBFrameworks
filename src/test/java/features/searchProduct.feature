

Feature: Search and place the order for Products 
  
  Scenario: Search Experience of the product in both home and offers page
  
   
    Given user is on GreenKart landing page
    When user searched with shortname called as "Tom" and extarcted actual name of the product
    Then user searched for "Tom" shortname in offers page
    And validate product name in offers page matches with Landing page
    

 