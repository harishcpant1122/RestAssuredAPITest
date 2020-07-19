Feature: Place Validation API Test

# -------POST API Test---------------------
@APITest @APITestPost
Scenario Outline: Verify that place is added successfully using add place post api 
Given Create an add place request with "<addPlaceRequest>"
When User calls "AddPlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"

Examples:

|addPlaceRequest 					 | responseStatusCode	|
|Req_AddPlace_Scenario1     |	200     		        |
|Req_AddPlace_Scenario2     |	200     		        |



# -------GET API Test---------------------
@APITest @APITestGet
Scenario Outline: Verify that GET API is successfully getting the places
Given Create an add place request with "<addPlaceRequest>"
When User calls "AddPlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"
When Verify the "name" field value as "<ResponseName>" when user calls the "GetPlaceAPI" for "<addPlaceRequest>"

Examples:

|addPlaceRequest  					 | responseStatusCode |ResponseName            |
|Req_GetPlace_Scenario1     |	responseStatusCode  |Frontline house         |


# -------PUT API Test---------------------
@APITest @APITestPut
Scenario Outline: Verify that PUT API is successfully updating the places
Given Create an add place request with "<addPlaceRequest>"  
When User calls "AddPlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"
When Create an update place request with "<updatePlaceRequest>"
And User calls "UpdatePlaceAPI" with "PUT" http request
Then "msg" in response body is "Address successfully updated"

Examples:

|addPlaceRequest					  | responseStatusCode	| updatePlaceRequest        |
|Req_AddPlace_Scenario1     |	200     		        | Req_updatePlace_Scenario1 |


