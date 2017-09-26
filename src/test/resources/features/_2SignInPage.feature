Feature: Login to Ebay
Scenario: Login with valid credentials
Given user is at sign in page
When user enter below details
|User Name|Password|
|nicks4uever@gmail.com|Ins24me*|
Then user logged in successfully
