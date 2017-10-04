Feature: Help page of Ebay
Scenario: User will navigate to Help
Given user logged into Ebay
When user click on Help & Contact link
Then user will navigate to "Customer Service" page

Scenario Outline: Catagories available at Customer Service page
Given user logged into Ebay
When user navigated to "Customer Service" page
Then user will find below catagory for help "<Options>"
Examples:
|Options|
|Popular solutions|
|Browse by topic|