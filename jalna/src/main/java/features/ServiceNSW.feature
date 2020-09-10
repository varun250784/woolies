Feature: Verify Service NSW site Task1 Scenrio1 and Scenario2


@ui		
Scenario:
Given I am a user navigating to the url "https://www.service.nsw.gov.au/"
 And I search for "Find a Service NSW location"
Then I am re-directed to the "Search | Service NSW" page 
When I click on the "Find a Service NSW location" link
Then I am re-directed to the "Find a Service NSW location | Service NSW" page
 
@ui
Scenario:
Given I am a user on the "https://www.service.nsw.gov.au/service-centre" page
When I search for "Marrickville" in the Search by suburb, postcode or current location field
Then I should see "Marrickville Service Centre" and its address returned in the results
