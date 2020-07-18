Feature: Place Validation API Test

# -------POST API Test---------------------
@APITest @APITestPost
Scenario Outline: Verify that place is added successfully using add place post api 
Given Add a place payload with "<name>" "<language>" and "<address>" 
When User calls "AddPlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"

Examples:

|name 										| language  									| address 					  					|
|Scenario1_AddPlace_name  |	Scenario1_AddPlace_language |	Scenario1_AddPlace_address		|
|Scenario2_AddPlace_name  |	Scenario2_AddPlace_language	|	Scenario2_AddPlace_address		|


# -------GET API Test---------------------
@APITest @APITestGet
Scenario Outline: Verify that GET API is successfully getting the places
Given Add a place payload with "<name>" "<language>" and "<address>" 
When User calls "AddPlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"
When Verify the "name" field value as "<name>" when user calls the "GetPlaceAPI" 

Examples:

|name 										| language  									| address 					  					|
|Scenario1_AddPlace_name  |	Scenario1_AddPlace_language |	Scenario1_AddPlace_address		|


# -------PUT API Test---------------------
@APITest @APITestPut
Scenario Outline: Verify that PUT API is successfully updating the places
Given Add a place payload with "<name>" "<language>" and "<address>" 
When User calls "AddPlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"
When Update a place payload with "<updatedAddress>" and "<key>"
And User calls "UpdatePlaceAPI" with "PUT" http request
Then "msg" in response body is "Address successfully updated"

Examples:

|name 		                | language                    | address 					         | updatedAddress                | key                         |
|Scenario1_AddPlace_name  |	Scenario1_AddPlace_language |	Scenario1_AddPlace_address | Scenario1_UpdatePlace_address | Scenario1_UpdatePlace_key   |



