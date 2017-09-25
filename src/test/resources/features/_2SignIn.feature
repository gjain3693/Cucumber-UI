Feature: Login to Ebay
Scenario: Login with valid credentials
Given user is at sign in page
When user enter username "<User Name>" and password "<Password>"
|User Name|Password|
|nicks4uever@gmail.com|Ins24me*|
Then user logged in successfully