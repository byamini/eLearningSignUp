Feature: Elearning Singup

Scenario: Launch elearning and click on signup
Given elearning website is launched
When signup button is visible
Then user clicked on signup

Scenario: Fill registration form
Given Registration page is loaded
When Fill all details in registration page
Then click on register and check next button is visible
And click on next after successful registration

Scenario: Compose message
Given user is on messages section under profile
When compose a message by filling all fields
Then send a message


