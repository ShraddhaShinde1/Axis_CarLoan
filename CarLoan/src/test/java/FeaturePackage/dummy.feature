Feature: I am not eligible for a Car Laon as per the Axis policy criteria

Scenario: I am not an Axis Bank customer and want to apply for a Car loan

Given that I am a new user to Axis Bank 
And I navigate to Axis Bank website
And I click on the Apply Now link
And I select the Car loan option
And I navigate to the Car Laon application page
And I enter all the required details
When I click on the Submit

Then I should be able to validate the Unsuccessfull Message been displayed on the screen saying We regret to inform you that your loan application doesn’t meet our policy criteria
And I click on OK button.
