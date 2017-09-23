Feature: Navigate to Login page of Ebay
Scenario: Open login page of Ebay
Given We have ebay url as "https://www.ebay.in/"
When we click on sign in
Then login page open successfuly as Sign in tag appears
