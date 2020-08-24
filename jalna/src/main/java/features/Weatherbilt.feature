Feature: Verify weatherbilt apis task2.1

 @api 
Scenario Outline: Get the weather condition
	Given I have api url
		When I trigger api request with correct "<Coordinates>"
		Then I receive the correct payload and Information "200"
		Examples:
		|Coordinates|
		|Scenario1|  


